package sk.stopangin.spring.l1.dependencyinjection;

import sk.stopangin.spring.l1.ExpenseService;

public class ExpensePrinter {

    private ExpenseService expenseService;

    public ExpensePrinter(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    public void printSumOfAllExpenses() {
        Integer sumOfAllExpenses = expenseService.getSumOfAllExpenses();

        System.out.println("Sum of all expenses: " + sumOfAllExpenses);
    }
}
