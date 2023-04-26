package nerd.Financial.Report.Generator.Routes;

import nerd.Financial.Report.Generator.Controller.ExpenseServices;
import nerd.Financial.Report.Generator.Models.ExpenseModel;
import nerd.Financial.Report.Generator.Repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpensesRoutes {
    @Autowired
    private ExpenseServices services;

    @GetMapping("/expenses")
    @ResponseBody
    public ResponseEntity<List<ExpenseModel>> getAllExpenses(){
        return ResponseEntity.ok(services.getAllExpenses());
    }
    @PostMapping("/expense")
    @ResponseBody
    public ResponseEntity<String> recordExpense(@RequestBody ExpenseModel expense){
        return ResponseEntity.ok(services.recordExpense(expense));
    }
    @PutMapping("/expense")
    @ResponseBody
    public ResponseEntity<String> editExpense(@RequestBody ExpenseModel expense){
        return ResponseEntity.ok(services.editExpense(expense));
    }
    @DeleteMapping("/expense")
    @ResponseBody
    public ResponseEntity<String> deleteExpense(@RequestBody Long id){
        return ResponseEntity.ok(services.deleteExpense(id));
    }
}