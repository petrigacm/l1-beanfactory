package sk.stopangin.spring.l1;

import java.util.Random;

public class StatisticsServiceImpl implements StatisticsService, AfterPropertiesSetAware {
    private DataService dataService;

    @Override
    public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("After properties set aware called on StatisticsServiceImpl.");
    }

    @Override
    public Integer getStatisticData() {
        return new Random(1000).nextInt();
    }
}
