package sk.stopangin.spring.l1.springioc;

import org.springframework.stereotype.Component;
import sk.stopangin.spring.l1.ExpensePrinter;
import sk.stopangin.spring.l1.ExpenseService;

@Component
public class ConsoleExpensePrinter implements ExpensePrinter {

    private ExpenseService expenseService;

    public ConsoleExpensePrinter(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    public void printSumOfAllExpenses() {
        double sumOfAllExpenses = expenseService.getSumOfAllExpenses();

        System.out.println("Sum of all expenses: " + sumOfAllExpenses);
    }
}
