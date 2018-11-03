package sk.stopangin.spring.l1.servicelocator;

import sk.stopangin.spring.l1.DataService;
import sk.stopangin.spring.l1.StatisticsService;

public class StatisticFacadeImpl {

    public Integer computeStatistics() {
        DataService dataService = DefaultServiceLocator.getInstance().getBean(DataService.class);
        StatisticsService statisticsService = DefaultServiceLocator.getInstance().getBean(StatisticsService.class);
        statisticsService.setDataService(dataService);
        return statisticsService.getStatisticData();
    }
}
