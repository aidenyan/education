package com.jimmy.service;

import com.jimmy.dao.entity.ClassMate;

import java.util.List;

public interface ClassMateService {
    /**
     * 根据ID查找班级信息
     *
     * @param id ID
     * @return 班级信息
     */
    ClassMate findById(Long id);

    /**
     *  根据ID查找班级信息
     * @param idList id列表
     * @return 班级信息
     */
    List<ClassMate> listById(List<Long> idList);
    /**
     *  查找班级信息
     * @return 班级信息
     */
    List<ClassMate> listAll();

    /**
     * 保存班级信息
     *
     * @param classMate 班级信息
     * @return 更新数量
     */
    int insert(ClassMate classMate);

    /**
     * 更新班级需要更新的属性信息
     *
     * @param classMate 班级信息
     * @return 更新数量
     */
    int updateProperty(ClassMate classMate);

    /**
     * 更新全部信息
     *
     * @param classMate 班级信息
     * @return 更新数量
     */
    int update(ClassMate classMate);

    /**
     * 删除班级信息
     * @param id ID
     */
    void deleted(Long id);

    /**
     * 根据名字搜索信息
     *
     * @param name 名字
     * @return List<班级信息>
     */
    List<ClassMate> list(String name);
}
