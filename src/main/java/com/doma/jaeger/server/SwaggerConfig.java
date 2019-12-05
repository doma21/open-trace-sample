/*<CHICOSCOPYRIGHT>
 *
 * Copyright (C) 2006-2019 Chico's.
 * All Rights Reserved.  No use, copying or distribution
 * of this work may be made except in accordance with a
 * valid license agreement from Chico's.  This notice
 * must be included on all copies, modifications and
 * derivatives of this work.
 *
 * Chico's MAKES NO REPRESENTATIONS OR WARRANTIES
 * ABOUT THE SUITABILITY OF THE SOFTWARE, EITHER EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR
 * PURPOSE, OR NON-INFRINGEMENT. MY COMPANY SHALL NOT BE
 * LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT
 * OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS
 * DERIVATIVES.
 *
 *</CHICOSCOPYRIGHT>*/
/**
 * 
 */
package com.doma.jaeger.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean

	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage(App.class.getPackage().getName()))
				.paths(PathSelectors.any()).build().apiInfo(apiEndPointsInfo());
	}

	protected ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder().title("Open Tracing..").description("Service demonstrating open tracing..").license(null)
				.licenseUrl(null).version(null).build();
	}
}