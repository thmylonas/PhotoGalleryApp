package com.thomasmylonas.todo_web_app;

import com.thomasmylonas.todo_web_app.entities.Todo;
import com.thomasmylonas.todo_web_app.services.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
@PropertySource(value = "classpath:properties/properties.properties")
public class TodoWebAppApplication {

    private final TodoService todoService;

    public static void main(String[] args) {
        SpringApplication.run(TodoWebAppApplication.class, args);
    }

    @Bean
    protected CommandLineRunner commandLineRunner() {
        return args -> {
            //List<To-do> todos = todoService.fetchTodosByRestTemplate();
            List<Todo> todos = todoService.fetchTodosByWebClient();
            todos.forEach(System.out::println);
        };
    }
}
