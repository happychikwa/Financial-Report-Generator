package nerd.Financial.Report.Generator.Routes;

import nerd.Financial.Report.Generator.Models.ExpenseModel;
import nerd.Financial.Report.Generator.Repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Expenses {
    @Autowired
    private ExpenseRepository expenseRepository;

    @GetMapping("/expenses")
    @ResponseBody
    public ResponseEntity<List<ExpenseModel>> getAllExpenses(){
        //Find records
        List<ExpenseModel> allExpenses = expenseRepository.findAll();
        if(allExpenses.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(allExpenses);
    }
    @PostMapping("/expense")
    @ResponseBody
    public ResponseEntity<String> recordExpense(@RequestBody ExpenseModel expense){

        //Check for existing records
        if(expenseRepository.findById(expense.getExpenseId()).isPresent()) return new ResponseEntity<String>("Expense Record Exists", HttpStatus.BAD_REQUEST);

        Long id = expense.getExpenseId();
        String date = expense.getDate();
        String description = expense.getDescription();
        float amount = expense.getAmount();
        //create object instance of new expense and save
        ExpenseModel newExpense = new ExpenseModel(id, date, description, amount);

        expenseRepository.save(newExpense);
        return ResponseEntity.ok("Expense Recorded Successfully");
    }
    @PutMapping("/expense/{id}")
    @ResponseBody
    public ResponseEntity<ExpenseModel> editExpense(@PathVariable Long id, @RequestBody ExpenseModel expense){
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
    @DeleteMapping("/expense/{id}")
    @ResponseBody
    public ResponseEntity<ExpenseModel> deleteExpense(@PathVariable Long id){
        ExpenseModel retrievedExpense =  expenseRepository.findById(id).orElse(null);
        if(retrievedExpense != null){
            expenseRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}