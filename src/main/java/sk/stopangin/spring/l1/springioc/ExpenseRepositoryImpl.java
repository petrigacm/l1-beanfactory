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
        Random random = new Random(1324);

        return Arrays.asList(
                new Expense(random.nextInt(1000)),
                new Expense(random.nextInt(1000)),
                new Expense(random.nextInt(1000))
        );
    }
}
