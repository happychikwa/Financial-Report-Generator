package nerd.Financial.Report.Generator.Services;

import nerd.Financial.Report.Generator.Models.ExpenseModel;
import nerd.Financial.Report.Generator.Repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import nerd.Financial.Report.Generator.Models.ResponsePojo;
import java.util.List;

@Service
public class ExpenseServices {
    @Autowired
    @Qualifier("expenserepository")
    ExpenseRepository expenseRepository;
    public ResponseEntity<?> getAllExpenses(){
        List<ExpenseModel> allExpenses = expenseRepository.findAll();
        if(allExpenses.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponsePojo(HttpStatus.NOT_FOUND.value(),"No Content"));
        return ResponseEntity.ok(new ResponsePojo(HttpStatus.OK.value(), allExpenses));
    }
    public ResponseEntity<?> getExpenseById(Long id){
        ExpenseModel expense = expenseRepository.findById(id).get();
        if(expenseRepository.findById(id).isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponsePojo(HttpStatus.NO_CONTENT.value(), "No Content Found."));
        return ResponseEntity.ok(new ResponsePojo(HttpStatus.OK.value(), expense ));
    }
    public ResponseEntity<ResponsePojo> recordExpense(ExpenseModel expense){
        if(expenseRepository.findById(expense.getExpenseId()).isPresent()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponsePojo(HttpStatus.BAD_REQUEST.value(), "Record ID Exists"));
        expenseRepository.save(expense);
        return ResponseEntity.ok(new ResponsePojo(HttpStatus.OK.value(), "Expense Recorded."));
    }
    public ResponseEntity<ResponsePojo> editExpense(ExpenseModel expense){
        long expenseId = expense.getExpenseId();
        String date = expense.getDate();
        String description = expense.getDescription();
        float amount = expense.getAmount();
        boolean directExpense = expense.getDirectExpense();

        if(expenseRepository.findById(expenseId).isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).body(new ResponsePojo(HttpStatus.NO_CONTENT.value(), "Record does not Exist."));
        }
        ExpenseModel expenseRecord = expenseRepository.findById(expenseId).get();
        expenseRecord.setDate(date);
        expenseRecord.setDescription(description);
        expenseRecord.setAmount(amount);
        expenseRecord.setDirectExpense(directExpense);
        expenseRepository.save(expenseRecord);
        return ResponseEntity.ok(new ResponsePojo(HttpStatus.OK.value(), "Expense Saved."));
    }
    public ResponseEntity<ResponsePojo> deleteExpense(long id){
        if(expenseRepository.findById(id).isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).body(new ResponsePojo(HttpStatus.NO_CONTENT.value(), "Expense does not Exist."));
        }
        expenseRepository.deleteById(id);
        return ResponseEntity.ok(new ResponsePojo(HttpStatus.OK.value(), "Expense deleted."));
    }
}
