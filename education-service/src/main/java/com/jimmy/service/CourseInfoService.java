package com.jimmy.service;

import com.jimmy.dao.entity.CourseInfo;

import java.util.List;

/**
 * @ClassName: CourseInfoService
 * @Description:
 * @author: aiden
 * @date: 2019/6/10/010.
 */
public interface CourseInfoService {

    /**
     * 保存课程信息
     *
     * @param record 课程信息
     * @return 保存信息
     */
    void save(CourseInfo record);

    /**
     * 检查门店是否存在
     *
     * @param roomId 教室ID
     * @return true:已经使用，false:未使用
     */
    boolean isExitByRoomId(Long roomId);

    /**
     * 查找课程信息
     *
     * @param roomId ID
     * @return 课程信息
     */
    CourseInfo findByRoomId(Long roomId);

    /**
     * 查找课程信息
     *
     * @param id ID
     * @return 课程信息
     */
    CourseInfo findById(Long id);

    /**
     * 查找课程信息
     *
     * @param name ID
     * @return 课程信息
     */
    List<CourseInfo> list(String name);

    /**
     * 修改课程改为已经使用
     *
     * @param courseId 课程ID
     */
    void useCourse(Long teacherId, Long courseId, Integer usedStatus, Long roomId);

    /**
     * 查找可以使用这个教室以及老师的课程信息
     *
     * @param roomId    教室ID
     * @param teacherId 老师ID
     * @param size      数量
     * @return List<课程></>
     */
    List<CourseInfo> listCouldUsed(Long roomId, Long teacherId,
                                   Integer size);

    /**
     * 获取没有使用过的课程
     *
     * @param teacherId
     * @param name
     * @return
     */
    List<CourseInfo> listByNotUsed(Long teacherId, String name);

    /**
     * 查找可以使用这个教室以及老师的课程信息
     *
     * @param roomId    教室ID
     * @param teacherId 老师ID
     * @param name      名字
     * @return List<课程></>
     */
    List<CourseInfo> listCouldUsedByName(Long roomId, Long teacherId, String name);
}
