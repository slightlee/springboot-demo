package com.slightlee.platform.config;

import com.github.xiaoymin.knife4j.spring.extension.OpenApiExtensionResolver;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
public class SwaggerConfig {

    /**
     * 自定义 footer 用到
     */
    @Autowired
    private OpenApiExtensionResolver openApiExtensionResolver;

    @Bean
    public Docket createRestApi() {

        String groupName="1.0.0 版本";

        return new Docket(DocumentationType.SWAGGER_2)

                // 添加 自定义 footer
                .extensions(openApiExtensionResolver.buildSettingExtensions())
                // 添加 自定义文档
                .groupName(groupName)
                .extensions(openApiExtensionResolver.buildExtensions(groupName))

                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.slightlee.platform"))
//                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))  //指定接口包所在路径
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))  //方法上面有@ApiOperation注解 生成接口文档
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("XX项目接口文档")
                .description("XX项目API接口文档")
                .termsOfServiceUrl("http://localhost:8661/")
                .contact(new Contact("明天","www.xxx.com","lmm_@163.com"))
                .version("1.0")
                .build();
    }


}
