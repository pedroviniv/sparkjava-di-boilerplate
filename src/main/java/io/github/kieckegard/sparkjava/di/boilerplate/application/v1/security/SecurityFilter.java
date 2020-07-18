/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.sparkjava.di.boilerplate.application.v1.security;

import io.github.kieckegard.sparkjava.di.boilerplate.common.strings.Strings;
import org.springframework.stereotype.Component;
import spark.Filter;
import spark.Request;
import spark.Response;
import static spark.Spark.halt;

/**
 * Simple security filter that only checks if a Bearer token
 * was provided in the specified header.
 * 
 * @author Pedro Arthur <pfernandesvasconcelos@gmail.com>
 */
@Component
public class SecurityFilter implements Filter {
    
    private final SecuritySettings securitySettings;

    public SecurityFilter(SecuritySettings securitySettings) {
        this.securitySettings = securitySettings;
    }

    @Override
    public void handle(Request request, Response response) throws Exception {
        
        final String authorizationHeader = request.headers(this.securitySettings.getTokenHeader());
        
        if (Strings.isNullOrEmpty(authorizationHeader)) {
            throw halt(403, "You must provide a token");
        }
        
        final String token = authorizationHeader.substring(7, authorizationHeader.length());
        if (Strings.isNullOrEmpty(token)) {
            throw halt(403, "You must provide a token");
        }
    }
    
}
