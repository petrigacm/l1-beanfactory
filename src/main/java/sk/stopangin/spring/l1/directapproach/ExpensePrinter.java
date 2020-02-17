package sk.stopangin.spring.l1.directapproach;

import sk.stopangin.spring.l1.ExpenseService;

public class ExpensePrinter {

    private ExpenseService expenseService;

    public ExpensePrinter() {
        this.expenseService = new ExpenseServiceImpl();
    }

    public void printSumOfAllExpenses() {
        Integer sumOfAllExpenses = expenseService.getSumOfAllExpenses();

        System.out.println("Sum of all expenses: " + sumOfAllExpenses);
    }
}
