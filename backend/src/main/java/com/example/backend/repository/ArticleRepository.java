package com.example.backend.repository;

import com.example.backend.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

//select,insert,update,delete 쿼리문 대신 메소드()
//jpaRepository 상속
//이름이나 매개변수는 정해진 대로 사용해야 하므로 interface로 상속 받아야함
//JpaRepository<Entity이름,id 객체타입 자료형>
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
