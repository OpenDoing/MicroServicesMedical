package com.medical.patientinfo.dao;

import com.medical.patientinfo.entity.User_profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface ProfileRepo extends JpaRepository<User_profile, Integer>{

    List<User_profile> findAllByUserid(Integer user_id);
    User_profile findAllById(Integer id);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO user_profile(name,sex,birth,address,phone,create_time,user_id,relation) VALUES (?1,?2,?3,?4,?5,?6,?7,?8)", nativeQuery = true)
    int add(String name, Integer sex, Date birth, String address, String phone, LocalDateTime create_time, Integer user_id, Integer relation);
}
