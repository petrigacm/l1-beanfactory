package sk.stopangin.spring.l1.springioc;

import org.springframework.stereotype.Component;
import sk.stopangin.spring.l1.Expense;
import sk.stopangin.spring.l1.ExpenseRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class ExpenseRepositoryImpl implements ExpenseRepository {

    @Override
    public List<Expense> getAllExpenses() {
        return Arrays.asList(
                new Expense("Shoes", 49.99),
                new Expense("Milk", 0.89),
                new Expense("Cinema tickets", 13.99)
        );
    }
}
