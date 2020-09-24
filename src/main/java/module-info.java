/**
 * Copyright (c) 2020 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
/**
 * @author TruthBean/Rogar·Q
 * @since 0.1.0
 * Created on 2020-08-05 12:12
 */
module com.truthbean.debbie.fake_spring {
    exports org.springframework.beans.factory.annotation;
    exports org.springframework.boot;
    exports org.springframework.boot.autoconfigure;
    exports org.springframework.boot.context.event;
    exports org.springframework.boot.web.servlet.support;
    exports org.springframework.context;
    exports org.springframework.context.annotation;
    exports org.springframework.core;
    exports org.springframework.core.annotation;
    exports org.springframework.http;
    exports org.springframework.kafka.annotation;
    exports org.springframework.lang;
    exports org.springframework.messaging.handler.annotation;
    exports org.springframework.scheduling.annotation;
    exports org.springframework.stereotype;
    exports org.springframework.transaction.annotation;
    exports org.springframework.util;
    exports org.springframework.web.bind.annotation;
    exports org.springframework.web.multipart;

    requires transitive com.truthbean.debbie.mvc;

    provides com.truthbean.debbie.mvc.router.RouterAnnotationParser
            with com.truthbean.debbie.fakespring.mvc.RequestMappingRouterParser;
    provides com.truthbean.debbie.mvc.request.RequestParameterParser
            with com.truthbean.debbie.fakespring.mvc.SpringRequestParameterParser;
}