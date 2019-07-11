package com.jimmy.test;

import com.jimmy.dao.entity.ClassRoomInfo;
import com.jimmy.dao.entity.MachineInfo;
import com.jimmy.dao.entity.StudentInfo;
import com.jimmy.dao.entity.TeacherStaffInfo;
import com.jimmy.dao.local.thread.SiteLocalThread;
import com.jimmy.mvc.common.utils.PasswordUtils;
import com.jimmy.service.ClassRoomService;
import com.jimmy.service.StudentInfoService;
import com.jimmy.service.TeacherStaffInfoService;
import com.jimmy.teacher.api.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: TeacherStaffServiceTest
 * @Description:
 * @author: aiden
 * @date: 2019/7/8/008.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class StudentServiceTest {

    @Autowired
    private StudentInfoService studentInfoService;



    @Test
    public void test(){
       for(int i=100;i<150;i++){
           SiteLocalThread.setSiteId(1L);
           SiteLocalThread.setSiteIdList(Arrays.asList(1L));
           StudentInfo studentInfo=new StudentInfo();
           studentInfo.setClassmateId(3L);
           studentInfo.setEmail("test@126.com");
           studentInfo.setIdCard("12345678");
           studentInfo.setIsDeleted(false);
           studentInfo.setIsEnabled(true);
           studentInfo.setBirthTime(new Date());
           studentInfo.setMobile("13656640475");
           studentInfo.setName("login"+i);
           studentInfo.setRealName("²âÊÔÈËÔ±"+i);
           studentInfo.setSex(0);
           studentInfo.setTelephone("13656640475");
           studentInfo.setPassword(PasswordUtils.encryPassword("123456"));
           studentInfoService.save(studentInfo);
       }
    }
}
