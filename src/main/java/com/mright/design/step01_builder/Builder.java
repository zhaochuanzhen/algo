package com.mright.design.step01_builder;

/**
 * @author zhaochuanzhen
 * @date 2022/5/1 3:18 下午
 * @since 1.0
 */
public abstract class Builder {
    //创建产品对象
    protected Product product = new Product();

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract void buildPartC();

    //返回产品对象
    public Product getResult() {
        return product;
    }
}
