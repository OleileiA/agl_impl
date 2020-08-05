package com.company.Collection;
import java.io.Serializable;
import java.util.*;
import java.util.function.UnaryOperator;

/*
* 自实现ArrayList
* 首先需要注意到的细节，就是在父抽象类AbstractList中和ArrayList本身都实现了List接口，
* 这明显是一个重复性的行为，因为你只要其中任何一个实现了接口，那么都将在当前类要求实现对应的方法。
* 关于这种情况，有两种说法：
* 1. 提高代码的可读性。
* 2. 子类实现接口，方便java.lang.class直接获取接口数组，方便动态代理的相关操作。
* */
public class ArrList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable, Serializable {

    /* --------------------- AbstractCollection抽象类要求实现的方法  -------------------- */
    @Override
    public int size() {
        return 0;
    }

    /* --------------------- AbstractList抽象类要求实现的方法  -------------------- */
    @Override
    public E get(int index) {
        return null;
    }


    /* --------------------- List接口要求实现的方法  -------------------- */
    @Override
    public void replaceAll(UnaryOperator<E> operator) {

    }

    @Override
    public void sort(Comparator<? super E> c) {

    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }

    /* --------------------- RandomAccess接口要求的方法  -------------------- */
    /*
    * RandomAccess 接口是一个标志接口，不要求实现任何方法
    * 它只是表示当前实现类支持随机访问，那么当前的容器大概率是利用数组实现的。
    * */


    /* --------------------- Cloneable接口要求的方法  -------------------- */
    /*
    * Cloneable接口要求的方法是一个标志接口，不要求实现任何方法。
    * 但是你可以借由这个接口的名义去覆盖Object的clone方法。
    *  */


    /* --------------------- Serializable接口要求的方法 -------------------- */
    /*
    * Serializable是个标志接口，表示当前对象可序列化。
    *  */
}
