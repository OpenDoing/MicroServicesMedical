package com.medical.patientinfo.entity.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author duwen
 * @date 2019/1/14 17:18
 */
@Data
public class MedicalRecordDto {
    private Date visitTime;

    private String hospital;

    private String description;

    private Integer profileId;

    private Integer type;
}
