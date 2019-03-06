package com.medical.patientinfo.util;

import com.medical.patientinfo.entity.SwaggerJsonEntity;
import org.springframework.web.client.RestTemplate;

/**
 * @author duwen@shein.com
 * @date 2019/3/6 16:50
 */
public class SwaggerJsonUtil {
    private final static String URL = "http://localhost:8001/v2/api-docs";
    public static void getJson() {
        RestTemplate restTemplate = new RestTemplate();
        SwaggerJsonEntity swaggerJsonEntity = restTemplate.getForObject(URL,SwaggerJsonEntity.class);
        System.out.println(swaggerJsonEntity);
    }
}
