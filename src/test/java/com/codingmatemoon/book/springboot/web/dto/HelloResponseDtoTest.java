package com.codingmatemoon.book.springboot.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        // given
        String name = "test";
        int amount = 1000;
        // when
        // @RequiredArgsConstructor로 생성자가 자동으로 생성되어 new 클래스(필드1[final로 선언], 필드2) 형식으로 인스턴스를 생성할 수 있습니다.
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }

}
