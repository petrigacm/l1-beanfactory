package sk.stopangin.spring.l1.naive;

import sk.stopangin.spring.l1.ExpensePrinter;
import sk.stopangin.spring.l1.ExpenseService;

public class ConsoleExpensePrinter implements ExpensePrinter {

    private ExpenseService expenseService;

    public ConsoleExpensePrinter() {
        this.expenseService = new ExpenseServiceImpl();
    }

    public void printSumOfAllExpenses() {
        double sumOfAllExpenses = expenseService.getSumOfAllExpenses();

        System.out.println("Sum of all expenses: " + sumOfAllExpenses);
    }
}
