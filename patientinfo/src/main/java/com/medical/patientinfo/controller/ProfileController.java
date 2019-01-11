package com.medical.patientinfo.controller;

import com.medical.patientinfo.dao.ProfileRepo;
import com.medical.patientinfo.entity.User_profile;
import com.medical.patientinfo.util.ResponseUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Convert;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class ProfileController {

    @Autowired
    private ProfileRepo profileRepo;

    @GetMapping("/family")
    @ApiOperation(value="获取用户详细信息", notes="根据url的id来获取该用户的家庭成员")
    public Map<String, Object> getListUser(@RequestParam Integer user_id) {
        List<User_profile> list = profileRepo.findAllByUserid(user_id);
        Map<String,Object> map = new HashMap<>();
        map.put("data", list);
        map.put("status", 0);
        map.put("errmsg", "成功");
        return map;
    }

    @GetMapping("/user")
    @ApiOperation(value="获取成员信息", notes="根据指定id来获取家庭成员")
    public Object getUser(@RequestParam Integer id) {
        User_profile user_profile = profileRepo.findAllById(id);

        return ResponseUtil.ok(user_profile);
    }

    @PutMapping("/update")
    @ApiOperation(value="修改成员信息", notes="")
    public Object updateUser(@RequestBody User_profile profile) {
        User_profile user = new User_profile();
        user.setAddress(profile.getAddress());
        Date date = new Date(profile.getBirth().toString());
        user.setBirth(date);
        user.setCreate_time((LocalDateTime) profile.getCreate_time());
        user.setId(profile.getId());
        user.setName(profile.getName());
        user.setPhone(profile.getPhone());
        user.setSex(profile.getSex());
        user.setRelation(profile.getRelation());
        user.setUserid(profile.getUserid());

        User_profile user_profile = profileRepo.save(user);

        return ResponseUtil.ok(user_profile);
    }

    @PostMapping("/add")
    @ApiOperation(value="添加成员信息", notes="")
    public Object addpatient (@RequestBody User_profile profile) {

        Date date = new Date(profile.getBirth().toString());
        profile.setBirth(date);
        profile.setCreate_time((LocalDateTime) profile.getCreate_time());
//        Integer id = profileRepo.add(profile.getName(), profile.getSex(), profile.getBirth(),
//                profile.getAddress(), profile.getPhone(), profile.getCreate_time(), profile.getUserid(), profile.getRelation());
//        profileRepo.save(profile);
        return ResponseUtil.ok(profileRepo.save(profile));
    }

    @DeleteMapping("/delete")
    @ApiOperation(value="删除成员信息", notes="")
    public Object deletepatient (@RequestParam Integer id) {
        profileRepo.deleteById(id);
        return ResponseUtil.ok();
    }
}
