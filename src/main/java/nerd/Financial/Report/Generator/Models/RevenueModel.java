package nerd.Financial.Report.Generator.Models;

import jakarta.persistence.Entity;
import java.util.Date;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Entity(name = "Revenue")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RevenueModel {
    @Id
    private long id;
    private String revenueSource;
    private int amount;
    private String createdAt;
    private String updatedAt;
}
