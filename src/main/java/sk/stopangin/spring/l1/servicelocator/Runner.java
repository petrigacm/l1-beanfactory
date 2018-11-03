package sk.stopangin.spring.l1.servicelocator;

import sk.stopangin.spring.l1.DataService;
import sk.stopangin.spring.l1.DataServiceImpl;
import sk.stopangin.spring.l1.StatisticsService;
import sk.stopangin.spring.l1.StatisticsServiceImpl;

public class Runner {
    public static void main(String[] args) {
        DefaultServiceLocator serviceLocator = DefaultServiceLocator.getInstance();
        StatisticsService statisticsService = new StatisticsServiceImpl();
        DataService dataService = new DataServiceImpl();
        serviceLocator.putBean(DataService.class, dataService);
        serviceLocator.putBean(StatisticsService.class, statisticsService);
        StatisticFacadeImpl statisticFacade = new StatisticFacadeImpl();
        serviceLocator.putBean(StatisticFacadeImpl.class, statisticFacade);

        StatisticFacadeImpl bean = serviceLocator.getBean(StatisticFacadeImpl.class);
        System.out.println(bean.computeStatistics());

    }
}
