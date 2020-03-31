package com.example.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class R {

    public int code;

    public String msg;

    public Object data;

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
