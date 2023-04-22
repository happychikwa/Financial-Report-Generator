package nerd.Financial.Report.Generator.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class ExpenseModel {
    @Id
    private Long expenseId;
    private String date;
    private String description;
    private float amount;

    public ExpenseModel(){}
    public ExpenseModel(long Id, String dateOfPurchase, String itemsBought, float amountPayed ){
        this.expenseId = Id;
        this.date = dateOfPurchase;
        this.description = itemsBought;
        this.amount = amountPayed;
    }

}
