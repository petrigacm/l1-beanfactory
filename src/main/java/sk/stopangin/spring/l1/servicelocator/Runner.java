package sk.stopangin.spring.l1.servicelocator;

import sk.stopangin.spring.l1.ExpensePrinter;
import sk.stopangin.spring.l1.ExpenseRepository;
import sk.stopangin.spring.l1.ExpenseService;

public class Runner {
    public static void main(String[] args) {
        ServiceLocator serviceLocator = ServiceLocator.getInstance();

        serviceLocator.putBean(ExpenseRepository.class, new ExpenseRepositoryImpl());
        serviceLocator.putBean(ExpenseService.class, new ExpenseServiceImpl());
        serviceLocator.putBean(ExpensePrinter.class, new ConsoleExpensePrinter());

        ExpensePrinter expensePrinter = serviceLocator.getBean(ExpensePrinter.class);

        expensePrinter.printSumOfAllExpenses();
    }
}
