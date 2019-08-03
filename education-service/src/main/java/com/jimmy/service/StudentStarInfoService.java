package com.jimmy.service;

import java.util.Map;

/**
 * @ClassName: StudentStarInfoService
 * @Description:
 * @author: aiden
 * @date: 2019/6/12/012.
 */
public interface StudentStarInfoService {


    /**
     * ����Ϊ����֮��
     *
     * @param teacherId ��ʦID
     * @param studentId ѧ��ID
     */
    void setStar(Long teacherId, Long studentId, String starName);

    /**
     * ��ȡѧϰ֮�ǵ�����
     *
     * @return
     */
    Map<Long, String> mapStar();

    /**
     * ɾ������֮��
     *
     * @param studentId
     */
    void deleteStar(Long studentId);
}
