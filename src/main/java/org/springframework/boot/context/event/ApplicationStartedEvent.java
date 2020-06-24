/**
 * Copyright (c) 2020 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package org.springframework.boot.context.event;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SuppressWarnings("serial")
public class ApplicationStartedEvent extends SpringApplicationEvent {

    private final ConfigurableApplicationContext context;

    /**
     * Create a new {@link ApplicationStartedEvent} instance.
     * @param application the current application
     * @param args the arguments the application is running with
     * @param context the context that was being created
     */
    public ApplicationStartedEvent(SpringApplication application, String[] args,
                                   ConfigurableApplicationContext context) {
        super(application, args);
        this.context = context;
    }

    /**
     * Return the application context.
     * @return the context
     */
    public ConfigurableApplicationContext getApplicationContext() {
        return this.context;
    }

}
