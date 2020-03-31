package com.example.service.factory;

import com.example.config.R;
import com.example.entities.Dept;
import com.example.service.DeptClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author Djh
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {

    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public R add(Dept dept) {
                return null;
            }

            @Override
            public R get(Long id) {
                Dept dept = new Dept().setDeptNo(id)
                        .setDName("该ID: " + id + "没有对应的信息, Consumer客服端提供的降级信息，此刻服务Provider已经关闭")
                        .setDbSource("no database");

                return R.error(dept, "");
            }

            @Override
            public R list() {
                return null;
            }
        };
    }
}
