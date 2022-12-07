package com.example.backend.service;

import com.example.backend.entity.Article;

import java.util.List;

public interface ArticleService {
    //본체가 없습니다. {}가 없다는 뜻 -> 접근제한자 반환형 메소드명();

    //전체가져오기
    //데이터가 많아서 List에 담아 줘야함
    //id,writer,content 등등 내용이 많기 때문에 entity 안에 Article 을 다 가져오면 됨
    public List<Article> getArticles();


    //저장하기 (결과를 표시해주려면 Article(entity) 를 적어주고 보여줄것이 없다면 void를 사용하면 됨
    //매개변수 자리에는 저장하기니깐 입력값이 있어야하는데 subject,writer 등등
    //이미 만들어놓은 것을 재사용하기위해 entity 에 article 사용해주고 별명도 같이 적어주면 됨
    public Article createArticle(Article article);

    public Article getArticleById(long id);

    public Article updateArticle(Article article,long id);

    public void deleteArticle(long id);
}
