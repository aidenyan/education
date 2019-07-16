package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.CourseInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseInfoMapper {

    /**
     * ����γ���Ϣ
     *
     * @param record �γ���Ϣ
     * @return ������Ϣ
     */
    int insert(CourseInfo record);

    /**
     * ���ҿγ���Ϣ
     *
     * @param id ID
     * @return �γ���Ϣ
     */
    CourseInfo findById(@Param("id") Long id, @Param("siteIdList") List<Long> siteIdList);
    /**
     * ���ҿγ���Ϣ
     *
     * @param roomId ID
     * @return �γ���Ϣ
     */
    CourseInfo findByRoomId(@Param("roomId") Long roomId, @Param("siteIdList") List<Long> siteIdList);
    /**
     * ���ҿγ���Ϣ
     *
     * @param name ID
     * @return �γ���Ϣ
     */
    List<CourseInfo> list(@Param("name") String name, @Param("siteIdList") List<Long> siteIdList);

    /**
     * ���¿γ���Ϣ
     *
     * @param record �γ���Ϣ
     * @return ��������
     */
    int update(CourseInfo record);

    /**
     * ������Ҫ���µ�����
     *
     * @param record �γ���Ϣ
     * @return ��������
     */
    int updateProperty(CourseInfo record);


    /**
     * ����֮ǰ�Ѿ��Ϲ���״̬
     */
    int updateUsedStatus(@Param("courseId") Long courseId, @Param("roomId") Long roomId, @Param("siteId") Long siteId);


    /**
     * ���ҿ���ʹ����������Լ���ʦ�Ŀγ���Ϣ
     *
     * @param roomId    ����ID
     * @param teacherId ��ʦID
     * @param limitSize      ����
     * @return List<�γ�></>
     */
    List<CourseInfo> listCouldUsed(@Param("roomId") Long roomId, @Param("teacherId") Long teacherId,
                                   @Param("limitSize") Integer limitSize, @Param("siteIdList") List<Long> siteIdList
    );
}