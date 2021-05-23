/**
 * Copyright (c) 2021 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package org.springframework.context;

import com.truthbean.debbie.bean.BeanInfoFactory;
import com.truthbean.debbie.bean.BeanInitialization;
import com.truthbean.debbie.bean.GlobalBeanFactory;
import com.truthbean.debbie.bean.InjectedBeanFactory;
import com.truthbean.debbie.boot.ApplicationArgs;
import com.truthbean.debbie.core.ApplicationContext;
import com.truthbean.debbie.env.EnvironmentContent;
import com.truthbean.debbie.io.ResourceResolver;
import com.truthbean.debbie.properties.DebbieConfigurationCenter;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.1.0
 * Created on 2020-06-23 13:59.
 */
public class ConfigurableApplicationContext implements ApplicationContext {
    private final ApplicationContext applicationContext;

    public ConfigurableApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public ApplicationArgs getApplicationArgs() {
        return applicationContext.getApplicationArgs();
    }

    @Override
    public ClassLoader getClassLoader() {
        return applicationContext.getClassLoader();
    }

    @Override
    public EnvironmentContent getEnvContent() {
        return applicationContext.getEnvContent();
    }

    @Override
    public ResourceResolver getResourceResolver() {
        return applicationContext.getResourceResolver();
    }

    @Override
    public BeanInitialization getBeanInitialization() {
        return applicationContext.getBeanInitialization();
    }

    @Override
    public BeanInfoFactory getBeanInfoFactory() {
        return applicationContext.getBeanInfoFactory();
    }

    @Override
    public DebbieConfigurationCenter getConfigurationCenter() {
        return applicationContext.getConfigurationCenter();
    }

    @Override
    public InjectedBeanFactory getInjectedBeanFactory() {
        return applicationContext.getInjectedBeanFactory();
    }

    @Override
    public GlobalBeanFactory getGlobalBeanFactory() {
        return applicationContext.getGlobalBeanFactory();
    }

    @Override
    public void refreshBeans() {
        applicationContext.refreshBeans();
    }

    @Override
    public <O, T> T transform(O origin, Class<T> target) {
        return null;
    }

    @Override
    public <T> T factory(String beanName) {
        return null;
    }

    @Override
    public <T> T factory(Class<T> beanType) {
        return null;
    }

    @Override
    public void release(String... args) {

    }
}
