package com.medical.patientinfo.dao;

import com.medical.patientinfo.entity.MedicalRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author duwen
 * @date 2019/1/14 13:30
 */
@Repository
public interface MedicalRecordRepo extends JpaRepository<MedicalRecord, Integer> {
    /**
     * 分页查询患者病历信息
     * @param profileId 患者id
     * @param pageable 分页参数
     * @return Page
     */
    Page<MedicalRecord> findByProfileId(Integer profileId, Pageable pageable);
}
