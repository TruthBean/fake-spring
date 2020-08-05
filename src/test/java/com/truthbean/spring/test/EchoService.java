package com.truthbean.spring.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author OceanAi/武汉魅瞳科技有限公司
 * @since 0.1.0
 * Created on 2020/7/9 18:38.
 */
@Service
public class EchoService {

    @Autowired
    private EchoRepository repository;

    public String echo() {
        return repository.echo();
    }
}
