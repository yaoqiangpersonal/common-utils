package com.yq.blueray.taobao.dao.sqlserver;

/**
 * @Auther: yq
 * @Date: 2018-09-13 17:05
 * @Description:
 */
public class Two<T,E> {
    private final T t;
    private final E e;

    Two(T t,E e){
        this.t = t;
        this.e = e;
    }

    @Override
    public String toString() {
        return t.getClass() + "     " + e.getClass();
    }

    public static void main(String[] args) {
        Two<Integer,String> two = new Two<>(1,"123");
        System.out.println(two);
    }
}
