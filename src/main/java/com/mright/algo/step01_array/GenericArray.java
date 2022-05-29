package com.mright.algo.step01_array;

/**
 * 泛型式通用的数组
 *
 * @author zhaochuanzhen
 * @date 2022/4/24 10:52 上午
 * @since 1.0
 */
public class GenericArray<T> {

    /**
     * 数据数组对象
     */
    private Object[] data;

    /**
     * 已存储的数据大小
     */
    private int size;

    /**
     * 指定容器大小的构造器
     *
     * @param capacity 初始大小
     */
    public GenericArray(int capacity) {
        this.data = new Object[capacity];
        this.size = 0;
    }

    /**
     * 默认构造器，默认生成大小为10的
     */
    public GenericArray() {
        this(10);
    }

    /**
     * 获取当前容器大小
     *
     * @return 容器大小
     */
    public int getCapacity() {
        return this.data.length;
    }

    /**
     * 获取当前元素个数
     *
     * @return 当前元素个数
     */
    public int getCount() {
        return this.size;
    }

    /**
     * 当前是否为空
     *
     * @return 当前容器是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    // 修改 index 位置的元素
    public void set(int index, T e) {
        checkIndex(index);
        data[index] = e;
    }

    // 获取对应 index 位置的元素
    public T get(int index) {
        checkIndex(index);
        return (T) data[index];
    }

    // 查看数组是否包含元素e
    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    // 获取对应元素的下标, 未找到，返回 -1
    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }


    // 在 index 位置，插入元素e, 时间复杂度 O(m+n)
    public void add(int index, T e) {
        checkIndexForAdd(index);
        // 如果当前元素个数等于数组容量，则将数组扩容为原来的2倍
        if (size == data.length) {
            resize(2 * data.length);
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    // 向数组头插入元素
    public void addFirst(T e) {
        add(0, e);
    }

    // 向数组尾插入元素
    public void addLast(T e) {
        add(size, e);
    }

    // 删除 index 位置的元素，并返回
    public T remove(int index) {
        checkIndex(index);

        T ret = (T) data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;

        // 缩容
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return ret;
    }

    // 删除第一个元素
    public T removeFirst() {
        return remove(0);
    }

    // 删除末尾元素
    public T removeLast() {
        return remove(size - 1);
    }

    // 从数组中删除指定元素
    public void removeElement(T e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array size = %d, capacity = %d \n", size, data.length));
        builder.append('[');
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString();
    }


    // 扩容方法，时间复杂度 O(n)
    private void resize(int capacity) {
        T[] newData = (T[]) new Object[capacity];

        for (int i = 0; i < size; i++) {
            newData[i] = (T) data[i];
        }
        data = newData;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed! Require index >=0 and index < size.");
        }
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("remove failed! Require index >=0 and index <= size.");
        }
    }

    public static void main(String[] args) {
        GenericArray<User> users = new GenericArray<User>(10);
        User user1 = new User("zs", 18);
        User user2 = new User("ls", 15);

        users.add(0, user1);
//        users.add(1, user2);
        System.out.println(users.toString());
    }
}

class User {

    private String name;

    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}