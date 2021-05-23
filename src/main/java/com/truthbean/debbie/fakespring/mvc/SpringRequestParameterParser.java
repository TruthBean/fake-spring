/**
 * Copyright (c) 2021 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.debbie.fakespring.mvc;

import com.truthbean.debbie.io.MediaType;
import com.truthbean.debbie.mvc.request.RequestParameterInfo;
import com.truthbean.debbie.mvc.request.RequestParameterParser;
import com.truthbean.debbie.mvc.request.RequestParameterType;
import com.truthbean.debbie.reflection.ExecutableArgument;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Parameter;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.1.0
 * Created on 2020-09-24 10:55
 */
public class SpringRequestParameterParser implements RequestParameterParser {
    @Override
    public RequestParameterInfo parse(Annotation annotation) {
        RequestParameterInfo info = null;
        if (annotation instanceof CookieValue) {
            CookieValue cookieValue = (CookieValue) annotation;
            info = new RequestParameterInfo.Builder()
                    .name(cookieValue.name())
                    .value(cookieValue.value())
                    .require(cookieValue.required())
                    .paramType(RequestParameterType.COOKIE)
                    .defaultValue(cookieValue.defaultValue())
                    .bodyType(MediaType.ANY)
                    .build();
        } else if (annotation instanceof MatrixVariable) {
            MatrixVariable matrixVariable = (MatrixVariable) annotation;
            info = new RequestParameterInfo.Builder()
                    .name(matrixVariable.name())
                    .value(matrixVariable.value())
                    .require(matrixVariable.required())
                    .paramType(RequestParameterType.MATRIX)
                    .defaultValue(matrixVariable.defaultValue())
                    .bodyType(MediaType.ANY)
                    .build();
        } else if (annotation instanceof PathVariable) {
            PathVariable pathVariable = (PathVariable) annotation;
            info = new RequestParameterInfo.Builder()
                    .name(pathVariable.name())
                    .value(pathVariable.value())
                    .require(pathVariable.required())
                    .paramType(RequestParameterType.PATH)
                    .defaultValue("")
                    .bodyType(MediaType.ANY)
                    .build();
        } else if (annotation instanceof RequestAttribute) {
            RequestAttribute requestAttribute = (RequestAttribute) annotation;
            info = new RequestParameterInfo.Builder()
                    .name(requestAttribute.name())
                    .value(requestAttribute.value())
                    .require(requestAttribute.required())
                    .paramType(RequestParameterType.INNER)
                    .defaultValue("")
                    .bodyType(MediaType.ANY)
                    .build();
        } else if (annotation instanceof RequestBody) {
            RequestBody requestBody = (RequestBody) annotation;
            info = new RequestParameterInfo.Builder()
                    .name("")
                    .value("")
                    .require(requestBody.required())
                    .paramType(RequestParameterType.BODY)
                    .defaultValue("")
                    .bodyType(MediaType.ANY)
                    .build();
        } else if (annotation instanceof RequestHeader) {
            RequestHeader requestHeader = (RequestHeader) annotation;
            info = new RequestParameterInfo.Builder()
                    .name(requestHeader.name())
                    .value(requestHeader.value())
                    .require(requestHeader.required())
                    .paramType(RequestParameterType.BODY)
                    .defaultValue(requestHeader.defaultValue())
                    .bodyType(MediaType.ANY)
                    .build();
        } else if (annotation instanceof RequestParam) {
            RequestParam requestParam = (RequestParam) annotation;
            info = new RequestParameterInfo.Builder()
                    .name(requestParam.name())
                    .value(requestParam.value())
                    .require(requestParam.required())
                    .paramType(RequestParameterType.PARAM)
                    .defaultValue(requestParam.defaultValue())
                    .bodyType(MediaType.ANY)
                    .build();
        } else if (annotation instanceof SessionAttribute) {
            SessionAttribute sessionAttribute = (SessionAttribute) annotation;
            info = new RequestParameterInfo.Builder()
                    .name(sessionAttribute.name())
                    .value(sessionAttribute.value())
                    .require(sessionAttribute.required())
                    .paramType(RequestParameterType.SESSION)
                    .defaultValue("")
                    .bodyType(MediaType.ANY)
                    .build();
        }
        return info;
    }

