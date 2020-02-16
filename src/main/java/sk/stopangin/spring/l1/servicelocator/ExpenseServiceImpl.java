package sk.stopangin.spring.l1.servicelocator;

import sk.stopangin.spring.l1.Expense;
import sk.stopangin.spring.l1.ExpenseRepository;
import sk.stopangin.spring.l1.ExpenseService;

public class ExpenseServiceImpl implements ExpenseService {

    public ExpenseServiceImpl() {
    }

    @Override
    public Integer getSumOfAllExpenses() {
        ExpenseRepository expenseRepository = ServiceLocator.getInstance().getBean(ExpenseRepository.class);

        return expenseRepository.getAllExpenses()
                .stream()
                .mapToInt(Expense::getAmount)
                .sum();
    }
}
