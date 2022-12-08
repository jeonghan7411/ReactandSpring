package com.example.backend.service;

//이름 설정은 Impl에서 설정
// @Autowried는 인터페이스를

import com.example.backend.entity.Article;
import com.example.backend.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 중간에서 data 변환, 정규식 등 db에서 가져와서 처리하는 것들을 하겠다.
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleRepository articleRepository;  // 디비 처리하는 객체
    //findAll(),save(),findbyId(),delete()메소드를 사용하려면 repository를 가져와야함 @Autowired 사용

    @Override
    public List<Article> getArticles() {
        //findAll() = Select * from article Order by id DESC;
        return articleRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
    }

    @Override
    public Article createArticle(Article article) {
        //insert into = save()
        return articleRepository.save(article); //사용할 때는 이름만
    }

    @Override
    public Article getArticleById(long id) {
        // select ~ where id = findById();
        return articleRepository.findById(id).orElse(null);
    }

    @Override
    public Article updateArticle(Article article, long id) {
        return null;
    }

    @Override
    public void deleteArticle(long id) {
        //delete from where = deletebyId
        articleRepository.deleteById(id);
    }
}
