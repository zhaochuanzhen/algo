package com.mright.design.step01_builder;

/**
 * @author zhaochuanzhen
 * @date 2022/5/1 3:19 下午
 * @since 1.0
 */
public class ConcreteBuilder extends Builder {
    @Override
    public void buildPartA() {
        product.setPartA("建造 PartA");
    }

    @Override
    public void buildPartB() {
        product.setPartB("建造 PartB");
    }

    @Override
    public void buildPartC() {
        product.setPartC("建造 PartC");
    }
}
