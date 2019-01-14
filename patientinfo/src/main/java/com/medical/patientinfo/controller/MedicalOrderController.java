package com.medical.patientinfo.controller;

import com.medical.patientinfo.dao.MedicalOrderRepo;
import com.medical.patientinfo.entity.MedicalOrder;
import com.medical.patientinfo.entity.dto.MedicalOrderDto;
import com.medical.patientinfo.util.BeanCopyUtil;
import com.medical.patientinfo.util.ResponseUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author duwen
 * @date 2019/1/14 16:50
 */
@CrossOrigin
@RestController
public class MedicalOrderController {

    @Resource
    private MedicalOrderRepo medicalOrderRepo;

    @GetMapping("/medicalOrder/{id}")
    @ApiOperation(value="获取用户所有订单信息", notes="根据患者id来获取用户订单信息")
    public Object getListMedicalOrder(@PathVariable Integer id) {
        return ResponseUtil.ok(medicalOrderRepo.findByProfileId(id));
    }

    @GetMapping("/medicalOrder/{profileId}/{orderId}")
    @ApiOperation(value="获取用户订单", notes="根据患者id和订单id来获取用户订单信息")
    public Object getMedicalOrder(@PathVariable Integer profileId,
                                  @PathVariable Integer orderId) {
        return ResponseUtil.ok(medicalOrderRepo.findByProfileIdAndId(profileId,orderId));
    }

    @PostMapping("/medicalOrder")
    @ApiOperation(value="患者下单", notes="添加用户病历信息")
    public Object addMedicalRecord(@RequestBody MedicalOrderDto dto){
        MedicalOrder medicalRecord = new MedicalOrder();
        BeanCopyUtil.copy(dto,medicalRecord);
        medicalRecord.setCreateTime(LocalDateTime.now());
        return ResponseUtil.ok(medicalOrderRepo.saveAndFlush(medicalRecord));
    }

}
