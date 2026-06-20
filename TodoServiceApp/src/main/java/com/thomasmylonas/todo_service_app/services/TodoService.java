package com.thomasmylonas.todo_service_app.services;

import com.thomasmylonas.todo_service_app.entities.Todo;

import java.util.List;

public interface TodoService {

    List<Todo> fetchTodosByRestTemplate();

    List<Todo> fetchTodosByWebClient();
}
