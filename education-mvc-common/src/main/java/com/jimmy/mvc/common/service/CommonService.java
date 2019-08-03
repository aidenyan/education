package com.jimmy.mvc.common.service;

import com.jimmy.core.base.Page;
import com.jimmy.mvc.common.model.dto.StudentDetailDTO;
import com.jimmy.mvc.common.model.dto.StudentInfoStarDTO;

import java.util.List;

public interface CommonService {
    /**
     * 学生的详细信息
     */
    List<StudentDetailDTO> list(Long courseId);

    /**
     * 获取分页信息
     *
     * @param courseId
     * @return
     */
    Page<StudentDetailDTO> page(Long courseId, Long pageNo, Long pageSize);

    /**
     * 获取所有学校之星信息
     *
     * @return
     */
    List<StudentInfoStarDTO> listStar();
}
