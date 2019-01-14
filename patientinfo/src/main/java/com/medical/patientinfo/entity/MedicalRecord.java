package com.medical.patientinfo.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author duwen
 * @date 2019/1/14 13:28
 */
@Entity
@Table(name = "medical_record")
@Data
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "visit_time")
    private Date visitTime;

    @Column(name = "create_time")
    private LocalDateTime createTime;

    @Column(name = "hospital")
    private String hospital;

    @Column(name = "description")
    private String description;

    @Column(name = "profile_id")
    private Integer profileId;

    @Column(name = "type")
    private Integer type;
}
