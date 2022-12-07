package com.example.backend.service;

import com.example.backend.entity.Article;

import java.util.List;

public interface ArticleService {
    //본체가 없습니다. {}가 없다는 뜻 -> 접근제한자 반환형 메소드명();

    //전체가져오기
    //데이터가 많아서 List에 담아 줘야함
    //id,writer,content 등등 내용이 많기 때문에 entity 안에 Article 을 다 가져오면 됨
    public List<Article> getArticles();  

    //저장하기
}
