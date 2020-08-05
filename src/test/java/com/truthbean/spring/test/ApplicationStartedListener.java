package com.truthbean.spring.test;

import com.truthbean.Logger;
import com.truthbean.debbie.event.EventBeanListener;
import com.truthbean.logger.LoggerFactory;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.lang.NonNull;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.1.0
 * Created on 2020-04-01 16:39.
 */
@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
@EventBeanListener
public class ApplicationStartedListener implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(@NonNull ApplicationStartedEvent event) {
        LOGGER.info(() -> "hello from fake spring.");
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationStartedListener.class);
}
