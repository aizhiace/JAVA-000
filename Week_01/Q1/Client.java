import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author caizh
 * @date 2020/10/17
 */
public class Client {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        MyClassLoader mcl = new MyClassLoader();
        Class<?> c1 = Class.forName("Hello", true, mcl);
        Method hello = c1.getDeclaredMethod("hello");
        hello.invoke(c1.newInstance());
    }

}
