package com.rookieyang.annotationsample.baseannotation;

import com.rookieyang.annotationsample.customizeannotation.DocumentedTest;

import java.util.List;

/**
 * Description:
 * 基本 Annotation 的使用
 * @author rookieyang
 * @date 17-10-19
 * @version 1.0.0
 */

public class BaseAnnotationUse extends FatherClass{

    @Deprecated
    private int mDeprecatedMember;

    @Override
    public void overridedMethod() {
        super.overridedMethod();
    }

    @DocumentedTest
    @SuppressWarnings("deprecation")
    public void useDeprecatedMethod() {
        deprecatedMethod();
    }


    @SafeVarargs
    public static void faultyMethod(List<String>... listStrArray) {
        List[] listArray = listStrArray;
    }
}
