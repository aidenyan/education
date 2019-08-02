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
     * ����ŵ��Ƿ����
     *
     * @param roomId ����ID
     * @return true:�Ѿ�ʹ�ã�false:δʹ��
     */
    boolean isExitByRoomId(Long roomId);

    /**
     * ���ҿγ���Ϣ
     *
     * @param roomId ID
     * @return �γ���Ϣ
     */
    CourseInfo findByRoomId(Long roomId);

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
     * �޸Ŀγ̸�Ϊ�Ѿ�ʹ��
     *
     * @param courseId �γ�ID
     */
    void useCourse(Long teacherId, Long courseId, Integer usedStatus, Long roomId);

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

    /**
     * ��ȡû��ʹ�ù��Ŀγ�
     *
     * @param teacherId
     * @param name
     * @return
     */
    List<CourseInfo> listByNotUsed(Long teacherId, String name);

    /**
     * ���ҿ���ʹ����������Լ���ʦ�Ŀγ���Ϣ
     *
     * @param roomId    ����ID
     * @param teacherId ��ʦID
     * @param name      ����
     * @return List<�γ�></>
     */
    List<CourseInfo> listCouldUsedByName(Long roomId, Long teacherId, String name);
}
