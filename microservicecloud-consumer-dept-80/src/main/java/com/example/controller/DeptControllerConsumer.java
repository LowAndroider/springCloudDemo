package com.example.controller;

import com.example.config.R;
import com.example.entities.Dept;
import com.example.util.HttpEntityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer/dept")
public class DeptControllerConsumer {

    private static final String REST_URL_PREFIX = "http://localhost:8001/dept";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping()
    public R add(Dept dept) {
        // 默认直接丢对象属于application/json
        HttpEntity httpEntity = HttpEntityUtil.getFormHttpEntity(dept);
        return restTemplate.postForObject(REST_URL_PREFIX, httpEntity, R.class);
    }

    @GetMapping("/{id}")
    public R get(@PathVariable Long id) {
        String url = REST_URL_PREFIX + "/" + id;
        return restTemplate.getForObject(url, R.class);
    }

    @GetMapping("/list")
    public R list() {
        String url = REST_URL_PREFIX + "/list";
        return restTemplate.getForObject(url, R.class);
    }
}
