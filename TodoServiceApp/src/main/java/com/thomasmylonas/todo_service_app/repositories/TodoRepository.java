package com.thomasmylonas.todo_service_app.repositories;

import com.thomasmylonas.todo_service_app.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
