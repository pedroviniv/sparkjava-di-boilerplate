/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.sparkjava.di.boilerplate.application.common.context.scopes.request;

import io.github.kieckegard.sparkjava.di.boilerplate.application.common.context.request.RequestAttributes;
import io.github.kieckegard.sparkjava.di.boilerplate.application.common.context.request.RequestContextHolder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

/**
 * scope that uses {@link RequestContextHolder} maintain managed beans with request
 * scope.
 * 
 * @author Pedro Arthur <pfernandesvasconcelos@gmail.com>
 */
public class RequestScope implements Scope {

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        RequestAttributes attributes = RequestContextHolder.currentRequestAttributes();
        Object scopedObject = attributes.getAttribute(name);

        if (scopedObject == null) {
            scopedObject = objectFactory.getObject();
            attributes.setAttribute(name, scopedObject);
        }

        return scopedObject;
    }

    @Override
    public Object remove(String name) {
        RequestAttributes attributes = RequestContextHolder.currentRequestAttributes();
        Object scopedObject = attributes.getAttribute(name);
        if (scopedObject != null) {
            attributes.removeAttribute(name);
            return scopedObject;
        } else {
            return null;
        }
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {
    }

    @Override
    public Object resolveContextualObject(String key) {
        RequestAttributes attributes = RequestContextHolder.currentRequestAttributes();
        return attributes.resolveReference(key);
    }

    /**
     * There is no conversation id concept for a request, so this method returns
     * {@code null}.
     */
    @Override
    public String getConversationId() {
        return null;
    }

}
