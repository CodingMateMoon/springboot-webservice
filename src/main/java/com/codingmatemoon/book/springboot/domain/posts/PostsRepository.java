package com.codingmatemoon.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository<Entity, pk 타입> : Entity 클래스와 기본 Entity Repository 함께 위치
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
