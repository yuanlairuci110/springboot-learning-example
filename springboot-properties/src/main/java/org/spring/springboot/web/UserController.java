package org.spring.springboot.web;

import org.spring.springboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private User user;

    @GetMapping("/getUser")
    public String getUser(){
        String str = "name : "+name +" age: "+age+" sex: "+sex;
        System.out.println(str);
        return str;
    }

    @GetMapping("/user")
    public String getUserByProperties(){
        String str = "name : "+user.getName() +"  age:"+user.getAge();
        return str;
    }
}
