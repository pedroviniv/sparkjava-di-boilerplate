/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.sparkjava.di.boilerplate.application.common.context.scopes.request;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration of the {@link RequestScope} it just exposes to
 * the spring context, a {@link RequestBeanFactoryPostProcessor} instance.
 * 
 * Without this configuration class, the spring-context couldn't use our {@link RequestScope}
 * implementation.
 * 
 * @author Pedro Arthur <pfernandesvasconcelos@gmail.com>
 */
@Configuration
public class RequestScopeConfig {
    
    @Bean
    public static BeanFactoryPostProcessor provideRequestBeanFactoryPostProcessor() {
        return new RequestBeanFactoryPostProcessor();
    }
}
