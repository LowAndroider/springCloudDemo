package com.example.controller;

import com.example.config.R;
import com.example.entities.Dept;
import com.example.util.HttpEntityUtil;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author Djh
 */
@AllArgsConstructor
@RestController
@RequestMapping("/consumer/dept")
public class DeptControllerConsumer {

    @Value("${dept.provider.url}:\"\"")
    private String deptProviderUrl;

    private RestTemplate restTemplate;

    @PostMapping()
    public R add(Dept dept) {
        // 默认直接丢对象属于application/json
        HttpEntity<MultiValueMap<String, Object>> httpEntity = HttpEntityUtil.getFormHttpEntity(dept);
        return restTemplate.postForObject(deptProviderUrl + "dept", httpEntity, R.class);
    }

    @GetMapping("/{id}")
    public R get(@PathVariable Long id) {
        String url = deptProviderUrl + "/dept/" + id;
        return restTemplate.getForObject(url, R.class);
    }

    @GetMapping("/list")
    public R list() {
        String url = deptProviderUrl + "/dept/list";
        return restTemplate.getForObject(url, R.class);
    }
}
