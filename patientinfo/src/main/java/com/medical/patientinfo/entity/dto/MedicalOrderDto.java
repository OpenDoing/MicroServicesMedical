package com.medical.patientinfo.entity.dto;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author duwen
 * @date 2019/1/14 17:39
 */
@Data
public class MedicalOrderDto {

    private Integer profileId;

    private String username;

    private Integer doctorId;

    private Date appointmentDate;

    private Integer appointmentTime;

    private String strTime;

    private String status;

    private String diseaseInput;

    private Float price;

    private Integer record;

    private String advice;

    private Integer code;

    private String caseFlag;
}
