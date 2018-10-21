package sk.stopangin.spring.l1;

import java.text.MessageFormat;
import java.util.Objects;

public class DataServiceImpl implements DataService, BeanNameAware {
    private DataProvider dataProvider;
    private String beanName;

    @Override
    public void setBeanName(String beanName) {
        System.out.println("setting beanName for DataServiceImpl");
        this.beanName = beanName;
    }

    @Override
    public void processData() {
        System.out.println(MessageFormat.format("data: \"{0}\" sprocesovane", dataProvider.getData().getData()));
    }

    @Override
    public void setDataProvider(DataProvider dataProvider) {
        Objects.requireNonNull(dataProvider);
        this.dataProvider = dataProvider;
    }
}
