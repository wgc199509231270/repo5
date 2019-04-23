package com.OuSoft.intercept.controller.Intercept;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * 拦截器配置
 * @author pengyueli
 * @date 2018年10月9日
 */
@Configuration
public class WebInterceptorAdapter extends WebMvcConfigurerAdapter{
	 public void addInterceptors(InterceptorRegistry registry) {

		 System.out.println(" 拦截器 ： 不拦截");
		    //拦截规则：除了login，其他都拦截判断
	        registry.addInterceptor(new LoginInterceptController()).addPathPatterns("/**").excludePathPatterns("/OA2");
	        super.addInterceptors(registry);
	        //拦截器
		    registry.addInterceptor(new LoginInterceptController());
	        System.out.println("===========   拦截器注册完毕   ===========");
	    }

	
	
	
}
