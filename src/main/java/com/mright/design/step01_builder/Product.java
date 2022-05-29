package com.mright.design.step01_builder;

/**
 * @author zhaochuanzhen
 * @date 2022/5/1 3:18 下午
 * @since 1.0
 */
public class Product {

    private String partA;
    private String partB;
    private String partC;
    public void setPartA(String partA) {
        this.partA = partA;
    }
    public void setPartB(String partB) {
        this.partB = partB;
    }
    public void setPartC(String partC) {
        this.partC = partC;
    }
    public void show() {
        //显示产品的特性
        System.out.println(partA);
        System.out.println(partB);
        System.out.println(partC);
    }
}
