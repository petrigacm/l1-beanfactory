package sk.stopangin.spring.l1.servicelocator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DefaultServiceLocator {

    private final Map<Class<?>, Object> register = new ConcurrentHashMap<>();

    public <T> T getBean(Class<T> beanClass) {
        return beanClass.cast(register.get(beanClass));
    }

    public void putBean(Class<?> registeringClass, Object o) {
        register.put(registeringClass, o);
    }

    private static class Holder {
        private static DefaultServiceLocator INSTANCE = new DefaultServiceLocator();
    }

    public static DefaultServiceLocator getInstance() {
        return Holder.INSTANCE;
    }

}
