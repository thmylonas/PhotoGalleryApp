package com.thomasmylonas.todo_web_app.services;

import com.thomasmylonas.todo_web_app.entities.Todo;

import java.util.List;

public interface TodoService {

    List<Todo> fetchTodosByRestTemplate();

    List<Todo> fetchTodosByWebClient();
}
