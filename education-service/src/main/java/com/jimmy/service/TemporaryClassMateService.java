package com.jimmy.service;

import com.jimmy.dao.entity.StudentInfo;
import com.jimmy.dao.entity.TemporaryClassMate;
import com.jimmy.dao.entity.TemporaryStudentClassMate;

import java.util.List;

/**
 * @ClassName: TemporaryClassMateService
 * @Description:
 * @author: aiden
 * @date: 2019/6/12/012.
 */
public interface TemporaryClassMateService {

    /**
     * ������ʱ�����ѧ����Ϣ
     *
     * @param tempClassMateId
     * @return
     */
    List<TemporaryStudentClassMate> list(Long tempClassMateId);

    /**
     * ������ʱ�����ѧ����Ϣ
     */
    List<TemporaryStudentClassMate> listBySize(Long tempClassMateId, Long startNum, Long limitNum);

    /**
     * ������ʱ�����ѧ����Ϣ����
     */
    Long count(Long tempClassMateId);

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

    /**
     * ������ʱ�༶�еĻ�����Ϣ
     */
    void updateMachineId(Long machineId, Long studentId, Long tempClassMateId);

    /**
     * ������ʱ�༶�е�ǩ��
     */
    void updateRegister(Long studentId, Long tempClassMateId);


    /**
     * ������ʱ�༶�е�ǩ��
     */
    void updateAskLevelByStudent(Boolean isAskLevel, Long studentId, Long tempClassMateId);

    /**
     * ������ʱ�༶�е�ǩ��
     */
    void updateAskLevelByMachine(Boolean isAskLevel, Long machine, Long tempClassMateId);
}
