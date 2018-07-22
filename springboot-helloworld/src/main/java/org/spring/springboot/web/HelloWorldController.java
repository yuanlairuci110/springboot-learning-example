package org.spring.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Boot HelloWorld 案例
 *
 * Created by bysocket on 16/4/26.
 */
@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String sayHello() {
        return "Hello,World!";
    }

    @GetMapping("/test1")
    public String say_helloWorld(){
        return "hello world";
    }

    @GetMapping("/test2")
    public String say_helloWorld2(){
        return "hello world 222222222";
    }
}
