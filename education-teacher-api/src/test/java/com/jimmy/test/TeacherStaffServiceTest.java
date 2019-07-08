package com.jimmy.test;

import com.jimmy.common.utils.EncryptUtils;
import com.jimmy.dao.entity.ClassRoomInfo;
import com.jimmy.dao.entity.MachineInfo;
import com.jimmy.dao.entity.TeacherStaffInfo;
import com.jimmy.dao.local.thread.SiteLocalThread;
import com.jimmy.mvc.common.utils.PasswordUtils;
import com.jimmy.service.ClassRoomService;
import com.jimmy.service.TeacherStaffInfoService;

import com.jimmy.teacher.api.Application;
import com.jimmy.teacher.api.controller.admin.RoomController;
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
public class TeacherStaffServiceTest {

    @Autowired
    private TeacherStaffInfoService teacherStaffInfoService;

    @Autowired
    private ClassRoomService classRoomService;
    @Test
    public void testRoom(){
        SiteLocalThread.setSiteId(1L);
        SiteLocalThread.setSiteIdList(Arrays.asList(1L));
        ClassRoomInfo roomInfo=new ClassRoomInfo();
        roomInfo.setAddress("浙江省杭州市江干区实验中学三班");
        roomInfo.setName("实验三班");
        roomInfo.setSn("123hi");
        roomInfo.setDescription("浙江省杭州市江干区实验中学三班");
        roomInfo.setIsDeleted(false);
        List<MachineInfo> machineInfoList=new ArrayList<>();
        MachineInfo machineInfo=new MachineInfo();
        machineInfo.setColumnNum(0);
        machineInfo.setRowNum(0);
        machineInfo.setSn("1");
        machineInfoList.add(machineInfo);
         machineInfo=new MachineInfo();
        machineInfo.setColumnNum(1);
        machineInfo.setRowNum(0);
        machineInfo.setSn("2");
        machineInfoList.add(machineInfo);


        classRoomService.save(roomInfo, machineInfoList);
    }
    @Test
    public void test(){
        SiteLocalThread.setSiteId(1L);
        SiteLocalThread.setSiteIdList(Arrays.asList(1L));
        TeacherStaffInfo teacherStaffInfo=new TeacherStaffInfo();
        teacherStaffInfo.setAppRoomId(1L);
        teacherStaffInfo.setEmail("test@126.com");
        teacherStaffInfo.setIdCard("12345678");
        teacherStaffInfo.setIsDeleted(false);
        teacherStaffInfo.setIsEnabled(true);
        teacherStaffInfo.setBirthTime(new Date());
        teacherStaffInfo.setMobile("13656640475");
        teacherStaffInfo.setName("login");
        teacherStaffInfo.setRealName("测试人员");
        teacherStaffInfo.setSex(0);
        teacherStaffInfo.setTelephone("13656640475");
        teacherStaffInfo.setStaffName("老师");
        teacherStaffInfo.setStaffType(0);
        teacherStaffInfo.setIsLocked(false);
        teacherStaffInfo.setLoginFailureCount(0);
        teacherStaffInfo.setPassword(PasswordUtils.encryPassword("123456"));
        teacherStaffInfoService.save(teacherStaffInfo,Arrays.asList(41L));
    }
}
