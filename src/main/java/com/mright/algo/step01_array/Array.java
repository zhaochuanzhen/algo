package com.mright.algo.step01_array;

import java.text.MessageFormat;

/**
 * int数组相关操作
 *
 * @author zhaochuanzhen
 * @date 2022/4/24 10:51 上午
 * @since 1.0
 */
public class Array {

    /**
     * 实际存储数据的数组，数组长度为n，里边存储了count个数据
     */
    private int[] data;

    /**
     * 数组长度
     */
    private int n;

    /**
     * 实际存放的数据个数 0 <= count <= n
     */
    private int count;

    /**
     * 构造器，定义初始值
     *
     * @param capacity 初始数组大小
     */
    public Array(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    /**
     * 数组的随机访问，如果请求下标不在范围内，那么默认返回-1
     *
     * @param index 访问下标
     * @return 实际数据
     */
    public int find(int index) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException(MessageFormat.format("数组大小为【】，index为【】，数组越界", this.count, index));
        }
        return this.data[index];
    }

    public boolean insert(int index, int value) {
        if (count == n) {
            throw new IndexOutOfBoundsException(MessageFormat.format("数组大小为【】，容量为【】，数组已满，无法再插入", this.count, this.n));
        }

        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException(MessageFormat.format("数组大小为【】，index为【】，数组越界", this.count, index));
        }

        System.arraycopy(data, index, data, index + 1, count - index);

        data[index] = value;
        count++;
        return true;
    }

    public boolean delete(int index) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException(MessageFormat.format("数组大小为【】，index为【】，数组越界", this.count, index));
        }

        for (int i = index + 1; i < count; i++) {
            data[i - 1] = data[i];
        }

        count--;
        return true;
    }

    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.println(data[i]);
        }
    }

    public static void main(String[] args) {
        Array array = new Array(10);
        array.insert(0, 1);
        array.insert(0, 2);
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(0, 5);
        array.insert(0, 6);
        array.insert(0, 7);
        array.insert(0, 8);
        array.insert(0, 9);
        array.insert(0, 10);
        array.printAll();
        System.out.println("=====");
        array.delete(3);
        array.printAll();
    }
}
