package com.jimmy.service.impl;

import com.jimmy.core.local.thread.LoginLocalThread;
import com.jimmy.dao.entity.ClassRoomInfo;
import com.jimmy.dao.entity.MachineInfo;
import com.jimmy.dao.local.thread.SiteLocalThread;
import com.jimmy.dao.mapper.ClassRoomInfoMapper;
import com.jimmy.dao.mapper.MachineInfoMapper;
import com.jimmy.model.dto.ClassRoomDTO;
import com.jimmy.service.ClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ClassRoomServiceImpl implements ClassRoomService {

    @Autowired
    private MachineInfoMapper machineInfoMapper;

    @Autowired
    private ClassRoomInfoMapper classRoomInfoMapper;

    @Override
    public List<ClassRoomInfo> list(String name) {
        return classRoomInfoMapper.list(name, SiteLocalThread.getSiteIdList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(ClassRoomInfo classRoomInfo, List<MachineInfo> machineInfoList) {
        Assert.notNull(classRoomInfo);
        classRoomInfo.setModifyId(LoginLocalThread.get());
        classRoomInfo.setCreateId(LoginLocalThread.get());
        classRoomInfo.setSiteId(SiteLocalThread.getSiteId());
        classRoomInfo.setIsDeleted(Boolean.FALSE);
        if (classRoomInfo.getId() == null) {
            classRoomInfoMapper.insert(classRoomInfo);
        } else {
            classRoomInfoMapper.update(classRoomInfo);
        }
        machineInfoMapper.deleteByRoomId(classRoomInfo.getId(), SiteLocalThread.getSiteIdList());
        if (CollectionUtils.isEmpty(machineInfoList)) {
            return;
        }
        machineInfoList.forEach(machineInfo -> {
            machineInfo.setRoomId(classRoomInfo.getId());
            machineInfo.setModifyId(LoginLocalThread.get());
            machineInfo.setCreateId(LoginLocalThread.get());
            machineInfo.setSiteId(SiteLocalThread.getSiteId());
            machineInfoMapper.insert(machineInfo);
        });
    }

    @Override
    public ClassRoomDTO find(Long roomId) {
        Assert.notNull(roomId);
        ClassRoomDTO classRoomDTO = new ClassRoomDTO();
        classRoomDTO.setClassRoomInfo(classRoomInfoMapper.findById(roomId, SiteLocalThread.getSiteIdList()));
        classRoomDTO.setMachineInfoList(machineInfoMapper.listByRoomId(roomId, SiteLocalThread.getSiteIdList()));
        return classRoomDTO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleted(Long roomId) {
        ClassRoomInfo classRoomInfo = new ClassRoomInfo();
        classRoomInfo.setModifyId(LoginLocalThread.get());
        classRoomInfo.setSiteId(SiteLocalThread.getSiteId());
        classRoomInfo.setIsDeleted(Boolean.TRUE);
        classRoomInfo.setId(roomId);
        classRoomInfoMapper.updateProperty(classRoomInfo);
    }
}
