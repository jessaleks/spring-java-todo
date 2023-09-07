package com.aleksanderjess.springjavatodo.service;

import com.aleksanderjess.springjavatodo.model.Todo;
import com.aleksanderjess.springjavatodo.repository.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {
    private final TodoRepository _todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this._todoRepository = todoRepository;
    }


    public final List<Todo> findAll() {
        return (List<Todo>) _todoRepository.findAll();
    }

    public final Todo findById(Long id) {
        Optional<Todo> todo = _todoRepository.findById(id);

        return todo.orElse(null);
    }

    public final Todo save(Todo todo) {
        return _todoRepository.save(todo);
    }

    public final Boolean deleteById(Long id) {
        try {
            _todoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public final Boolean updateById(Long id, Todo todo) {
        try {
            Optional<Todo> todoOptional = _todoRepository.findById(id);
            if (todoOptional.isPresent()) {
                Todo todoToUpdate = todoOptional.get();
                todoToUpdate.setTitle(todo.getTitle());
                todoToUpdate.setDescription(todo.getDescription());
                todoToUpdate.setDone(todo.getDone());
                todoToUpdate.setDateTime(todo.getDateTime());
                _todoRepository.save(todoToUpdate);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
