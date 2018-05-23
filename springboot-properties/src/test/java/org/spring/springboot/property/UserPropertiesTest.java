package org.spring.springboot.property;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author lichaoi
 * @date 2018年05月23日 13:47
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserPropertiesTest {

    private static final Logger logger = LoggerFactory.getLogger(UserProperties.class);

    @Autowired
    private HomeProperties homeProperties;

    @Test
    public void test_user_print(){
        System.out.println(homeProperties);
    }
}
