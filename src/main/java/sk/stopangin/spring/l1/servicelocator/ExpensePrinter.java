package sk.stopangin.spring.l1.servicelocator;

import sk.stopangin.spring.l1.ExpenseService;

public class ExpensePrinter {

    public ExpensePrinter() {
    }

    public void printSumOfAllExpenses() {
        ExpenseService expenseService = ServiceLocator.getInstance().getBean(ExpenseService.class);

        Integer sumOfAllExpenses = expenseService.getSumOfAllExpenses();

        System.out.println("Sum of all expenses: " + sumOfAllExpenses);
    }
}
