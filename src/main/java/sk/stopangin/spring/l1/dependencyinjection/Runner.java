package sk.stopangin.spring.l1.dependencyinjection;

public class Runner {
    public static void main(String[] args) throws Exception {
        BeanFactory beanFactory = new BeanFactory();

        System.out.println(beanFactory.toString());
    }
}
