package nerd.Financial.Report.Generator.Repository;

import nerd.Financial.Report.Generator.Models.ExpenseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("ExpenseRepository")
public interface ExpenseRepository extends JpaRepository<ExpenseModel, Long> {
    @Query(value = "SELECT sum(amount) from expense_model")
    public Long sumOfAmount();
}
