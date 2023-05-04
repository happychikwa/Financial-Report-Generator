package nerd.Financial.Report.Generator.Services;

import nerd.Financial.Report.Generator.Repository.ExpenseRepository;
import nerd.Financial.Report.Generator.Repository.RevenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public class ProfitLossStatementService {
//    @Autowired
//    RevenueRepository revenueRepository;
//    @Autowired
//    ExpenseRepository expenseRepo;
    //calculate the total sales

    public int totalRevenue(){
        return 0;
    }
    //calculate the total indirect Expenses
    public int totalIndirectExpenses(){
        return 100;
    }
    //calculate the total direct sales
    public int totalDirectExpenses(){
        return 100;
    }
    public int grossTotal(){
        return 100;
    }
    public int netTotal(){
        return 100;
    }
}
