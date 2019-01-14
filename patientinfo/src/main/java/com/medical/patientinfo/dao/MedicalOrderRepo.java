package com.medical.patientinfo.dao;

import com.medical.patientinfo.entity.MedicalOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * @author duwen
 * @date 2019/1/14 16:47
 */
@Repository
public interface MedicalOrderRepo extends JpaRepository<MedicalOrder, Integer> {

    /**
     * 根据患者id查询订单
     * @param profileId 患者id
     * @return 患者的所有订单
     */
    List<MedicalOrder> findByProfileId(Integer profileId);

    /**
     * 根据患者Id和订单Id来获取特定订单
     * @param profileId 患者Id
     * @param OrderId 订单Id
     * @return 特定订单
     */
    MedicalOrder findByProfileIdAndId(Integer profileId, Integer OrderId);
}
