package ru.gb.HomeWork4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.gb.HomeWork4.models.Task;
import ru.gb.HomeWork4.services.TaskService;

@Controller
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public String viewProducts(Model model) {
        var tasks = taskService.findAll();
        model.addAttribute("tasks", tasks);

        return "tasks.html";
    }

    @PostMapping("/tasks")
    public String addProduct(
            Task t,
            Model model
    ) {
        taskService.addTask(t);

        var tasks=taskService.findAll();
        model.addAttribute("tasks", tasks);

        return "tasks.html";
    }

    @GetMapping("/task-delete/{id}")
    public String delTasksById(@PathVariable("id") int id) {
        taskService.delById(id);
        return "redirect:/tasks";
    }
    @GetMapping("/task-update/{id}")
    public String updateTasksById(@PathVariable("id") int id,Model model) {
        var task=taskService.getById(id);
        model.addAttribute("task",task);
        return "update.html";
    }
    @PostMapping("/task-update")
    public String updateTask(
            Task t
    ) {
        taskService.updateById(t);
        return "redirect:/tasks";
    }

}
