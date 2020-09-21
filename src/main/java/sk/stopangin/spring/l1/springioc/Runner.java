package sk.stopangin.spring.l1.springioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Runner {
    public static void main(String[] args) {
        BeanFactory beanFactory = new AnnotationConfigApplicationContext(Runner.class);

        beanFactory.getBean(ConsoleExpensePrinter.class).printSumOfAllExpenses();
    }
}
