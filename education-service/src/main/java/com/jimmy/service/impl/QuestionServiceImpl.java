package com.jimmy.service.impl;

import com.jimmy.core.local.thread.LoginLocalThread;
import com.jimmy.dao.entity.Question;
import com.jimmy.dao.entity.QuestionItem;
import com.jimmy.dao.local.thread.SiteLocalThread;
import com.jimmy.dao.mapper.QuestionMapper;
import com.jimmy.service.QuestionItemService;
import com.jimmy.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private QuestionItemService questionItemService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleted(Long id) {
        Assert.notNull(id);
        Question question = new Question();
        question.setModifyId(LoginLocalThread.get());
        question.setSiteId(SiteLocalThread.getSiteId());
        question.setIsDeleted(Boolean.TRUE);
        question.setId(id);
        questionMapper.updateProperty(question);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Question question, List<QuestionItem> questionItemList) {
        Assert.notNull(question);
        question.setModifyId(LoginLocalThread.get());
        question.setSiteId(SiteLocalThread.getSiteId());
        question.setCreateId(LoginLocalThread.get());
        if (question.getId() != null) {
            Question tempQuestion = questionMapper.findById(question.getId(), SiteLocalThread.getSiteIdList());
            Assert.notNull(tempQuestion);
            if (!tempQuestion.getType().equals(question.getType())) {
                questionItemService.deleted(question.getId());
            }
            questionMapper.update(question);
        } else {
            question.setIsDeleted(Boolean.FALSE);
            questionMapper.insert(question);
        }
        if(CollectionUtils.isEmpty(questionItemList)){
            return;
        }
        questionItemService.save(questionItemList,question.getId());



    }

    @Override
    public Question findById(Long id) {
        Assert.notNull(id);
        return questionMapper.findById(id, SiteLocalThread.getSiteIdList());
    }

    @Override
    public List<Question> list(String question) {
        return questionMapper.list(question, SiteLocalThread.getSiteIdList());
    }
    @Override
    public Long count(String question) {
        return questionMapper.count(question, SiteLocalThread.getSiteIdList());
    }
}
