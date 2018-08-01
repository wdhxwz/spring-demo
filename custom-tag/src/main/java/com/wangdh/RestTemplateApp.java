package com.wangdh;

import com.krista.extend.utils.JsonUtil;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @Auther: dw_wanghonghong
 * @Date: 2018/8/1 17:19
 * @Description:
 */
public class RestTemplateApp {
    private static RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args){
        String response = restTemplate.getForObject("http://127.0.0.1:8080/getJson.do",String.class);
        Map map = JsonUtil.toObject(response,Map.class);

        System.out.println(response);
    }
}
