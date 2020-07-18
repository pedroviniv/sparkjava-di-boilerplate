/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.sparkjava.di.boilerplate.application.v1.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * settings of the Security part of the application.
 * it defines, for instance, which header the token must be provided.
 * 
 * @author Pedro Arthur <pfernandesvasconcelos@gmail.com>
 */
@Component
public class SecuritySettings {
    
    @Value("${application.security.token.header}")
    private String tokenHeader;

    public String getTokenHeader() {
        return tokenHeader;
    }

    @Override
    public String toString() {
        return "SecuritySettings{" + "tokenHeader=" + tokenHeader + '}';
    }
}
