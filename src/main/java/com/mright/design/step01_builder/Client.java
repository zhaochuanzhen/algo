package com.mright.design.step01_builder;

/**
 * @author zhaochuanzhen
 * @date 2022/5/1 3:20 下午
 * @since 1.0
 */
public class Client {

    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Product product = director.construct();
        product.show();
    }
}
