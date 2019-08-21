package com.jimmy.test;

import com.jimmy.dao.entity.StudentInfo;
import com.jimmy.dao.local.thread.SiteLocalThread;
import com.jimmy.mvc.common.utils.PasswordUtils;
import com.jimmy.service.StudentInfoService;
import com.jimmy.teacher.api.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;

/**
 * @ClassName: TeacherStaffServiceTest
 * @Description:
 * @author: aiden
 * @date: 2019/7/8/008.
 */
@RunWith(SpringRunner.class)

public class StudentServiceTest {



    @Test
    public void test() {
        for (int i = 100; i < 150; i++) {
            SiteLocalThread.setSiteId(1L);
            SiteLocalThread.setSiteIdList(Arrays.asList(1L));
            StudentInfo studentInfo = new StudentInfo();
            studentInfo.setClassmateId(3L);
            studentInfo.setEmail("test@126.com");
            studentInfo.setIdCard("12345678");
            studentInfo.setIsDeleted(false);
            studentInfo.setIsEnabled(true);
            studentInfo.setBirthTime(new Date());
            studentInfo.setMobile("13656640475");
            studentInfo.setName("login" + i);
            studentInfo.setRealName("²âÊÔÈËÔ±" + i);
            studentInfo.setSex(0);
            studentInfo.setTelephone("13656640475");
            System.out.println(PasswordUtils.encryPassword("123456"));
        }
    }
}
