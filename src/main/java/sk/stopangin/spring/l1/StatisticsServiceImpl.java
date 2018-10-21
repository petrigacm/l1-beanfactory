package sk.stopangin.spring.l1;

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
}
