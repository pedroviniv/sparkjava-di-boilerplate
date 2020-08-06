/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.sparkjava.di.boilerplate.application.common.context.request;

/**
 * Contract that defines a component that manipulates request attributes.
 * 
 * @author Pedro Arthur <pfernandesvasconcelos@gmail.com>
 */
public interface RequestAttributes {
    
    /**
     * resolves the contextual reference for the given key.
     * <p>e.g. "HttpServletRequest" for "request"</p>
     * @param key
     * @return corresponding object or {@code null} if none found
     */
    Object resolveReference(String key);
    
    /**
     * removes an attribute
     * @param name 
     */
    void removeAttribute(String name);
    
    /**
     * adds a new attribute (replacing existent with the same name)
     * @param name
     * @param value 
     */
    void setAttribute(String name, Object value);
    
    /**
     * gets an attribute by the given name
     * @param name
     * @return 
     */
    Object getAttribute(String name);
}
