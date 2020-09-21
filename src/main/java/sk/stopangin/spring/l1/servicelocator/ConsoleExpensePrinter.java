package sk.stopangin.spring.l1.servicelocator;

import sk.stopangin.spring.l1.ExpensePrinter;
import sk.stopangin.spring.l1.ExpenseService;

public class ConsoleExpensePrinter implements ExpensePrinter {

    public ConsoleExpensePrinter() {
    }

    public void printSumOfAllExpenses() {
        ExpenseService expenseService = ServiceLocator.getInstance().getBean(ExpenseService.class);

        double sumOfAllExpenses = expenseService.getSumOfAllExpenses();

        System.out.println("Sum of all expenses: " + sumOfAllExpenses);
    }
}
