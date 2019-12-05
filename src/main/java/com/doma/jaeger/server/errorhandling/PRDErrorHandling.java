package com.doma.jaeger.server.errorhandling;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class PRDErrorHandling {

    private static final String CODE = "code";
	private static final String REASON = "reason";

	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public Map<String, String> methodArgumentTypeMismatchException(Exception e) {
		log.error("MethodArgumentTypeMismatchException=", e);

		Map<String, String> exceptionMap = new HashMap<>();
		exceptionMap.put(CODE, "400");
		exceptionMap.put(REASON, "Bad request");
		return exceptionMap;
	}

}