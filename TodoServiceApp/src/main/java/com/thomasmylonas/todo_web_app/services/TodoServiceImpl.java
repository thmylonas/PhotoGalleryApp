package com.thomasmylonas.todo_web_app.services;

import com.thomasmylonas.todo_web_app.entities.Todo;
import com.thomasmylonas.todo_web_app.repositories.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service(value = "todoService")
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    @Value(value = "${jsonplaceholder.url}")
    private String jsonplaceholderUrl;

    private final TodoRepository todoRepository;
    private final RestTemplate restTemplate;
    private final WebClient webClient;

    @Override
    public List<Todo> fetchTodosByRestTemplate() {

        ResponseEntity<List<Todo>> todosWrapperResponseEntity = restTemplate.exchange(
                jsonplaceholderUrl + "/todos",
                HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                });

        List<Todo> todos = todosWrapperResponseEntity.getBody();
        if (todos != null) {
            todoRepository.saveAll(todos);
        }
        return todos;
    }

    @Override
    public List<Todo> fetchTodosByWebClient() {

        List<Todo> todos = webClient
                .get()
                .uri("/todos")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Todo>>() {
                })
                .block();

        if (todos != null) {
            todoRepository.saveAll(todos);
        }
        return todos;
    }
}
