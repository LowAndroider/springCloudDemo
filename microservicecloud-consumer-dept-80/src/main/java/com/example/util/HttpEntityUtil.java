package com.example.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class HttpEntityUtil {

    /**
     * 获取表单提交的HttpEntity, content-type将会变为application/x-www-form-urlencoded;charset=UTF-8
     * @param requestObj 请求参数
     * @return 请求实体
     */
    public static HttpEntity<MultiValueMap<String, Object>> getFormHttpEntity(Object requestObj) {
        JSONObject json = (JSONObject) JSON.toJSON(requestObj);
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
        json.forEach((s, object) -> {
            if (object instanceof JSONArray) {
                JSONArray arr = (JSONArray) object;
                arr.forEach(item -> map.add(s, item));
            } else {
                map.add(s, object);
            }
        });

        return new HttpEntity<>(map);
    }
}
