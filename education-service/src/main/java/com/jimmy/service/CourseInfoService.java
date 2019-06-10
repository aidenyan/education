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
     * ����γ���Ϣ
     *
     * @param record �γ���Ϣ
     * @return ������Ϣ
     */
    void save(CourseInfo record);

    /**
     * ���ҿγ���Ϣ
     *
     * @param id ID
     * @return �γ���Ϣ
     */
    CourseInfo findById(Long id);

    /**
     * ���ҿγ���Ϣ
     *
     * @param name ID
     * @return �γ���Ϣ
     */
    List<CourseInfo> list(String name);



    /**
     * ���ҿ���ʹ����������Լ���ʦ�Ŀγ���Ϣ
     *
     * @param roomId    ����ID
     * @param teacherId ��ʦID
     * @param size      ����
     * @return List<�γ�></>
     */
    List<CourseInfo> listCouldUsed(Long roomId, Long teacherId,
                                   Integer size);

}