package com.jimmy.dao.mapper;

import com.jimmy.dao.entity.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionMapper {

    /**
     * 保存问题
     *
     * @param record 问题
     * @return 保存结果
     */
    int insert(Question record);

    /**
     * 根据ID查找问题
     *
     * @param id         ID
     * @param siteIdList
     * @return 问题信息
     */
    Question findById(@Param("id") Long id, @Param("siteIdList") List<Long> siteIdList);

    /**
     * 根据ID查找问题
     *
     * @param question    问题的内容
     * @param siteIdList
     * @return 问题信息
     */
    List<Question> list(@Param("question") String question, @Param("siteIdList") List<Long> siteIdList);

    /**
     * 更新问题
     *
     * @param record 问题
     * @return 更新数量
     */
    int updateProperty(Question record);

    /**
     * 根据ID查找问题
     *
     * @param question    问题的内容
     * @param siteIdList
     * @return 问题信息
     */
    long  count(@Param("question") String question, @Param("siteIdList") List<Long> siteIdList);

    /**
     * 更新问题
     *
     * @param record 问题
     * @return 更新数量
     */
    int update(Question record);
}