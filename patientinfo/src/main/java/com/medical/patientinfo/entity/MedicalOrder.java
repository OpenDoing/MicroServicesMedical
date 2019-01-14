package com.medical.patientinfo.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author duwen
 * @date 2019/1/14 16:39
 */
@Entity
@Table(name = "`order`")
@Data
public class MedicalOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "profile_id")
    private Integer profileId;

    @Column(name = "username")
    private String username;

    @Column(name = "doctor_id")
    private Integer doctorId;

    @Column(name = "appointment_date")
    private Date appointmentDate;

    @Column(name = "appointment_time")
    private Integer appointmentTime;

    @Column(name = "str_time")
    private String strTime;

    @Column(name = "status")
    private String status;

    @Column(name = "disease_input")
    private String diseaseInput;

    @Column(name = "price")
    private Float price;

    @Column(name = "record")
    private Integer record;

    @Column(name = "advice")
    private String advice;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "code")
    private Integer code;

    @Column(name = "case_flag")
    private String caseFlag;
}
