package com.scaler.lld.reflection;

import com.scaler.lld.rescaler.Student;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionExample {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        Student student = new Student(1L, "Tantia Tope", "t@t.com", null, "Jhansi");

        Class<?> clazz = student.getClass();
        System.out.println("Simple name: " + clazz.getSimpleName());
        System.out.println("Name: " + clazz.getName());
        System.out.println("Package name: " + clazz.getPackageName());
        System.out.println();

        Class<?> studentClass = Class.forName("com.scaler.lld.rescaler.Student");
        Field[] fields = studentClass.getDeclaredFields();

        for (Field field : fields) {
            System.out.println("Field name: " + field.getName());
            System.out.println("Field type: " + field.getType());
            System.out.println();
        }

        Method[] methods = studentClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("Method name: " + method.getName());
            System.out.println("Method return type: " + method.getReturnType());
            System.out.println();
        }

        Annotation[] annotations = studentClass.getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("Annotation name: " + annotation.annotationType());
        }

    }
}
