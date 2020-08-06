/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kieckegard.sparkjava.di.boilerplate.application.common.context.request;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.util.Assert;

/**
 * Support class that maintains the request destruction callbacks associated to the request
 * scoped beans and has some utility methods for executing them and maintains 
 * a flag indicating if the request is still active or not.
 * 
 * @author Pedro Arthur <pfernandesvasconcelos@gmail.com>
 */
public abstract class AbstractRequestAttributes implements RequestAttributes {

    protected final Map<String, Runnable> requestDestructionCallbacks = new LinkedHashMap<>(8);

    private volatile boolean requestActive = true;

    public boolean isRequestActive() {
        return requestActive;
    }

    public void requestCompleted() {
        this.executeRequestDestructionCallbacks();
        this.requestActive = false;
    }

    /**
     * Remove the request destruction callback for the specified attribute, if
     * any.
     *
     * @param name the name of the attribute to remove the callback for
     */
    protected final void removeRequestDestructionCallback(String name) {
        Assert.notNull(name, "Name must not be null");
        synchronized (this.requestDestructionCallbacks) {
            this.requestDestructionCallbacks.remove(name);
        }
    }

    /**
     * Execute all callbacks that have been registered for execution after
     * request completion.
     */
    private void executeRequestDestructionCallbacks() {
        synchronized (this.requestDestructionCallbacks) {
            this.requestDestructionCallbacks.values().forEach((runnable) -> {
                runnable.run();
            });
            this.requestDestructionCallbacks.clear();
        }
    }

}
