package com.example.backend.controller;

import com.example.backend.entity.Article;
import com.example.backend.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // 디자인 신경 쓸 필요없이 자료만 주고 받기 React <->Spring (JSON타입으로 주고받음)
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")  // node 에 cors랑 비슷 함 (다른 도메인에서도 원활하게) (React port)
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/article") //전체 가져오기
    public List<Article> getArticle(){
        return articleService.getArticles();
    }

    @PostMapping("/article")  // 저장
    //subject,content,writer , .... 등등 저장되니깐
    //객체 타입으로 변수를 가져와서 저장하기 JSON 형식이라서 @RequestBody 로 받아야함
    public Article createArticle(@RequestBody Article article){ //매소드에는 타입과 변수명
        return articleService.createArticle(article);
    }


    @DeleteMapping("/article/{id}") // 주소/id값 -> @PathVariable
    public void deleteArticle(@PathVariable long id){
        articleService.deleteArticle(id);
    }

}
