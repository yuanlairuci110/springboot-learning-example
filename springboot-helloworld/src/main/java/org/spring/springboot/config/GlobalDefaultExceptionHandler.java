package org.spring.springboot.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lichao
 * @date 2018年07月22 18:16 说明：全局异常处理
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	/**
	 * 处理 Exception 类型的异常
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Map<String, Object> defaultExceptionHandler(Exception e) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", -1);
		map.put("msg", e.getMessage());
		map.put("error", e);
		return map;
	}
}
