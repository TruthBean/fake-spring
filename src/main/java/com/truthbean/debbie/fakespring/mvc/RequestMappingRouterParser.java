/**
 * Copyright (c) 2020 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.debbie.fakespring.mvc;

import com.truthbean.debbie.io.MediaType;
import com.truthbean.debbie.mvc.request.HttpMethod;
import com.truthbean.debbie.mvc.router.RouterAnnotationInfo;
import com.truthbean.debbie.mvc.router.RouterAnnotationParser;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.1.0
 * Created on 2020-09-21 14:24
 */
public class RequestMappingRouterParser implements RouterAnnotationParser {
    @Override
    public RouterAnnotationInfo parse(Method method) {
        boolean hasResponseBody = false;
        var responseBody = method.getAnnotation(ResponseBody.class);
        if (responseBody == null) {
            Class<?> declaringClass = method.getDeclaringClass();
            responseBody = declaringClass.getAnnotation(ResponseBody.class);
            if (responseBody == null) {
                RestController annotation = declaringClass.getAnnotation(RestController.class);
                hasResponseBody = annotation != null;
            }
        } else {
            hasResponseBody = true;
        }

        var requestMapping = method.getAnnotation(RequestMapping.class);
        DeleteMapping deleteMapping = method.getAnnotation(DeleteMapping.class);
        GetMapping getMapping = method.getAnnotation(GetMapping.class);
        PostMapping postMapping = method.getAnnotation(PostMapping.class);
        PutMapping putMapping = method.getAnnotation(PutMapping.class);
        if (requestMapping != null) {
            return parse(requestMapping, hasResponseBody);
        } else if (deleteMapping != null) {
            return parse(deleteMapping, hasResponseBody);
        } else if (getMapping != null) {
            return parse(getMapping, hasResponseBody);
        } else if (postMapping != null) {
            return parse(postMapping, hasResponseBody);
        } else if (putMapping != null) {
            return parse(putMapping, hasResponseBody);
        }

        return null;
    }

    public RouterAnnotationInfo parse(RequestMapping requestMapping, boolean hasResponseBody) {
        var info = new RouterAnnotationInfo();
        var consumes = requestMapping.consumes();
        var produces = requestMapping.produces();
        var method = requestMapping.method();
        info.setName(requestMapping.name())
                .setValue(requestMapping.value())
                .setUrlPatterns(requestMapping.path());
        if (method.length > 0) {
            info.setMethod(Arrays.stream(method).map(RequestMethod::toHttpMethod).toArray(value -> new HttpMethod[0]));
        } else {
            info.setMethod(Collections.singleton(HttpMethod.ALL));
        }
        if (consumes.length > 0) {
            info.setRequestType(consumes[0]);
        } else {
            info.setRequestType(MediaType.ANY);
        }
        if (produces.length > 0) {
            info.setResponseType(MediaType.of(produces[0]));
        } else {
            info.setResponseType(MediaType.ANY);
        }
        info.setHasTemplate(!hasResponseBody);
        info.setTemplatePrefix("");
        info.setTemplateSuffix("");
        return info;
    }

    public RouterAnnotationInfo parse(DeleteMapping requestMapping, boolean hasResponseBody) {
        var info = new RouterAnnotationInfo();
        var consumes = requestMapping.consumes();
        var produces = requestMapping.produces();
        info.setName(requestMapping.name())
                .setValue(requestMapping.value())
                .setUrlPatterns(requestMapping.path())
                .setMethod(Collections.singleton(HttpMethod.DELETE));
        if (consumes.length > 0) {
            info.setRequestType(consumes[0]);
        } else {
            info.setRequestType(MediaType.ANY);
        }
        if (produces.length > 0) {
            info.setResponseType(MediaType.of(produces[0]));
        } else {
            info.setResponseType(MediaType.ANY);
        }
        info.setHasTemplate(!hasResponseBody);
        info.setTemplatePrefix("");
        info.setTemplateSuffix("");
        return info;
    }

    public RouterAnnotationInfo parse(GetMapping requestMapping, boolean hasResponseBody) {
        var info = new RouterAnnotationInfo();
        var consumes = requestMapping.consumes();
        var produces = requestMapping.produces();
        info.setName(requestMapping.name())
                .setValue(requestMapping.value())
                .setUrlPatterns(requestMapping.path())
                .setMethod(Collections.singleton(HttpMethod.DELETE));
        if (consumes.length > 0) {
            info.setRequestType(consumes[0]);
        } else {
            info.setRequestType(MediaType.ANY);
        }
        if (produces.length > 0) {
            info.setResponseType(MediaType.of(produces[0]));
        } else {
            info.setResponseType(MediaType.ANY);
        }
        info.setHasTemplate(!hasResponseBody);
        info.setTemplatePrefix("");
        info.setTemplateSuffix("");
        return info;
    }

    public RouterAnnotationInfo parse(PostMapping requestMapping, boolean hasResponseBody) {
        var info = new RouterAnnotationInfo();
        var consumes = requestMapping.consumes();
        var produces = requestMapping.produces();
        info.setName(requestMapping.name())
                .setValue(requestMapping.value())
                .setUrlPatterns(requestMapping.path())
                .setMethod(Collections.singleton(HttpMethod.DELETE));
        if (consumes.length > 0) {
            info.setRequestType(consumes[0]);
        } else {
            info.setRequestType(MediaType.ANY);
        }
        if (produces.length > 0) {
            info.setResponseType(MediaType.of(produces[0]));
        } else {
            info.setResponseType(MediaType.ANY);
        }
        info.setHasTemplate(!hasResponseBody);
        info.setTemplatePrefix("");
        info.setTemplateSuffix("");
        return info;
    }

    public RouterAnnotationInfo parse(PutMapping requestMapping, boolean hasResponseBody) {
        var info = new RouterAnnotationInfo();
        var consumes = requestMapping.consumes();
        var produces = requestMapping.produces();
        info.setName(requestMapping.name())
                .setValue(requestMapping.value())
                .setUrlPatterns(requestMapping.path())
                .setMethod(Collections.singleton(HttpMethod.DELETE));
        if (consumes.length > 0) {
            info.setRequestType(consumes[0]);
        } else {
            info.setRequestType(MediaType.ANY);
        }
        if (produces.length > 0) {
            info.setResponseType(MediaType.of(produces[0]));
        } else {
            info.setResponseType(MediaType.ANY);
        }
        info.setHasTemplate(!hasResponseBody);
        info.setTemplatePrefix("");
        info.setTemplateSuffix("");
        return info;
    }
}
