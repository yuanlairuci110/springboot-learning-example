package springboot.lc.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lichao on 2018/4/9.
 * springboot 配置文件
 */
@RestController
public class MiyaController {

    private Logger logger = LoggerFactory.getLogger(MiyaController.class);

    @Value("${my.name}")
    private String name;
    @Value("${my.age}")
    private int age;

    @RequestMapping(value = "/miya")
    public String miya(){
        return name+" : "+age;
    }

}
