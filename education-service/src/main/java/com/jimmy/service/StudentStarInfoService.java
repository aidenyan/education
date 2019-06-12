package com.jimmy.service;

import com.jimmy.dao.entity.StudentInfo;

import java.util.List;

/**
 * @ClassName: StudentStarInfoService
 * @Description:
 * @author: aiden
 * @date: 2019/6/12/012.
 */
public interface StudentStarInfoService {
    /**
     * ��ȡ���ܵ�֮��
     *
     * @return list<����֮�ǵ�ѧ����Ϣ>
     */
    List<StudentInfo> listStar();

    /**
     * ����Ϊ����֮��
     *
     * @param teacherId ��ʦID
     * @param studentId ѧ��ID
     */
    void setStar(Long teacherId, Long studentId);
}
