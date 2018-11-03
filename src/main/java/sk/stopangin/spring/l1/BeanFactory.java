package sk.stopangin.spring.l1;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {
    private Map<String, Object> context = new HashMap<>();



    void init() throws Exception {
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
            beanInstance = Class.forName(String.valueOf(contextDefinition.get(beanName))).newInstance();
            System.out.println("inserting " + beanName + " into context.");
            context.put(beanName, beanInstance);
            callAfterCreateListeners(beanInstance, beanName);
        }
        Field[] declaredFields = beanInstance.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            String beanNameBasedOnFieldName = declaredField.getName();
            if (isBeanNameDefinedInContext(contextDefinition, beanNameBasedOnFieldName)) {
                declaredField.setAccessible(true);
                fillContextForBeanName(beanNameBasedOnFieldName, contextDefinition);
                declaredField.set(beanInstance, context.get(beanNameBasedOnFieldName));
            }
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

    private boolean isBeanNameDefinedInContext(Properties contextDefinition, String beanName) {
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
            sb.append("[" + key + "]" + context.get(key).getClass());
        }
        return sb.toString();
    }


}
