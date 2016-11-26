package com.makingdevs.config

import groovy.transform.CompileStatic
import groovy.transform.TypeChecked
import groovy.transform.TypeCheckingMode
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.JpaVendorAdapter
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.Database
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.support.AbstractPlatformTransactionManager

import javax.sql.DataSource

/**
 * Created by makingdevs on 11/25/16.
 */
@Configuration
@EnableJpaRepositories("com.makingdevs.repositories")
@CompileStatic
class AppConfig {

  @Bean
  @TypeChecked(TypeCheckingMode.SKIP)
  DataSource dataSource() {
    new DriverManagerDataSource(
        url: "jdbc:mysql://localhost/employees",
        driverClassName: "com.mysql.jdbc.Driver",
        username: "makingdevs",
        password: "makingdevs")
  }

  @Bean
  JpaVendorAdapter jpaVendorAdapter(){
    HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter()
    adapter.with {
      database = Database.MYSQL
      generateDdl = false
    }
    adapter
  }

  @Bean
  LocalContainerEntityManagerFactoryBean entityManagerFactory(){
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean()
    em.dataSource = dataSource()
    em.jpaVendorAdapter = jpaVendorAdapter()
    em.packagesToScan = ["com.makingdevs.model"]
    em
  }

  @Bean
  AbstractPlatformTransactionManager transactionManager(){
    new JpaTransactionManager(entityManagerFactory().object)
  }
}
