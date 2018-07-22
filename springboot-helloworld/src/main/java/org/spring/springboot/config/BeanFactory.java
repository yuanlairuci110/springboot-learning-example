package org.spring.springboot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.springboot.web.ServletTest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author lichao
 * @date 2018年07月22 17:35
 */
@Component
public class BeanFactory {
    
    private Logger logger = LoggerFactory.getLogger(BeanFactory.class);
    
	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		return new ServletRegistrationBean(new ServletTest(), "/servletTest");
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("Let's inspect the beans provided by Spring Boot:");
			String[] beanNames = ctx.getBeanDefinitionNames();
			logger.info("Let's inspect the beans provided by Spring Boot:");
			// Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
				logger.info(beanName);
			}
		};
	}
}
