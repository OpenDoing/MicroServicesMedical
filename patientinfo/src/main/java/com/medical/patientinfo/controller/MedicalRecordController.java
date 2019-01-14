package com.medical.patientinfo.controller;

import com.medical.patientinfo.dao.MedicalRecordRepo;
import com.medical.patientinfo.entity.MedicalRecord;
import com.medical.patientinfo.entity.dto.MedicalRecordDto;
import com.medical.patientinfo.util.BeanCopyUtil;
import com.medical.patientinfo.util.ResponseUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;


/**
 * @author duwen
 * @date 2019/1/14 13:32
 */
@CrossOrigin
@RestController
public class MedicalRecordController {

    @Resource
    private MedicalRecordRepo medicalRecordRepo;

    @GetMapping("/medicalRecord/{id}")
    @ApiOperation(value="获取用户病历信息", notes="根据患者id来获取病历信息")
    public Object getListMedicalRecord(@PathVariable Integer id,
                              @RequestParam Integer page,
                              @RequestParam Integer size) {
        Pageable pageable =  PageRequest.of(page,size,new Sort(Sort.Direction.ASC,"id"));
        return ResponseUtil.ok(medicalRecordRepo.findByProfileId(id,pageable).getContent());
    }

    @PostMapping("/medicalRecord")
    @ApiOperation(value="添加用户病历信息", notes="添加用户病历信息")
    public Object addMedicalRecord(@RequestBody MedicalRecordDto dto){
        MedicalRecord medicalRecord = new MedicalRecord();
        BeanCopyUtil.copy(dto,medicalRecord);
        medicalRecord.setCreateTime(LocalDateTime.now());
        return ResponseUtil.ok(medicalRecordRepo.saveAndFlush(medicalRecord));
    }

}
