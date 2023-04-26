package nerd.Financial.Report.Generator.Controller;

import nerd.Financial.Report.Generator.Models.ExpenseModel;
import nerd.Financial.Report.Generator.Repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServices {
    @Autowired
    ExpenseRepository expenseRepository;
    public List<ExpenseModel> getAllExpenses(){
        List<ExpenseModel> allExpenses = expenseRepository.findAll();
        if(allExpenses.isEmpty()) return allExpenses;
        return allExpenses;
    }
    public ExpenseModel getExpenseById(Long id){
        if(expenseRepository.findById(id).isEmpty()) return null;
        return expenseRepository.findById(id).get();
    }
    public String recordExpense(ExpenseModel expense){
        expenseRepository.save(expense);
        return "Expense Recorded.";
    }
    public String editExpense(ExpenseModel expense){
        long expenseId = expense.getExpenseId();
        String date = expense.getDate();
        String description = expense.getDescription();
        float amount = expense.getAmount();
        boolean directExpense = expense.getDirectExpense();

        if(expenseRepository.findById(expenseId).isEmpty()){
            return "Expense does not exist.";
        }
        ExpenseModel expenseRecord = expenseRepository.findById(expenseId).get();
        expenseRecord.setDate(date);
        expenseRecord.setDescription(description);
        expenseRecord.setAmount(amount);
        expenseRecord.setDirectExpense(directExpense);
        expenseRepository.save(expenseRecord);
        return "Expense Edited";
    }
    public String deleteExpense(long id){
        if(expenseRepository.findById(id).isEmpty()){
            return "Expense does not exist.";
        }
        expenseRepository.deleteById(id);
        return "Record Deleted.";
    }
}
