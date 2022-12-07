package com.example.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="article") //테이블 안의 이름과 Model 멤버변수 이름이 동일하면 저장  // 해주면 쿼리문 따로 써줄 필요 없음
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="subject")  //테이블 컬럼명 명시 지금은 똑같기 때문에 안적어도 되긴 함
    private String subject;
    @Column(name="writer")
    private String writer;
    @Column(name="content")
    private String content;
    @Column(name="ref")
    private int ref;
    @Column(name="ref_step")
    private int ref_step;
    @Column(name="ref_level")
    private int ref_level;
    @Column(name="ip")
    private String ip;
    @Column(name="regdate")
    @CreationTimestamp  //현재 날짜 생성 메소드 : now() 비슷
    private LocalDateTime regdate;
}
