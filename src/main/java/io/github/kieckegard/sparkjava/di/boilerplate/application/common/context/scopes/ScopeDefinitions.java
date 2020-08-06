/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.sparkjava.di.boilerplate.application.common.context.scopes;

import io.github.kieckegard.sparkjava.di.boilerplate.application.common.context.scopes.request.RequestScope;

/**
 * constants used to identify all of our custom scope implementations.
 * 
 * @author Pedro Arthur <pfernandesvasconcelos@gmail.com>
 */
public class ScopeDefinitions {
    
    /**
     * identifies {@link RequestScope}. use this constant when defining @Component
     * and @Bean's which life cycle should be associated by the request.
     */
    public static final String REQUEST = "sparkjava-request";
}