    @Override
    public RequestParameterInfo parse(ExecutableArgument argument) {
        Annotation annotation = argument.getAnnotation(CookieValue.class);
        if (annotation != null) {
            CookieValue cookieValue = (CookieValue) annotation;
            return new RequestParameterInfo.Builder()
                    .name(cookieValue.name())
                    .value(cookieValue.value())
                    .require(cookieValue.required())
                    .paramType(RequestParameterType.COOKIE)
                    .defaultValue(cookieValue.defaultValue())
                    .bodyType(MediaType.ANY)
                    .build();
        }
        annotation = argument.getAnnotation(MatrixVariable.class);
        if (annotation != null) {
            MatrixVariable matrixVariable = (MatrixVariable) annotation;
            return new RequestParameterInfo.Builder()
                    .name(matrixVariable.name())
                    .value(matrixVariable.value())
                    .require(matrixVariable.required())
                    .paramType(RequestParameterType.MATRIX)
                    .defaultValue(matrixVariable.defaultValue())
                    .bodyType(MediaType.ANY)
                    .build();
        }
        annotation = argument.getAnnotation(PathVariable.class);
        if (annotation != null) {
            PathVariable pathVariable = (PathVariable) annotation;
            return new RequestParameterInfo.Builder()
                    .name(pathVariable.name())
                    .value(pathVariable.value())
                    .require(pathVariable.required())
                    .paramType(RequestParameterType.PATH)
                    .defaultValue("")
                    .bodyType(MediaType.ANY)
                    .build();
        }
        annotation = argument.getAnnotation(RequestAttribute.class);
        if (annotation != null) {
            RequestAttribute requestAttribute = (RequestAttribute) annotation;
            return new RequestParameterInfo.Builder()
                    .name(requestAttribute.name())
                    .value(requestAttribute.value())
                    .require(requestAttribute.required())
                    .paramType(RequestParameterType.INNER)
                    .defaultValue("")
                    .bodyType(MediaType.ANY)
                    .build();
        }
        annotation = argument.getAnnotation(RequestBody.class);
        if (annotation != null) {
            RequestBody requestBody = (RequestBody) annotation;
            return new RequestParameterInfo.Builder()
                    .name("")
                    .value("")
                    .require(requestBody.required())
                    .paramType(RequestParameterType.BODY)
                    .defaultValue("")
                    .bodyType(MediaType.ANY)
                    .build();
        }
        annotation = argument.getAnnotation(RequestHeader.class);
        if (annotation != null) {
            RequestHeader requestHeader = (RequestHeader) annotation;
            return new RequestParameterInfo.Builder()
                    .name(requestHeader.name())
                    .value(requestHeader.value())
                    .require(requestHeader.required())
                    .paramType(RequestParameterType.BODY)
                    .defaultValue(requestHeader.defaultValue())
                    .bodyType(MediaType.ANY)
                    .build();
        }
        annotation = argument.getAnnotation(RequestParam.class);
        if (annotation != null) {
            RequestParam requestParam = (RequestParam) annotation;
            return new RequestParameterInfo.Builder()
                    .name(requestParam.name())
                    .value(requestParam.value())
                    .require(requestParam.required())
                    .paramType(RequestParameterType.PARAM)
                    .defaultValue(requestParam.defaultValue())
                    .bodyType(MediaType.ANY)
                    .build();
        }
        annotation = argument.getAnnotation(SessionAttribute.class);
        if (annotation != null) {
            SessionAttribute sessionAttribute = (SessionAttribute) annotation;
            return new RequestParameterInfo.Builder()
                    .name(sessionAttribute.name())
                    .value(sessionAttribute.value())
                    .require(sessionAttribute.required())
                    .paramType(RequestParameterType.SESSION)
                    .defaultValue("")
                    .bodyType(MediaType.ANY)
                    .build();
        }
        return null;
    }

