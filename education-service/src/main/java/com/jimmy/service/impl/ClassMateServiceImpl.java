package com.jimmy.service.impl;

import com.jimmy.core.local.thread.LoginLocalThread;
import com.jimmy.dao.entity.ClassMate;
import com.jimmy.dao.local.thread.SiteLocalThread;
import com.jimmy.dao.mapper.ClassMateMapper;
import com.jimmy.service.ClassMateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ClassMateServiceImpl implements ClassMateService {

    @Autowired
    private ClassMateMapper classMateMapper;

    @Override
    public ClassMate findById(Long id) {
        Assert.notNull(id, "id is null");
        return classMateMapper.findById(id, SiteLocalThread.getSiteIdList());
    }

    @Override
    public  List<ClassMate>  listById(List<Long> idList) {
        Assert.notEmpty(idList, "idList is null");
        return classMateMapper.listById(idList, SiteLocalThread.getSiteIdList());
    }

    @Override
    public List<ClassMate> listAll() {
        return classMateMapper.listAll(SiteLocalThread.getSiteIdList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(ClassMate classMate) {
        Assert.notNull(classMate, "classMate is null");
        classMate.setIsDeleted(Boolean.FALSE);
        classMate.setModifyId(LoginLocalThread.get());
        classMate.setCreateId(LoginLocalThread.get());
        classMate.setSiteId(SiteLocalThread.getSiteId());
        return classMateMapper.insert(classMate);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateProperty(ClassMate classMate) {
        Assert.notNull(classMate, "classMate is null");
        classMate.setModifyId(LoginLocalThread.get());
        classMate.setSiteId(SiteLocalThread.getSiteId());
        return classMateMapper.updateProperty(classMate);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(ClassMate classMate) {
        Assert.notNull(classMate, "classMate is null");
        classMate.setModifyId(LoginLocalThread.get());
        classMate.setSiteId(SiteLocalThread.getSiteId());
        return classMateMapper.update(classMate);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleted(Long id) {
        Assert.notNull(id, "id is null");
        ClassMate classMate = new ClassMate();
        classMate.setSiteId(SiteLocalThread.getSiteId());
        classMate.setIsDeleted(true);
        classMate.setId(id);
        classMate.setModifyId(LoginLocalThread.get());
        classMateMapper.updateProperty(classMate);
    }

    @Override
    public List<ClassMate> list(String name) {

        return classMateMapper.list(name, SiteLocalThread.getSiteIdList());
    }
}
