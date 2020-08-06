/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.sparkjava.di.boilerplate.application.common.context.scopes.request;

import io.github.kieckegard.sparkjava.di.boilerplate.application.common.context.scopes.ScopeDefinitions;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * implementation of {@link BeanFactoryPostProcessor} that registers 
 * our {@link RequestScope} binding it to the key {@link ScopeDefinitions#REQUEST}.
 * 
 * @author Pedro Arthur <pfernandesvasconcelos@gmail.com>
 */
public class RequestBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        beanFactory.registerScope(ScopeDefinitions.REQUEST, new RequestScope());
    }
    
}
