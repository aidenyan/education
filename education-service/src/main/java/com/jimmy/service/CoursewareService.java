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
     * �γ�ID���ҿμ���ϸ��Ϣ
     *
     * @param courseId �γ�ID
     * @return List<�γ���Ϣ>
     */
    List<CoursewareDetailVO> list(Long courseId);

    /**
     * �γ�ID��ͳ�ƿμ�����
     */
    int count(Long courseId);

    /**
     * �γ�ID���ҿμ���ϸ��Ϣ
     *
     * @param courseId �γ�ID
     * @return List<�γ���Ϣ>
     */
    List<Courseware> listByCourseId(Long courseId);

    /**
     * �γ�ID���ҿμ���ϸ��Ϣ
     *
     * @param coursewareName �γ�ID
     * @return List<�γ���Ϣ>
     */
    List<Courseware> listByCourseName(String coursewareName);

    /**
     * ���ݿμ�ID��״̬��ѯ�μ�ĳ����ϸ��Ϣ
     */

    List<CoursewareItem> listByCoursewareId(Long coursewareId, Integer contentType);

    /**
     * ���ݿγ�ID��״̬��ѯ�μ�ĳ����ϸ��Ϣ
     */

    List<CoursewareItem> listByCourseId(Long courseId, Integer contentType);

    /**
     * ��������޸�
     */
    Long save(Courseware courseware, List<CoursewareItem> itemList, Long courseId);

    /**
     * ������ϵ
     */
    void bind(List<Long> coursewareIdList, Long courseId);

    /**
     * �����
     */
    void unBind(List<Long> coursewareIdList, Long courseId);

    CoursewareDetailVO find(Long coursewareId);
}
