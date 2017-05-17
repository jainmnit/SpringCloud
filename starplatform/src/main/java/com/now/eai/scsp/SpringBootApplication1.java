package com.now.eai.scsp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableCircuitBreaker
//@EnableSwagger2
//@EnableGemfireRepositories
@EnableCaching

public class SpringBootApplication1 {
		
		public static void main(String[] args) {
			SpringApplication.run(SpringBootApplication1.class, args);
			System.out.println("Starplatform service started:");
		}

		/* @Bean
		    public Docket api() throws IOException, XmlPullParserException {
		        
		        
		        Docket doc =  new Docket(DocumentationType.SWAGGER_2)
		          .select()
		          .apis(RequestHandlerSelectors.basePackage("com.now.eai.scsp.controller"))
		          .paths(PathSelectors.any())
		          .build().apiInfo(apiInfo());
		        
		        doc.host("owpgateway-test-services.apps.dev.api.mbusa.oneweb.mercedes-benz.cinteo.de/scsp/api");
		        
		        return doc;
		          
		        
		          //.build().apiInfo(new ApiInfo("EAI" , "EAI", "1.1", "www.mbusa.com",new Contact(), "", ""));
		 }
		 
		 private ApiInfo apiInfo() {
		        return new ApiInfoBuilder()
		                .title("EAI Services API")
		                .description("STARPLATFORM API documentation")
		                .termsOfServiceUrl("mailto:stareai@mbusa.com")
		                .contact("EAI TEAM")
		                .license("MBUSA")
		                .licenseUrl("https://mbusa.com")
		                .version("1.0")
		                .build();
		    }
		 
			
			@Bean
			UiConfiguration uiConfig() {
			    return new UiConfiguration("validatorUrl", "list", "alpha", "schema",
			            UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS, false, true, 60000L);
			} */
}
