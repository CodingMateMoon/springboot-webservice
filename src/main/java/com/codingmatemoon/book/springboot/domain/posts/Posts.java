package com.codingmatemoon.book.springboot.domain.posts;

import com.codingmatemoon.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    /*
    해당 클래스의 빌더 패턴 클래스를 생성
    생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    어느 필드에 어떤 값을 채워야할지 명확하게 인지할 수 있습니다.
     */

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
