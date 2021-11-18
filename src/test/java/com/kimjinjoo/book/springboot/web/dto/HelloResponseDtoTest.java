package com.kimjinjoo.book.springboot.web.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto helloResponseDto = new HelloResponseDto(name, amount);

        //then
        assertThat(helloResponseDto.getAmount()).isEqualTo(amount);
        assertThat(helloResponseDto.getName()).isEqualTo(name);
    }
}
