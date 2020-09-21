package sk.stopangin.spring.l1.dependencyinjection;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {
    private Map<String, Object> context = new HashMap<>();

    public BeanFactory(String contextDefinitionFile) throws Exception {
        Properties contextDefinition = loadContextDefinition(contextDefinitionFile);

        initializeContext(contextDefinition);
    }

    private void initializeContext(Properties contextDefinition) throws Exception {
        for (Object propertyKey : contextDefinition.keySet()) {
            String beanName = propertyKey.toString();
            initializeContextWithBean(beanName, contextDefinition);
        }
    }

    private void initializeContextWithBean(String beanName, Properties contextDefinition) throws Exception {
        if (context.get(beanName) != null) {
            return;
        }

        Class<?> beanClass = Class.forName(String.valueOf(contextDefinition.get(beanName)));
        Constructor<?> constructor = beanClass.getConstructors()[0];

        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Object[] constructorParameters = new Object[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> parameterType = parameterTypes[i];
            initializeContextWithBean(parameterType.getSimpleName(), contextDefinition);

            Object beanInstance = context.get(parameterType.getSimpleName());
            constructorParameters[i] = beanInstance;
        }

        Object beanInstance = constructor.newInstance(constructorParameters);

        context.put(beanName, beanInstance);
}

    private Properties loadContextDefinition(String beanDefinitionFile) throws IOException {
        Properties contextDefinition = new Properties();
        contextDefinition.load(Runner.class.getResourceAsStream(beanDefinitionFile));

        return contextDefinition;
    }

    public <T> T getBean(String name, Class<T> clazz) {
        for (Map.Entry<String, Object> entry : context.entrySet()) {
            if (entry.getKey().equals(name) && clazz.isAssignableFrom(entry.getValue().getClass())) {
                return clazz.cast(entry.getValue());
            }
        }

        throw new RuntimeException("No bean of type " + clazz.getName() + " with name " + name + " found!");
    }

    @Override
    public String toString() {
        return "BeanFactory{" +
                "context=" + getContextInfo() +
                '}';
    }

    private String getContextInfo() {
        StringBuilder sb = new StringBuilder();

        for (String key : context.keySet()) {
            sb.append("[").append(key).append("]").append(context.get(key).getClass());
        }

        return sb.toString();
    }
}
