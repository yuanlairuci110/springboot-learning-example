package springboot.lc.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;
import springboot.lc.test.domain.RequestMessage;
import springboot.lc.test.domain.ResponseMessage;

/**
 * Created by lichao on 2018/4/15.
 */
@RestController
public class WBController {
    private Logger logger = LoggerFactory.getLogger(WBController.class);

    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public ResponseMessage say(RequestMessage message) {
        logger.info("发送消息："+message);
        System.out.println(message.getName());
        return new ResponseMessage("welcome," + message.getName() + " !");
    }
}
