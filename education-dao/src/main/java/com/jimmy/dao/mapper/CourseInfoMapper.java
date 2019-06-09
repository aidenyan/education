package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.CourseInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseInfoMapper {

    /**
     * 保存课程信息
     *
     * @param record 课程信息
     * @return 保存信息
     */
    int insert(CourseInfo record);

    /**
     * 查找课程信息
     *
     * @param id ID
     * @return 课程信息
     */
    CourseInfo findById(@Param("id") Long id, @Param("siteIdList") List<Long> siteIdList);

    /**
     * 查找课程信息
     *
     * @param name ID
     * @return 课程信息
     */
    List<CourseInfo> list(@Param("name") String name, @Param("siteIdList") List<Long> siteIdList);

    /**
     * 更新课程信息
     *
     * @param record 课程信息
     * @return 更新数量
     */
    int update(CourseInfo record);

    /**
     * 更新需要更新的数量
     *
     * @param record 课程信息
     * @return 更新数量
     */
    int updateProperty(CourseInfo record);

    /**
     * 查找可以使用这个教室以及老师的课程信息
     *
     * @param roomId 教室ID
     * @param teacherId 老师ID
     * @param size  数量
     * @return List<课程></>
     */
    List<CourseInfo> listCouldUsed(@Param("roomId") Long roomId, @Param("teacherId") Long teacherId,
                                   @Param("size") Integer size, @Param("siteIdList") List<Long> siteIdList
    );
}