package reflect.demo;

import model.Person;
import model.PersonConfig;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * Created by junhan on 2016/9/10.
 */
public class ClassDemo {

    /**
     * 类的方法
     */
    public static void getMethod(Class<?> clazz) {
        //私有方法需要特殊处理
        Method[] methods = new Person<PersonConfig>().getClass().getMethods();
        for (Method m : methods) {
            System.out.println("person's name:" + m.getName());
            System.out.println("person's declaringClass:" + m.getDeclaringClass());
            System.out.println("person's GenericParameterTypes:" + m.getGenericParameterTypes());
            System.out.println("person's getGenericReturnType:" + m.getGenericReturnType());
            System.out.println("person's getModifiers:" + m.getModifiers());

            System.out.println("-----------------------------------------");
        }
        //方法参数

        //方法返回

        //方法调用
        try {
            Method getAddress = clazz.getMethod("setAddress", String.class);
            //如果方法是static可以使用null调用
//            getAddress.invoke(null, "hangzhou");
            //第一个变量 调用的对象，第二个变量方法参数值
            Object o = clazz.newInstance();
            Object hangzhou = getAddress.invoke(o, "hangzhou");


            //获取私有方法
            Method privateMethod = clazz.getMethod("privateMethod");
            privateMethod.setAccessible(true);
            privateMethod.invoke(o, null);


        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }

    /**
     * 得到class对象的方法
     */
    public static Class getClassObject() {
        Class clazz0 = Person.class;
        Class clazz1 = new Person<PersonConfig>().getClass();
        try {
            Class clazz2 = Class.forName("model.Person");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
        return clazz0;
    }

    /**
     * 类名和类的全限名
     *
     * @param clazz
     */
    public static void getClassName(Class<?> clazz) {
        System.out.println("类的全限名" + clazz.getName());
        System.out.println("类名" + clazz.getSimpleName());
    }

    /**
     * 修饰符
     *
     * @param clazz
     */
    public static void getModified(Class<?> clazz) {
        int modifiers = clazz.getModifiers();
        System.out.println(modifiers);
        //使用Modify类,用来判断修饰符是什么类型
        Modifier.isPublic(modifiers);
        Modifier.isStatic(modifiers);
    }

    /**
     * 包信息
     *
     * @param clazz
     */
    public static void getPackage(Class<?> clazz) {
        Package aPackage = clazz.getPackage();
        System.out.println(aPackage.getName());
        System.out.println(aPackage.getSpecificationVersion());
    }

    /**
     * 得到父类
     *
     * @param clazz
     */
    public static void getSupperClass(Class<?> clazz) {
        Class<?> superclass = clazz.getSuperclass();
        System.out.println(superclass.getName());
    }

    /**
     * 类实现的接口信息
     *
     * @param clazz
     */
    public static void getInterfaces(Class<?> clazz) {
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class cl : interfaces) {
            System.out.println(cl.getName());
        }
    }

    /**
     * 类注解
     *
     * @param clazz
     */
    public static void getAnontation(Class<?> clazz) {
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation.toString());
        }
    }

    /**
     * 类的构造器
     *
     * @param clazz
     */
    public static void getConstruct(Class<?> clazz) {
        //私有构造器需要特殊处理
        try {
            //变量为可变参数
            Constructor<?> constructor = clazz.getConstructor();
            clazz.getDeclaredConstructor();
            //使用构造器实例化一个类
            //获取构造器参数类型
            constructor.getParameterTypes();
        } catch (NoSuchMethodException e) {
            System.out.println(e);
        }
    }

    /**
     * 类的变量
     *
     * @param clazz
     */
    public static void getFields(Class<?> clazz) {
        //只能获得public变量
        Field[] fields = clazz.getFields();
        //获取filed的name
        //获取filed的修饰符
        //获取filed的类型
        //获取filed使用get set方法
    }



    public static void main (String[] args) {
//        ClassDemo.getMethod();
        Class clazz = ClassDemo.getClassObject();
//        getClassName(clazz);
//        getModified(clazz);
        getPackage(clazz);

    }


}
