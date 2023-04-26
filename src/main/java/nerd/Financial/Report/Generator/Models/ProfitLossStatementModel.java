package nerd.Financial.Report.Generator.Models;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class ProfitLossStatementModel {

    private long id;
    private int grossTotal;
    private int netTotal;
    private Date date;
    private int directExpenseTotal;
    private int indirectExpenseTotal;
    public ProfitLossStatementModel(){}
    public ProfitLossStatementModel(long statementId, int periodGrossTotal, int periodNetTotal, Date period, int periodDirectExpenses, int periodIndirectExpenses){
        this.id = statementId;
        this.grossTotal = periodGrossTotal;
        this.netTotal = periodNetTotal;
        this.date = period;
        this.directExpenseTotal = periodDirectExpenses;
        this.indirectExpenseTotal = periodIndirectExpenses;
    }

}
