import com.aleksanderjess.springjavatodo.model.Todo;
import com.aleksanderjess.springjavatodo.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/api/v1/todos")
public class TodoController {

    TodoService _todoService;

    public TodoController(TodoService todoService) {
        this._todoService = todoService;
    }

    @GetMapping("/")
    public List<Todo> index() {
        return _todoService.findAll();
    }

    @GetMapping("/{id}")
    public Todo findById(@PathVariable Long id) {
        return _todoService.findById(id);
    }

    @PostMapping("/")
    public Todo create(@RequestBody Todo todo) {
        return _todoService.save(todo);
    }

    @PutMapping("/{id}")
    public Boolean update(@PathVariable Long id, @RequestBody Todo todo) {
        return _todoService.updateById(id, todo);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable Long id) {
        return _todoService.deleteById(id);
    }

}
