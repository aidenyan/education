package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.StudentStarInfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface StudentStarInfoMapper {
    /**
     * ָ�����汾��֮����Ϣ
     *
     * @param record ����֮����Ϣ
     * @return ��������
     */
    int insert(StudentStarInfo record);

    /**
     * ɾ������֮��
     *
     * @param id
     * @return
     */
    int deleted(@Param("id") Long id, @Param("siteIdList") List<Long> siteIdList);

    List<StudentStarInfo> list(@Param("startDate") Date startDate,@Param("endDate") Date endDate, @Param("siteIdList") List<Long> siteIdList);

}