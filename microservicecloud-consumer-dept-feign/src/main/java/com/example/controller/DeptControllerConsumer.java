package com.example.controller;

import com.example.config.R;
import com.example.entities.Dept;
import com.example.service.DeptClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author Djh
 */
@AllArgsConstructor
@RestController
@RequestMapping("/consumer/dept")
public class DeptControllerConsumer {

    private DeptClientService deptClientService;

    @PostMapping()
    public R add(Dept dept) {
        return deptClientService.add(dept);
    }

    @GetMapping("/{id}")
    public R get(@PathVariable Long id) {
        return deptClientService.get(id);
    }

    @GetMapping("/list")
    public R list() {
        return deptClientService.list();
    }
}
