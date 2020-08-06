/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.sparkjava.di.boilerplate.application.common.context.request;

import org.springframework.lang.Nullable;

/**
 *
 * @author Pedro Arthur <pfernandesvasconcelos@gmail.com>
 */
public class RequestContextHolder {

    private static final ThreadLocal<RequestAttributes> REQUEST_ATTRIBUTES_HOLDER
            = new InheritableThreadLocal<>();

    /**
     * Reset the RequestAttributes for the current thread.
     */
    public static void resetRequestAttributes() {
        REQUEST_ATTRIBUTES_HOLDER.remove();
    }

    public static void setRequestAttributes(@Nullable RequestAttributes attributes) {
        doSetRequestAttributes(attributes);
    }

    public static void doSetRequestAttributes(@Nullable RequestAttributes attributes) {
        if (attributes == null) {
            resetRequestAttributes();
        } else {
            REQUEST_ATTRIBUTES_HOLDER.set(attributes);
        }
    }

    public static RequestAttributes getRequestAttributes() {
        RequestAttributes attributes = REQUEST_ATTRIBUTES_HOLDER.get();
        return attributes;
    }
    
    public static RequestAttributes currentRequestAttributes() {
        RequestAttributes attributes = REQUEST_ATTRIBUTES_HOLDER.get();
        if (attributes == null) {
            throw new IllegalStateException(
                    "No thread-bound request found: " +
                            "Are you referring to request attributes outside of an actual web request," +
                            "Or are you processing a request outside the original thread?"
            );
        }
        
        return attributes;
    }
}
