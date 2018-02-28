/**
 * 
 */
package com.assessment.randomquotes.resources.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ActiveProfiles;

/**
 * @author matias.terracciano
 *
 */
@Configuration
@ComponentScan(basePackages = {"com.assessment.randomquotes.resource.dao"})
@ActiveProfiles("test")
public class TestConfig {
	
	

}
