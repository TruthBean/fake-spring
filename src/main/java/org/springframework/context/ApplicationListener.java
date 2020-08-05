package org.springframework.context;

import com.truthbean.debbie.event.GenericStartedEventListener;

@FunctionalInterface
public interface ApplicationListener<E extends ApplicationEvent> extends GenericStartedEventListener<E> {

    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    void onApplicationEvent(E event);
}