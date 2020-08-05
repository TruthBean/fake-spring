package com.truthbean;

import org.springframework.stereotype.Repository;

/**
 * @author OceanAi/武汉魅瞳科技有限公司
 * @since 0.1.0
 * Created on 2020/7/9 18:41.
 */
@Repository
public class EchoRepository {

    public String echo() {
        return "echo";
    }
}
