package com.rookieyang.annotations_compiler;

import com.google.auto.service.AutoService;
import com.rookieyang.annotations.HelloWorld;
import java.io.IOException;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.tools.JavaFileObject;

/**
 * Description：
 * Annotation Processor Tool
 * @author rookieyang
 * @date 17-10-22
 * @version 1.0.0
 */
//标识一个注解处理器
@AutoService(Processor.class)
public class AnnotationsCompiler extends AbstractProcessor {

    private Elements mElements;
    private Filer mFiler;
    private Messager mMessager;

    /*
     * 用于初始化 mElements、mFiler、mMessager
     */
    @Override
    public synchronized void init(ProcessingEnvironment processingEnvi) {
        super.init(processingEnvi);

        mElements = processingEnvi.getElementUtils();
        mFiler = processingEnvi.getFiler();
        mMessager = processingEnvi.getMessager();
    }

    /**
     * @param elements 实际上传入的都是 {@link #getSupportedAnnotationTypes()}
     * 中支持的并且被扫描到（使用过）注解元素，例如这里获取到的类元素就是 HelloWorld 注解
     * @param roundEnvi 一个注解处理工具框架，通过它可以查询到使用了注解的元素
     * @return 返回处理结果
     */
    @Override
    public boolean process(Set<? extends TypeElement> elements,
            RoundEnvironment roundEnvi) {
        String packageName;
        String className;
        //获取使用了 HelloWorld 注解的元素
        for (Element element : roundEnvi.getElementsAnnotatedWith(HelloWorld.class)) {
            //通过 Elements 去获取包名
            packageName = mElements.getPackageOf(element).toString();
            //HelloWorld 注解只能被用在成员变量，所以通过获取外层元素就可以获取到使用注解的元素所在的类
            className = element.getEnclosingElement().getSimpleName() + "_HelloWorld";
            try {
                //通过 Filer 指定的路径下创建一个 java 源文件，然后写入对应的代码
                JavaFileObject javaFileObject = mFiler.createSourceFile(
                        packageName + "." + className);
                Writer writer = javaFileObject.openWriter();
                writer.write("package " + packageName + ";\n\n");
                writer.write("import android.content.Context;\n");
                writer.write("import android.widget.Toast;\n\n");
                writer.write("public class " + className + " {\n\n");
                writer.write("\tpublic static void show(Context context) {\n");
                writer.write("\t\tToast.makeText(context,"
                        + " \"HelloWorld\", Toast.LENGTH_SHORT).show();\n");
                writer.write("\t}\n");
                writer.write("\n}");
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    /**
     * @return 返回注解处理器支持的 Java 版本
     */
    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    /**
     * @return 返回注解处理器支持的注解集合
     */
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> annotationTypes = new LinkedHashSet<>();
        for (Class<? extends Annotation> annotation : getSupportedAnnotations()) {
            annotationTypes.add(annotation.getCanonicalName());
        }
        return annotationTypes;
    }


    /**
     * @return 返回支持的注解类型集合
     */
    private Set<Class<? extends Annotation>> getSupportedAnnotations() {
        Set<Class<? extends Annotation>> annotationSet = new LinkedHashSet<>();
        annotationSet.add(HelloWorld.class);

        return annotationSet;
    }
}
