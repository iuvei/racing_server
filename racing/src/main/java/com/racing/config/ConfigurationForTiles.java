package com.racing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebSecurity
public class ConfigurationForTiles {

  @Bean
  public TilesConfigurer tilesConfigurer() {
    final TilesConfigurer configurer = new TilesConfigurer();
    configurer.setDefinitions(new String[] {"WEB-INF/layouts/layouts.xml", "WEB-INF/stakeView/views.xml"});
    configurer.setCheckRefresh(true);
    return configurer;
  }

  @Bean
  public TilesViewResolver tilesViewResolver() {
    final TilesViewResolver resolver = new TilesViewResolver();
    resolver.setViewClass(TilesView.class);
    return resolver;
  }

}
