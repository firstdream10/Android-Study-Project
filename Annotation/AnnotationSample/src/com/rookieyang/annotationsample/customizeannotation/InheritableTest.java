package com.rookieyang.annotationsample.customizeannotation;

/**
 *
 * @author rookieyang
 * @date 17-10-19
 * @version 1.0.0
 */

public class InheritableTest extends Base {

    @Infos({@Info(name = "zhangsan"), @Info(name = "lisi")})
    private Person mPerson;

    public static void main(String[] args) {
        System.out.println(InheritableTest.class.isAnnotationPresent(Inheritable.class));
    }
}
