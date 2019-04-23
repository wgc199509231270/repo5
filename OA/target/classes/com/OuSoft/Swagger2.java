package com.OuSoft;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author EcharWu
 * @date 2018年5月28日 上午13:45:55
 * @version V1.0
 */
@Configuration
@ComponentScan(basePackages = { "com.OuSoft.system.controller.*" })//配置controller路径 , 如果想用多个数据源,用","隔开
@EnableSwagger2
@SuppressWarnings({"unchecked","deprecation"})
public class Swagger2 {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .paths(Predicates.or(
                        //这里添加你需要展示的接口
                        PathSelectors.ant("/*/**")
                        )
                )
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringBoot")
                .description("说明RESTful APIs")
                .contact("什么鬼@qq.com")
                .version("1.0")
                .build();
    }
}
