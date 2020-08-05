/**
 * Copyright (c) 2020 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package org.springframework.boot;

import com.truthbean.debbie.bean.BeanType;
import com.truthbean.debbie.bean.DebbieBeanInfo;
import com.truthbean.debbie.bean.GlobalBeanFactory;
import com.truthbean.debbie.boot.DebbieApplication;
import com.truthbean.debbie.core.ApplicationContext;
import com.truthbean.debbie.core.ApplicationFactory;
import com.truthbean.debbie.event.DebbieEventPublisher;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.1.0
 * Created on 2020-06-23 11:28.
 */
public class SpringApplication {

    private static final SpringApplication instance = new SpringApplication();

    private SpringApplication() {
    }

    public static void run(Class<?> primarySource, String... args) {
        System.setProperty("debbie.web.default.response.allow-client", "true");
        System.setProperty("debbie.web.default.response.types", "application/json;Charset=UTF-8");
        DebbieBeanInfo<ApplicationStartedEvent> beanInfo = new DebbieBeanInfo<>(ApplicationStartedEvent.class);
        beanInfo.setBean(new ApplicationStartedEvent(instance, args, new ConfigurableApplicationContext()));
        beanInfo.setBeanType(BeanType.SINGLETON);
        beanInfo.addBeanName("applicationStartedEvent");
        ApplicationFactory factory = ApplicationFactory.configure(primarySource);
        ApplicationContext applicationContext = factory.getApplicationContext();
        applicationContext.getBeanInitialization().initSingletonBean(beanInfo);
        applicationContext.refreshBeans();

        // todo
        DebbieApplication application = factory.postCreateApplication();
        GlobalBeanFactory globalBeanFactory = applicationContext.getGlobalBeanFactory();
        DebbieEventPublisher eventPublisher = globalBeanFactory.factory("eventPublisher");

        application.start(args);
    }
}
