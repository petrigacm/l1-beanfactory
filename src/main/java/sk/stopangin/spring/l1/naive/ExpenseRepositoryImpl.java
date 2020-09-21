package sk.stopangin.spring.l1.naive;

import sk.stopangin.spring.l1.Expense;
import sk.stopangin.spring.l1.ExpenseRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ExpenseRepositoryImpl implements ExpenseRepository {

    public ExpenseRepositoryImpl() {
    }

    @Override
    public List<Expense> getAllExpenses() {
        return Arrays.asList(
                new Expense("Shoes", 49.99),
                new Expense("Milk", 0.89),
                new Expense("Cinema tickets", 13.99)
        );
    }
}
