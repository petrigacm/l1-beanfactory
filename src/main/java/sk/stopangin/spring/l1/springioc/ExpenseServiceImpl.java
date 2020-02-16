package sk.stopangin.spring.l1.springioc;

import org.springframework.stereotype.Component;
import sk.stopangin.spring.l1.Expense;
import sk.stopangin.spring.l1.ExpenseRepository;
import sk.stopangin.spring.l1.ExpenseService;

@Component
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseRepository expenseRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public Integer getSumOfAllExpenses() {
        return expenseRepository.getAllExpenses()
                .stream()
                .mapToInt(Expense::getAmount)
                .sum();
    }
}
