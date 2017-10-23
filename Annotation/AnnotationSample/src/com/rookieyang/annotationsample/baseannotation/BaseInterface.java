package com.rookieyang.annotationsample.baseannotation;

/**
 * @author rookieyang
 * @version 1.0.0
 * @date 17-10-19
 */

@FunctionalInterface
public interface BaseInterface {

    /**
     * 计算 x + y 的结果
     * @param x 第一个加数
     * @param y 第二个加数
     * @return 相加之和
     */
    int add(int x, int y);
}
