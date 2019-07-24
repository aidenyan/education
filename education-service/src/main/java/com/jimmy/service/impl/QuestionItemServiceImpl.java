package com.jimmy.service.impl;

import com.jimmy.core.local.thread.LoginLocalThread;
import com.jimmy.dao.entity.QuestionItem;
import com.jimmy.dao.local.thread.SiteLocalThread;
import com.jimmy.dao.mapper.QuestionItemMapper;
import com.jimmy.service.QuestionItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class QuestionItemServiceImpl implements QuestionItemService {
    @Autowired
    private QuestionItemMapper questionItemMapper;

    @Override
    public List<QuestionItem> list(Long questionId) {
        Assert.notNull(questionId);
        return questionItemMapper.list(Arrays.asList(questionId), SiteLocalThread.getSiteIdList());
    }

    @Override
    public List<QuestionItem> list(List<Long> questionIdList) {
        Assert.notEmpty(questionIdList);
        return questionItemMapper.list(questionIdList, SiteLocalThread.getSiteIdList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(List<QuestionItem> itemList, Long questionId) {
        Assert.notEmpty(itemList);
        deleted(questionId);
        itemList.forEach(questionItem -> {
            questionItem.setModifyId(LoginLocalThread.get());
            questionItem.setSiteId(SiteLocalThread.getSiteId());
            questionItem.setCreateId(LoginLocalThread.get());
            questionItem.setQuestionId(questionId);
            questionItemMapper.insert(questionItem);
        });
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleted(Long questionId) {
        Assert.notNull(questionId);
        questionItemMapper.deleteByPrimaryKey(questionId, SiteLocalThread.getSiteIdList());
    }
}
