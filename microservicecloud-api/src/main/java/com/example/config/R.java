package com.example.config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("返回参数")
public class R<T> {

    @ApiModelProperty("请求返回code")
    public int code;

    @ApiModelProperty("返回提示信息")
    public String msg;

    @ApiModelProperty("返回参数")
    public T data;

    public static R ok(String msg) {
        return ok(msg, null);
    }

    public static R ok() {
        return ok("操作成功！");
    }

    public static R ok(String msg, Object data) {
        return new R(200, msg, data);
    }

    public static R ok(Object data) {
        return ok("请求成功", data);
    }

    public static R error(Object data, String msg) {
        return error(500, data, msg);
    }

    public static R error(int code, Object data, String msg) {
        return new R().setCode(code).setData(data).setMsg(msg);
    }
}
