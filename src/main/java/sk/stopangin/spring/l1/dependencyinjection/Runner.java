package sk.stopangin.spring.l1.dependencyinjection;

import sk.stopangin.spring.l1.ExpensePrinter;

public class Runner {
    public static void main(String[] args) throws Exception {
        BeanFactory beanFactory = new BeanFactory("/beans.properties");

        ExpensePrinter expensePrinter = beanFactory.getBean("ExpensePrinter", ExpensePrinter.class);

        expensePrinter.printSumOfAllExpenses();
    }
}
