package sk.stopangin.spring.l1.naive;

import sk.stopangin.spring.l1.Expense;
import sk.stopangin.spring.l1.ExpenseRepository;
import sk.stopangin.spring.l1.ExpenseService;

import java.util.List;

public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseRepository expenseRepository;

    public ExpenseServiceImpl() {
        this.expenseRepository = new ExpenseRepositoryImpl();
    }

    @Override
    public double getSumOfAllExpenses() {
        return expenseRepository.getAllExpenses()
                .stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }
}
