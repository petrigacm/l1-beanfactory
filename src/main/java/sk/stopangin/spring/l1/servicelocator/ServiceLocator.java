package sk.stopangin.spring.l1.servicelocator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServiceLocator {

    private ServiceLocator() {
    }

    private final Map<Class<?>, Object> registry = new ConcurrentHashMap<>();

    public <T> T getBean(Class<T> beanClass) {
        return beanClass.cast(registry.get(beanClass));
    }

    public <T> void putBean(Class<T> registeringClass, T o) {
        registry.put(registeringClass, o);
    }

    private static class Holder {
        private static ServiceLocator INSTANCE = new ServiceLocator();
    }

    public static ServiceLocator getInstance() {
        return Holder.INSTANCE;
    }

}
