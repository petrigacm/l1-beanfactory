package sk.stopangin.spring.l1;

public class Runner {
    public static void main(String[] args) throws Exception {
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.init();
        System.out.println(beanFactory.toString());
    }
}
