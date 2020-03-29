package com.example.controller;

import com.example.config.R;
import com.example.entities.Dept;
import com.example.service.DeptService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("dept")
@RestController
public class DeptController {

    private DeptService deptService;

    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }


    @PostMapping("")
    public R add( Dept dept) {
        deptService.save(dept);
        return R.ok();
    }

    @GetMapping("/{id}")
    public R get(@PathVariable Long id) {
        Dept dept = deptService.getById(id);
        return R.ok(dept);
    }

    @GetMapping("/list")
    public R list() {
        List<Dept> list = deptService.list();
        return R.ok(list);
    }
}
