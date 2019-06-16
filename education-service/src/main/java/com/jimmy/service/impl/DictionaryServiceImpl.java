package com.jimmy.service.impl;

import com.jimmy.core.local.thread.LoginLocalThread;
import com.jimmy.dao.entity.Dictionary;
import com.jimmy.dao.entity.DictionaryItem;
import com.jimmy.dao.local.thread.SiteLocalThread;
import com.jimmy.dao.mapper.DictionaryItemMapper;
import com.jimmy.dao.mapper.DictionaryMapper;
import com.jimmy.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DictionaryServiceImpl implements DictionaryService {
    @Autowired
    private DictionaryMapper dictionaryMapper;
    @Autowired
    private DictionaryItemMapper dictionaryItemMapper;

    @Override
    public List<Dictionary> list(String name) {
        return dictionaryMapper.list(name, SiteLocalThread.getSiteIdList());
    }

    @Override
    public List<DictionaryItem> list(Long dictionId) {
        Assert.notNull(dictionId);
        return dictionaryItemMapper.listByDictionaryId(dictionId, SiteLocalThread.getSiteIdList());

    }

    @Override
    public Dictionary find(Long id) {
        Assert.notNull(id);
        return dictionaryMapper.find(id, SiteLocalThread.getSiteIdList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(Dictionary dictionary) {
        Assert.notNull(dictionary);
        dictionary.setCreateId(LoginLocalThread.get());
        dictionary.setModifyId(LoginLocalThread.get());
        dictionary.setSiteId(SiteLocalThread.getSiteId());
        if (dictionary.getId() == null) {
            dictionaryMapper.insert(dictionary);
        } else {
            dictionaryMapper.updateProperty(dictionary);

        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(DictionaryItem dictionaryItem) {
        Assert.notNull(dictionaryItem);
        dictionaryItem.setCreateId(LoginLocalThread.get());
        dictionaryItem.setModifyId(LoginLocalThread.get());
        dictionaryItem.setSiteId(SiteLocalThread.getSiteId());
        if (dictionaryItem.getId() == null) {
            dictionaryItemMapper.insert(dictionaryItem);
        } else {
            dictionaryItemMapper.updateProperty(dictionaryItem);

        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deletedDictionary(Long id) {
        Assert.notNull(id);
        Dictionary dictionary = new Dictionary();
        dictionary.setId(id);
        dictionary.setModifyId(LoginLocalThread.get());
        dictionary.setSiteId(SiteLocalThread.getSiteId());
        dictionaryMapper.updateProperty(dictionary);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deletedDictionaryItem(Long id) {
        Assert.notNull(id);
        DictionaryItem dictionaryItem = new DictionaryItem();
        dictionaryItem.setId(id);
        dictionaryItem.setModifyId(LoginLocalThread.get());
        dictionaryItem.setSiteId(SiteLocalThread.getSiteId());
        dictionaryItemMapper.updateProperty(dictionaryItem);
    }
}
