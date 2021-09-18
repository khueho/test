package poly.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import poly.edu.interceptor.GloballInterceptor;

@Configuration
public class interCepterconfig implements WebMvcConfigurer {
	@Autowired
	GloballInterceptor glbinterceptor;
	  
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(glbinterceptor)
		.addPathPatterns("/**")
		.excludePathPatterns("/rest/**" , "/admin/**" ,"assets/**");
	}
	
	
	

}
