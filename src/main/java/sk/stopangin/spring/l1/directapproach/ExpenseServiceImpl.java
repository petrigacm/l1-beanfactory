package sk.stopangin.spring.l1.directapproach;

import sk.stopangin.spring.l1.Expense;
import sk.stopangin.spring.l1.ExpenseRepository;
import sk.stopangin.spring.l1.ExpenseService;

public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseRepository expenseRepository;

    public ExpenseServiceImpl() {
        this.expenseRepository = new ExpenseRepositoryImpl();
    }

    @Override
    public Integer getSumOfAllExpenses() {
        return expenseRepository.getAllExpenses()
                .stream()
                .mapToInt(Expense::getAmount)
                .sum();
    }
}
