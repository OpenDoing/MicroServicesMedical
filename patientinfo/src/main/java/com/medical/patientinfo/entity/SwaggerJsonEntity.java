package com.medical.patientinfo.entity;

import lombok.Data;

import java.util.Map;

/**
 * @author duwen@shein.com
 * @date 2019/3/6 17:00
 */
@Data
public class SwaggerJsonEntity {

    private String basePath;

    private String host;

    private String swagger;

    private Map<String, Map<String, RequestEntity>> paths;

    @Data
    public static class RequestEntity {

        private String[] tags;

        private String summary;

        private String operationId;

        private String[] consumes;

        private String[] produces;

        private Parameter[] parameters;
    }

    @Data
    public static class Parameter {

        private String in;

        private String name;

        private String description;

        private String required;

    }
}
