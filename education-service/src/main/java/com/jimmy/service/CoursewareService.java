package com.jimmy.service;

import com.jimmy.dao.entity.Courseware;
import com.jimmy.dao.entity.CoursewareItem;
import com.jimmy.model.vo.CoursewareDetailVO;

import java.util.List;

/**
 * @ClassName: CoursewareService
 * @Description:
 * @author: aiden
 * @date: 2019/6/12/012.
 */
public interface CoursewareService {
    /**
     * 课程ID查找课件详细信息
     *
     * @param courseId 课程ID
     * @return List<课程信息>
     */
    List<CoursewareDetailVO> list(Long courseId);

    /**
     * 课程ID查统计课件数量
     */
    int count(Long courseId);

    /**
     * 课程ID查找课件详细信息
     *
     * @param courseId 课程ID
     * @return List<课程信息>
     */
    List<Courseware> listByCourseId(Long courseId);

    /**
     * 课程ID查找课件详细信息
     *
     * @param coursewareName 课程ID
     * @return List<课程信息>
     */
    List<Courseware> listByCourseName(String coursewareName);

    /**
     * 根据课件ID和状态查询课件某个详细信息
     */

    List<CoursewareItem> listByCoursewareId(Long coursewareId, Integer contentType);

    /**
     * 根据课程ID和状态查询课件某个详细信息
     */

    List<CoursewareItem> listByCourseId(Long courseId, Integer contentType);

    /**
     * 保存或者修改
     */
    Long save(Courseware courseware, List<CoursewareItem> itemList, Long courseId);

    /**
     * 保定关系
     */
    void bind(List<Long> coursewareIdList, Long courseId);

    /**
     * 解除绑定
     */
    void unBind(List<Long> coursewareIdList, Long courseId);

    CoursewareDetailVO find(Long coursewareId);
}
