package com.jimmy.mvc.common.service;

import com.jimmy.core.base.Page;
import com.jimmy.mvc.common.model.dto.StudentDetailDTO;

import java.util.List;

public interface CommonService {
    /**
     * ѧ������ϸ��Ϣ
     */
    List<StudentDetailDTO> list(Long courseId);

    /**
     * ��ȡ��ҳ��Ϣ
     *
     * @param courseId
     * @return
     */
    Page<StudentDetailDTO> page(Long courseId,Long pageNo,Long pageSize);
}
