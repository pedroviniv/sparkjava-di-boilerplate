/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.sparkjava.di.boilerplate.application.common.context.request;

import javax.servlet.http.HttpServletRequest;

/**
 * initializes and destroys the {@link RequestContextHolder} with a {@link HttpServletRequest}
 * It must be used when a request is created and when a request is about the be released.
 * 
 * @author Pedro Arthur <pfernandesvasconcelos@gmail.com>
 */
public class RequestContextHolderLifeCycle {

    private static final String REQUEST_ATTRIBUTES_ATTRIBUTE
            = RequestContextHolderLifeCycle.class.getName() + ".REQUEST_ATTRIBUTES";

    public static void requestInitialized(HttpServletRequest request) {
        ServletRequestAttributes attributes = new ServletRequestAttributes(request);
        request.setAttribute(REQUEST_ATTRIBUTES_ATTRIBUTE, attributes);
        RequestContextHolder.setRequestAttributes(attributes);
    }

    public static void requestDestroyed(HttpServletRequest request) {
        ServletRequestAttributes attributes = null;
        Object innerAttributes = request.getAttribute(REQUEST_ATTRIBUTES_ATTRIBUTE);
        if (innerAttributes instanceof ServletRequestAttributes) {
            attributes = (ServletRequestAttributes) innerAttributes;
        }

        RequestAttributes threadAttributes = RequestContextHolder.getRequestAttributes();
        if (threadAttributes != null) {
            RequestContextHolder.resetRequestAttributes();
            if (attributes == null && threadAttributes instanceof ServletRequestAttributes) {
                attributes = (ServletRequestAttributes) threadAttributes;
            }
        }

        if (attributes != null) {
            attributes.requestCompleted();
        }
    }

}
