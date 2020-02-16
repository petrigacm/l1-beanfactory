package sk.stopangin.spring.l1.dependencyinjection;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {
    private Map<String, Object> context = new HashMap<>();

    public BeanFactory() throws Exception {
        Properties contextDefinition = new Properties();
        contextDefinition.load(Runner.class.getResourceAsStream("/beans.properties"));

        for (Object propertyKey : contextDefinition.keySet()) {
            String beanName = propertyKey.toString();
            fillContextForBeanName(beanName, contextDefinition);
        }
    }

    private void fillContextForBeanName(String beanName, Properties contextDefinition) throws Exception {
        Object beanInstance;

        if (context.get(beanName) != null) {
            beanInstance = context.get(beanName);
            System.out.println(beanName + " already found in context, skipping.");
        } else {
            Class<?> beanClass = Class.forName(String.valueOf(contextDefinition.get(beanName)));
            Constructor<?> constructor = beanClass.getConstructors()[0];

            Class<?>[] constructorParameterTypes = constructor.getParameterTypes();

            Object[] parameters = new Object[constructorParameterTypes.length];

            for (int i = 0; i < constructorParameterTypes.length; i++) {
                Class<?> constructorParameterType = constructorParameterTypes[i];
                String beanNameBasedOnParameterName = constructorParameterType.getSimpleName();

                if (hasDefinition(contextDefinition, beanNameBasedOnParameterName)) {
                    fillContextForBeanName(beanNameBasedOnParameterName, contextDefinition);
                    parameters[i] = context.get(beanNameBasedOnParameterName);
                } else {
                    throw new RuntimeException("Cannot instantiate " + beanName + ". It has dependency on " + beanNameBasedOnParameterName + ", which is not defined in bean.properties file.");
                }
            }

            beanInstance = constructor.newInstance(parameters);

            System.out.println("Inserting " + beanName + " into context.");
            context.put(beanName, beanInstance);
            callAfterCreateListeners(beanInstance, beanName);
        }
        callAfterPropertySetListener(beanInstance);
    }

    private void callAfterCreateListeners(Object beanInstance, String beanName) {
        if (beanInstance instanceof BeanNameAware) {
            ((BeanNameAware) beanInstance).setBeanName(beanName);
        }
    }

    private void callAfterPropertySetListener(Object beanInstance) {
        if (beanInstance instanceof AfterPropertiesSetAware) {
            ((AfterPropertiesSetAware) beanInstance).afterPropertiesSet();
        }
    }

    private boolean hasDefinition(Properties contextDefinition, String beanName) {
        return contextDefinition.get(beanName) != null;
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
