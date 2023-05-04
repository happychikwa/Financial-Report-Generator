package nerd.Financial.Report.Generator.Controller;

import nerd.Financial.Report.Generator.Models.ResponsePojo;
import nerd.Financial.Report.Generator.Services.ExpenseServices;
import nerd.Financial.Report.Generator.Models.ExpenseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExpensesController {
    @Autowired
    @Qualifier("expenseservice")
    private ExpenseServices services;

    @GetMapping("/expenses")
    @ResponseBody
    public ResponseEntity<?> getAllExpenses(){
        return services.getAllExpenses();
    }
    @PostMapping("/expense")
    @ResponseBody
    public ResponseEntity<ResponsePojo> recordExpense(@RequestBody ExpenseModel expense){
        return services.recordExpense(expense);
    }
    @PutMapping("/expense")
    @ResponseBody
    public ResponseEntity<ResponsePojo> editExpense(@RequestBody ExpenseModel expense){
        return services.editExpense(expense);
    }
    @DeleteMapping("/expense")
    @ResponseBody
    public ResponseEntity<ResponsePojo> deleteExpense(@RequestBody Long id){
        return services.deleteExpense(id);
    }
}