package com.kimjinjoo.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Posts 클래스로 DB에 접근하게 해줄 JpaRepository
 * MyBatis같은 SQL매퍼 등에서 DAO라고 불리는 DB Layer 접근자.
 * JPA에서는 DAO가 아닌 Repository라고 부르며 인터페이스로 생성한다.
 * 단순히 인터페이스 생성 후 JpaRepository<Entity 클래스, PK타입>를 상속하면 기본적인 CRUD메소드가 자동으로 생성된다.
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
