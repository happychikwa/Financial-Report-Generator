package nerd.Financial.Report.Generator.Repository;

import nerd.Financial.Report.Generator.Models.RevenueModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevenueRepository extends JpaRepository<RevenueModel, Long> {
}
