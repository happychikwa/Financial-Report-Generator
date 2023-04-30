package nerd.Financial.Report.Generator.Controller;

import nerd.Financial.Report.Generator.Models.ExpenseModel;
import org.springframework.stereotype.Service;
import nerd.Financial.Report.Generator.Models.ExpenseModel;
import nerd.Financial.Report.Generator.Repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import nerd.Financial.Report.Generator.Models.ResponsePojo;
import nerd.Financial.Report.Generator.services.ExpenseService;


import java.util.List;

@RestController
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/expenses")
    @ResponseBody
    public ResponseEntity<?> getAllExpenses(){
        return expenseService.getAllExpenses();
    }

    @PostMapping("/expense")
    @ResponseBody
    public ResponseEntity<String> recordExpense(@RequestBody ExpenseModel expense){
        return expenseService.recordExpense(expense);

    }
    @PutMapping("/expense/{id}")
    @ResponseBody
    public ResponseEntity<ExpenseModel> editExpense(@PathVariable Long id, @RequestBody ExpenseModel expense){
        return expenseService.editExpense(id, expense);

    }
    @DeleteMapping("/expense/{id}")
    @ResponseBody
    public ResponseEntity<ExpenseModel> deleteExpense(@PathVariable Long id){
         return expenseService.deleteExpense(id);

    }
}
