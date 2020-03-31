package com.example.controller;

import com.example.config.R;
import com.example.entities.Dept;
import com.example.service.DeptService;
import lombok.AllArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Djh
 */
@AllArgsConstructor
@RequestMapping("dept")
@RestController
public class DeptController {

    private DiscoveryClient client;

    private DeptService deptService;

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

    @GetMapping("/discovery")
    public Object discovery() {
        List<String> list = client.getServices();
        System.out.println("***********" + list);
        List<ServiceInstance> srvList = client.getInstances("microservicecloud-dept");
        for (ServiceInstance e: srvList) {
            System.out.println(e.getServiceId() + "\t" + e.getHost() + "\t" + e.getPort() + "\t" + e.getUri());
        }

        return this.client;
    }
}
