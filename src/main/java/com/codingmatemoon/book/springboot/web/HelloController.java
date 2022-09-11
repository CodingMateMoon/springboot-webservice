package com.codingmatemoon.book.springboot.web;

import com.codingmatemoon.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    // @RequestParam : 외부에서 API 호출시 전달하는 파라미터를 가져오는 어노테이션
    @GetMapping("/hello/dto")
    public HelloResponseDto hellDto(@RequestParam("name") String name, @RequestParam("amount") int amount){

        return new HelloResponseDto(name, amount);
    }
}


