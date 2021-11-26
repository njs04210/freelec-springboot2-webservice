package com.kimjinjoo.book.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) // Target - 이 어노테이션이 생성될 수 있는 위치 지정. PARAMETER => 메소드의 파라미터로 선언된 객체에서만 사용할 수 있음
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser { // 어느 컨트롤러든지 @LoginUser만 사용하면 세션 정보를 가져올 수 있도록 어노테이션화하기.
}
