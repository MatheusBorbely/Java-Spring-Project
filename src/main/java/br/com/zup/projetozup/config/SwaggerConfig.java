package br.com.zup.projetozup.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .select()
                .apis((RequestHandlerSelectors.basePackage("br.com.zup.projetozup.rest.controller")))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Projeto Zup")
                .description("API do projeto zup")
                .version("1.0")
                .contact(contact())
                .build();
     }

    public Contact contact(){
        return new Contact("Matheus da Silva Borbely",
                "https://github.com/MatheusBorbely",
               "matheus.silvaborbely@gmail.com");
    }
}
