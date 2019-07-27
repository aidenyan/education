package com.jimmy.service;

import com.jimmy.dao.entity.StudentInfo;
import com.jimmy.dao.entity.TemporaryClassMate;

import java.util.List;

/**
 * @ClassName: TemporaryClassMateService
 * @Description:
 * @author: aiden
 * @date: 2019/6/12/012.
 */
public interface TemporaryClassMateService {
    /**
     * ������ʱ��
     */
    void save(TemporaryClassMate temporaryClassMate, List<StudentInfo> studentList);

    /**
     * ���ݿγ�ID��ȡѧ����Ϣ
     *
     * @param courseId �γ�ID
     * @return List<ѧ����Ϣ>
     */
    List<StudentInfo> findStudentId(Long courseId);

    /**
     * ���ݿγ�ID��ȡ��ʱ�İ༶
     *
     * @param courseId �γ�ID
     * @return List<ѧ����Ϣ>
     */
    TemporaryClassMate findTempClassMate(Long courseId);

    /**
     * ������ʱ�༶����ɵİ༶
     *
     * @param tempClassMateId
     * @return
     */
    List<Long> listClassMateId(Long tempClassMateId);

}
