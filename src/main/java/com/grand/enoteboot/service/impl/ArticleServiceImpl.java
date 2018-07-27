package com.grand.enoteboot.service.impl;

import com.grand.enoteboot.annotation.AddLog;
import com.grand.enoteboot.dao.ArticleDao;
import com.grand.enoteboot.entity.Article;
import com.grand.enoteboot.entity.User;
import com.grand.enoteboot.service.ArticleService;
import com.grand.enoteboot.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author GrandX
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleDao articleDao;

    @Override
    public List<Article> findAll() {
        //return articleDao.findAll();
        return articleDao.findAllDesc();
    }

    @Override
    @AddLog
    @Transactional
    public void addArticle(Article article) {
        User sessionUser = SessionUtil.getSessionUser();
        article.setCreateTime(new Date());
        if (sessionUser != null) {
            Long userId = sessionUser.getId();
            article.setCreateId(userId);
        }
        articleDao.insertSelective(article);
        //int i = 1/0;
    }

    @Override
    public Article findById(Long id) {
        return articleDao.findById(id);
    }

    @Override
    public void update(Article article) {
        if(article != null){
            article.setUpdateTime(new Date());
            User user = SessionUtil.getSessionUser();
            if(user != null) {
                article.setUpdateId(user.getId());
            }
        }
        articleDao.updateByPrimaryKeySelective(article);
    }

    @Override
    public void delete(Long id) {
        articleDao.delete(id);
    }

}
