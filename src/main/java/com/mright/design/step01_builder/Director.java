package com.mright.design.step01_builder;

/**
 * @author zhaochuanzhen
 * @date 2022/5/1 3:20 下午
 * @since 1.0
 */
public class Director {

    private Builder builder;
    public Director(Builder builder) {
        this.builder = builder;
    }
    //产品构建与组装方法
    public Product construct() {
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }
}
