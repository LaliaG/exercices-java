package org.example.todo_api.controller;

import org.example.todo_api.dto.TodoDTO;
import org.example.todo_api.entity.Todo;
import org.example.todo_api.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    // Endpoint pour créer une nouvelle tâche TODO
    @PostMapping("/create")
    public ResponseEntity<?> createTodo(@RequestBody TodoDTO todoDTO) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Convertir la chaîne de date en objet Date
        Date dueDate;
        try {
            dueDate = dateFormat.parse(todoDTO.getDueDate());
        } catch (ParseException e) {
            return ResponseEntity.badRequest().body("Format de date incorrect. Utilisez yyyy-MM-dd.");
        }

        // Créer un objet Todo à partir des données reçues
        Todo todo = new Todo();
        todo.setTask(todoDTO.getTask());
        todo.setDueDate(dueDate);

        // Sauvegarder la tâche TODO en utilisant le service
        Todo savedTodo = todoService.save(todo);

        // Répondre avec la tâche TODO créée
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTodo);
    }

    @GetMapping("/")
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> todos = todoService.getAllTodos();
        return ResponseEntity.ok(todos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable("id") Long id) {
        Optional<Todo> todo = todoService.getTodoById(id);
        return todo.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        Todo createdTodo = todoService.createTodo(todo);
        return new ResponseEntity<>(createdTodo, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable("id") Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/validate/{isValidate}")
    public ResponseEntity<List<Todo>> getTodosByValidation(@PathVariable("isValidate") boolean isValidate) {
        List<Todo> todos = todoService.getTodosByValidation(isValidate);
        return ResponseEntity.ok(todos);
    }
}
