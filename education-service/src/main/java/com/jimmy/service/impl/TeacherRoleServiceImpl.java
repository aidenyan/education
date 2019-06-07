package com.jimmy.service.impl;

import com.jimmy.dao.entity.TeacherRoleKey;
import com.jimmy.dao.mapper.TeacherRoleMapper;
import com.jimmy.service.TeacherRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class TeacherRoleServiceImpl implements TeacherRoleService {
    @Autowired
    private TeacherRoleMapper teacherRoleMapper;

    @Override
    public List<Long> list(Long staffId) {
        Assert.notNull(staffId, "staffId is null");
        return teacherRoleMapper.list(staffId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleted(Long teacherId) {
        Assert.notNull(teacherId, "teacherId is null");
        teacherRoleMapper.deleted(teacherId);
    }

    @Override
    public int insert(TeacherRoleKey teacherRoleKey) {
        Assert.notNull(teacherRoleKey, "teacherRoleKey is null");
        return teacherRoleMapper.insert(teacherRoleKey);
    }
}
