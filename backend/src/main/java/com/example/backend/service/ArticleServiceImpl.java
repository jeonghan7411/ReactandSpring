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
        //ReactJs에서 넘어온 자료를 저장하기 위한 Model (entity) 을 초기화 후
        //자료 저장을 하기 위해서는 getter,setter 를 이용해서 임시 메모리에 저장
        //저장할 때는 get()을 이용해서 가져와서  -> set()을 이용해서 저장
        //db에 저장
        //데이터 타입 변수명 = 생성자
        Article newArticle = new Article();
        //get은 리엑트에서 가져온거, set은 spring에 저장하는 거
        newArticle.setId(id);
        newArticle.setSubject(article.getSubject());
        newArticle.setWriter(article.getWriter());
        newArticle.setContent(article.getContent());


        return articleRepository.save(newArticle);
    }

    @Override
    public void deleteArticle(long id) {
        //delete from where = deletebyId
        articleRepository.deleteById(id);
    }
}
