package org.spring.springboot.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lichaoi
 * @date 2018年05月23日 13:54
 */
@RestController
public class UserController {

    @Value("${my.name}")
    private String name;

    @Value("${my.age}")
    private Long age;

    @Value("${my.sex}")
    private String sex;

    @GetMapping("/getUser")
    public String getUser(){
        String str = "name : "+name +" age: "+age+" sex: "+sex;
        System.out.println(str);
        return str;
    }
}
