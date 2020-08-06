/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.sparkjava.di.boilerplate.application.common.context.request;

import javax.servlet.http.HttpServletRequest;

/**
 * Implementation of {@link RequestAttributes} that uses the {@link HttpServletRequest}
 * as storage to store and retrieve attributes in/from the request.
 * 
 * @author Pedro Arthur <pfernandesvasconcelos@gmail.com>
 */
public class ServletRequestAttributes extends AbstractRequestAttributes {
    
    private final HttpServletRequest request;

    public ServletRequestAttributes(HttpServletRequest request) {
        this.request = request;
    }

    @Override
    public Object resolveReference(String key) {
        return this.request;
    }

    @Override
    public void removeAttribute(String name) {
        if (!isRequestActive()) {
            return;
        }
        
        removeRequestDestructionCallback(name);
        this.request.removeAttribute(name);
    }

    @Override
    public void setAttribute(String name, Object value) {
        if (!isRequestActive()) {
            throw new IllegalArgumentException("Can't set request attribute when the request is not active anymore");
        }
        
        this.request.setAttribute(name, value);
    }

    @Override
    public Object getAttribute(String name) {
        return this.request.getAttribute(name);
    }
    
}
