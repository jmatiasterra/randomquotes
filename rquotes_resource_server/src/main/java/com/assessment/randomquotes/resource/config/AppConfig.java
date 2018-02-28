/**
 * 
 */
package com.assessment.randomquotes.resource.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author matias.terracciano
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.assessment.randomquotes.resource")
@PropertySource(value = { "classpath:application.properties" })
public class AppConfig extends WebMvcConfigurerAdapter {

}