    @Override
    public RequestParameterInfo parse(Parameter parameter) {
        CookieValue cookieValue = parameter.getAnnotation(CookieValue.class);
        if (cookieValue != null) {
            return new RequestParameterInfo.Builder()
                    .name(cookieValue.name())
                    .value(cookieValue.value())
                    .require(cookieValue.required())
                    .paramType(RequestParameterType.COOKIE)
                    .defaultValue(cookieValue.defaultValue())
                    .bodyType(MediaType.ANY)
                    .build();
        }
        MatrixVariable matrixVariable = parameter.getAnnotation(MatrixVariable.class);
        if (matrixVariable != null) {
            return new RequestParameterInfo.Builder()
                    .name(matrixVariable.name())
                    .value(matrixVariable.value())
                    .require(matrixVariable.required())
                    .paramType(RequestParameterType.MATRIX)
                    .defaultValue(matrixVariable.defaultValue())
                    .bodyType(MediaType.ANY)
                    .build();
        }
        PathVariable pathVariable = parameter.getAnnotation(PathVariable.class);
        if (pathVariable != null) {
            return new RequestParameterInfo.Builder()
                    .name(pathVariable.name())
                    .value(pathVariable.value())
                    .require(pathVariable.required())
                    .paramType(RequestParameterType.PATH)
                    .defaultValue("")
                    .bodyType(MediaType.ANY)
                    .build();
        }
        RequestAttribute requestAttribute = parameter.getAnnotation(RequestAttribute.class);
        if (requestAttribute != null) {
            return new RequestParameterInfo.Builder()
                    .name(requestAttribute.name())
                    .value(requestAttribute.value())
                    .require(requestAttribute.required())
                    .paramType(RequestParameterType.INNER)
                    .defaultValue("")
                    .bodyType(MediaType.ANY)
                    .build();
        }
        RequestBody requestBody = parameter.getAnnotation(RequestBody.class);
        if (requestBody != null) {
            return new RequestParameterInfo.Builder()
                    .name("")
                    .value("")
                    .require(requestBody.required())
                    .paramType(RequestParameterType.BODY)
                    .defaultValue("")
                    .bodyType(MediaType.ANY)
                    .build();
        }
        RequestHeader requestHeader = parameter.getAnnotation(RequestHeader.class);
        if (requestHeader != null) {
            return new RequestParameterInfo.Builder()
                    .name(requestHeader.name())
                    .value(requestHeader.value())
                    .require(requestHeader.required())
                    .paramType(RequestParameterType.BODY)
                    .defaultValue(requestHeader.defaultValue())
                    .bodyType(MediaType.ANY)
                    .build();
        }
        RequestParam requestParam = parameter.getAnnotation(RequestParam.class);
        if (requestParam != null) {
            return new RequestParameterInfo.Builder()
                    .name(requestParam.name())
                    .value(requestParam.value())
                    .require(requestParam.required())
                    .paramType(RequestParameterType.PARAM)
                    .defaultValue(requestParam.defaultValue())
                    .bodyType(MediaType.ANY)
                    .build();
        }
        SessionAttribute sessionAttribute = parameter.getAnnotation(SessionAttribute.class);
        if (sessionAttribute != null) {
            return new RequestParameterInfo.Builder()
                    .name(sessionAttribute.name())
                    .value(sessionAttribute.value())
                    .require(sessionAttribute.required())
                    .paramType(RequestParameterType.SESSION)
                    .defaultValue("")
                    .bodyType(MediaType.ANY)
                    .build();
        }
        return null;
    }
}
