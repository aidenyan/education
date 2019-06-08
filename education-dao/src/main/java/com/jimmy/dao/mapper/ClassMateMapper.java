package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.ClassMate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ClassMateMapper {
    /**
     * 根据ID查找班级信息
     *
     * @param id ID
     * @return 班级信息
     */
    ClassMate findById(@Param("id") Long id, @Param("siteIdList") List<Long> siteIdList);

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
     * 根据名字搜索信息
     *
     * @param name 名字
     * @return List<班级信息>
     */
    List<ClassMate> list(@Param("name") String name, @Param("siteIdList") List<Long> siteIdList);
}