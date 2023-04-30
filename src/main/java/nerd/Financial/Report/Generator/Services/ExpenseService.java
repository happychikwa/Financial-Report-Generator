package nerd.Financial.Report.Generator.service;

import org.springframework.stereotype.Service;
import nerd.Financial.Report.Generator.Models.ExpenseModel;
import nerd.Financial.Report.Generator.Models.ExpenseModel;
import org.springframework.stereotype.Service;
import nerd.Financial.Report.Generator.Models.ExpenseModel;
import nerd.Financial.Report.Generator.Models.ResponsePojo;
import nerd.Financial.Report.Generator.Repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Service
public class ExpenseService{

    @Autowired
    private ExpenseRepository expenseRepository;



    public ResponseEntity<?> getAllExpenses(){
        //Find records
        List<ExpenseModel> allExpenses = expenseRepository.findAll();
        if(allExpenses.isEmpty()) {
            // is data not found mean it was an exception? or it is a 200 without the data? interesting thought process really.
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponsePojo(HttpStatus.NOT_FOUND.value(), "No Content"));
        }
        return ResponseEntity.ok(new ResponsePojo(HttpStatus.OK.value()));
    }
   

    public ResponseEntity<String> recordExpense(ExpenseModel expense){

        //Check for existing records
        if(expenseRepository.findById(expense.getExpenseId()).isPresent()) {
            return new ResponseEntity<String>("Expense Record Exists", HttpStatus.BAD_REQUEST);
        }

        Long id = expense.getExpenseId();
        String date = expense.getDate();
        String description = expense.getDescription();
        float amount = expense.getAmount();
        //create object instance of new expense and save
        ExpenseModel newExpense = new ExpenseModel(id, date, description, amount);

        expenseRepository.save(newExpense);
        return ResponseEntity.ok("Expense Recorded Successfully");
    }
    

    public ResponseEntity<ExpenseModel> editExpense( Long id,  ExpenseModel expense){
        //Check if record exists
        if(expenseRepository.findById(id).isEmpty()) return ResponseEntity.noContent().build();
        //Retrieve Expense
        ExpenseModel retrievedExpense = expenseRepository.findById(id).get();
        //Update Expense
        retrievedExpense.setDescription(expense.getDescription());
        retrievedExpense.setDate(expense.getDate());
        retrievedExpense.setAmount(expense.getAmount());
        expenseRepository.save(retrievedExpense);
        return ResponseEntity.ok(expense);
    }


    public ResponseEntity<ExpenseModel> deleteExpense( Long id){
        ExpenseModel retrievedExpense =  expenseRepository.findById(id).orElse(null);
        if(retrievedExpense != null){
            expenseRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }


    public ExpenseModel recordExpense(ExpenseModel data){
            Long id = data.getExpenseId();
            String date = data.getDate();
            String description = data.getDescription();
            float amount = data.getAmount();

            return new ExpenseModel(id, date, description, amount);
    }
}