package com.racing.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableWebSecurity
public class ApplicationConfig {

	/**
	 * 设置返回json的格式化
	 * 
	 * @return
	 */
	@Bean
	public MappingJackson2HttpMessageConverter jacksonConverterMapper() {
		MappingJackson2HttpMessageConverter httpMessageConverter = new MappingJackson2HttpMessageConverter(
				new ObjectMapper());
		List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
		supportedMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
		supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
		supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
		httpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
		httpMessageConverter.setPrettyPrint(true);

		return httpMessageConverter;
	}

	/**
	 * 开启GZIP压缩模式
	 * 
	 * @return
	 */
	// @Bean
	// public Filter compressingFilter() {
	// CompressingFilter compressingFilter = new CompressingFilter();
	// return compressingFilter;
	// }
}
