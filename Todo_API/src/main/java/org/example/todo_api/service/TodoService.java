package org.example.todo_api.service;

import org.example.todo_api.dao.TodoRepository;
import org.example.todo_api.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    public List<Todo> getTodosByValidation(boolean isValidate) {
        return todoRepository.findByIsValidate(isValidate);
    }

    public Todo save(Todo todo) {
        return todo;
    }
}
