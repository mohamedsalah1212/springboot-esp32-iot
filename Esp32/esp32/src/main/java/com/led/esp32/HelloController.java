package com.led.esp32;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
public class HelloController {

    @GetMapping("/hello")
    public String hello(){

        return "HelloWorld";
    }
}
