package com.rookieyang.annotation.customizeannotation;

/**
 *
 * @author rookieyang
 * @date 17-10-19
 * @version 1.0.0
 */

public class InheritableTest extends Base {

    public static void main(String[] args) {
        System.out.println(InheritableTest.class.isAnnotationPresent(Inheritable.class));
    }
}
