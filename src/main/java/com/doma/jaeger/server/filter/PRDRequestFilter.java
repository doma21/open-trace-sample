package com.doma.jaeger.server.filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.opentracing.Tracer;

@Component
public class PRDRequestFilter implements Filter {
	
	@Autowired
	private Tracer tracer;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		try {
			MDC.put("SESSION_ID", ((HttpServletRequest)request).getSession().getId());
			MDC.put("ORIGIN", ((HttpServletRequest)request).getHeader("Origin"));
			if( tracer.activeSpan() != null ) {
				MDC.put("TRACE_ID", tracer.activeSpan().context().toTraceId());
			}
			chain.doFilter(request, response);
			
		} finally {
			MDC.clear();
		}
		
	}
	@Override
	public void init(FilterConfig config){

	}

	@Override
	public void destroy(){

	}

}
