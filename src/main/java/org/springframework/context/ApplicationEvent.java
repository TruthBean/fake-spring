package org.springframework.context;

import com.truthbean.debbie.event.DebbieStartedEvent;

public abstract class ApplicationEvent extends DebbieStartedEvent {

    /**
     * use serialVersionUID from Spring 1.2 for interoperability.
     */
    private static final long serialVersionUID = 7099057708183571937L;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public ApplicationEvent(Object source) {
        super(source);
    }

}