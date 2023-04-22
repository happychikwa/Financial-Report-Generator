package nerd.Financial.Report.Generator.Controller;

import nerd.Financial.Report.Generator.Models.ExpenseModel;
import org.springframework.stereotype.Service;
@Service
public class ExpenseController {
    public ExpenseModel recordExpense(ExpenseModel data){
        Long id = data.getExpenseId();
        String date = data.getDate();
        String description = data.getDescription();
        float amount = data.getAmount();

        return new ExpenseModel(id, date, description, amount);
    }
}
