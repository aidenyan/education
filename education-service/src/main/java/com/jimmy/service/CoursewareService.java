package com.jimmy.service;

import com.jimmy.model.dto.CoursewareDetailVO;

import java.util.List;

/**
 * @ClassName: CoursewareService
 * @Description:
 * @author: aiden
 * @date: 2019/6/12/012.
 */
public interface CoursewareService {
    /**
     * �γ�ID���ҿμ���ϸ��Ϣ
     *
     * @param courseId �γ�ID
     * @return List<�γ���Ϣ>
     */
    List<CoursewareDetailVO> list(Long courseId);
}
