package nerd.Financial.Report.Generator.Repository;

import nerd.Financial.Report.Generator.Models.ExpenseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseModel, Long> {

}
