package com.example.service;

import com.example.config.R;
import com.example.entities.Dept;
import com.example.service.factory.DeptClientServiceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Djh
 * @see com.example.controller.DeptController
 */
@FeignClient(value = "${dept.provider.name}/dept", fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    @PostMapping("")
    R add(Dept dept);

    @GetMapping("/{id}")
    R get(@PathVariable("id") Long id);

    @GetMapping("/list")
    R list();
}
