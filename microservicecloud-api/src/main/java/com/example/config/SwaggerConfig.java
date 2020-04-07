/**
 * Copyright 2018-2020 fancyliu & liufan (https://gitlab.gyenno.com/gyenno_backend_service/new-gyenno-service-overview)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * swagger配置类
 *
 * @author Djh
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(List<ResponseMessage> responseMessageList) {
        // 屏蔽token
//        ParameterBuilder tickerPar = new ParameterBuilder();
//        List<Parameter> pars = new ArrayList<>();
//        tickerPar.name("Authorization").description("token值")
//                .modelRef(new ModelRef("string"))
//                .parameterType("header").required(true);
//        pars.add(tickerPar.build());


        return docket(responseMessageList)
                .groupName("v1.0.0")
//                .globalOperationParameters(pars)
                .apiInfo(apiInfo())
                .select()
                // 扫描的包所在位置
                .apis(RequestHandlerSelectors.basePackage("com.example"))
                // 扫描的 URL 规则
                .paths(PathSelectors.regex("^((?!export).)*$"))
                .build();
    }

    @Bean
    public List<ResponseMessage> responseMessageList() {
        List<ResponseMessage> responseMessageList = new ArrayList<>();
        responseMessageList.add(new ResponseMessageBuilder().code(404).message("找不到资源").build());
        responseMessageList.add(new ResponseMessageBuilder().code(409).message("业务逻辑异常").build());
        responseMessageList.add(new ResponseMessageBuilder().code(422).message("参数错误").build());
        responseMessageList.add(new ResponseMessageBuilder().code(500).message("服务器内部错误").build());
        responseMessageList.add(new ResponseMessageBuilder().code(462).message("sql or database error!").build());
        return responseMessageList;
    }

    private static Docket docket(List<ResponseMessage> responseMessageList) {
        return new Docket(DocumentationType.SWAGGER_2)
                .globalResponseMessage(RequestMethod.GET, responseMessageList)
                .globalResponseMessage(RequestMethod.POST, responseMessageList)
                .globalResponseMessage(RequestMethod.PUT, responseMessageList)
                .globalResponseMessage(RequestMethod.DELETE, responseMessageList);
    }

//    @Bean
//    public Docket exportDocket(List<ResponseMessage> responseMessageList) {
//        return docket(responseMessageList)
//                .groupName("v1.0.0-export")
//                .apiInfo(apiInfo())
//                .select()
//                // 扫描的包所在位置
//                .apis(RequestHandlerSelectors.basePackage("cn.stylefeng.guns.modular.system.controller"))
//                // 扫描的 URL 规则
//                .paths(PathSelectors.regex(".*export.*"))
//                .build();
//    }

    private ApiInfo apiInfo() {
        // 联系信息
        Contact contact = new Contact("后台管理微服务", "localhost:58080/swagger-ui.html", "gyenno@163.com");
        return new ApiInfoBuilder()
                // 大标题
                .title("后台管理微服务")
                // 描述
                .description("new-gyenno-service-admin-center后台管理服务")
                // 服务条款 URL
                .termsOfServiceUrl("localhost:58080/swagger-ui.html")
                .contact(contact)
                // 版本
                .version("1.0.0")
                .build();
    }
}