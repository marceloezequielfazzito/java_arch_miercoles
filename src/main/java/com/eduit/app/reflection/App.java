package com.eduit.app.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class App {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        Car ford = new Car("ford","focus",2018);
        logState(ford);

        String test = "test";
        logState(test);

        Person juan = new Person("juan","peres" ,  50);

        logState(juan);

    }


    public static void logState(Object o) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        //Car
        System.out.println(" calling toString ");
        Class<?> clazz = o.getClass();
        Method toString = clazz.getMethod("toString");
        System.out.println(toString.invoke(o));

        Method[] methods = clazz.getMethods();
        StringBuilder stringBuilder = new StringBuilder();


        System.out.println(" calling getter methods ");

        for (Method method:methods) {
            String name = method.getName();
            int parameterCount = method.getParameterCount();
            if(name.startsWith("get") && parameterCount == 0){
                System.out.println( "calling method " + name );
                Object returnValue = method.invoke(o);
                stringBuilder.append(name.replace("get" , ""));
                stringBuilder.append("=");
                stringBuilder.append(returnValue.toString());
                stringBuilder.append(",");
            }
        }

        System.out.println(" state gathered ");

        System.out.println( " Object class  " + clazz.getName() + " state " + stringBuilder.toString());


    }



}
