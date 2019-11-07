package com.project.tech;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "dynamicEntityManagerFactory", transactionManagerRef = "dynamicTransactionManager", basePackages = {
		"com.dynamic.tech.dao" })
@EntityScan(basePackages = { "com.dynamic.tech.model", "com.dynamic.tech.dao", "com.dynamic.tech.service",
		"com.dynamic.tech.service.impl" })
@ComponentScan({ "com.dynamic.tech", "jar.security" })
@EnableJpaAuditing
public class DynamicConfig {

//	@Primary
//	@Bean(name = "dynamicDataSource")
//	@ConfigurationProperties(prefix = "spring.datasource")
//	public DataSource dataSource() {
//		return DataSourceBuilder.create().build();
//	}

	@Primary
	@Bean(name = "dynamicEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			DataSource dataSource) {
		return builder.dataSource(dataSource).packages("com.dynamic.tech.model").persistenceUnit("DYNAMIC").build();
	}

	@Primary
	@Bean(name = "dynamicTransactionManager")
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

}
