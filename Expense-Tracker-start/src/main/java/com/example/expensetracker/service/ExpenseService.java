package com.example.expensetracker.service;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    // Get all expenses
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    // Save or update an expense
    public void saveExpense(Expense expense) {
        expenseRepository.save(expense);
    }

    // Get expense by ID
    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id).orElse(null);
    }

    // Delete expense by ID
    public void deleteExpenseById(Long id) {
        expenseRepository.deleteById(id);
    }

    // Calculate total amount of all expenses
    public BigDecimal getTotalAmount() {
        List<Expense> expenses = expenseRepository.findAll();
        BigDecimal total = BigDecimal.ZERO;

        for (Expense expense : expenses) {
            if (expense.getAmount() != null) {
                total = total.add(expense.getAmount());
            }
        }

        return total;
    }
}
