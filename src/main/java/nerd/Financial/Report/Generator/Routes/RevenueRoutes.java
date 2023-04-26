package nerd.Financial.Report.Generator.Routes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import nerd.Financial.Report.Generator.Controller.RevenueServices;
import nerd.Financial.Report.Generator.Models.RevenueModel;
@RestController
@RequestMapping("revenue-api")
public class RevenueRoutes {
    @Autowired
    RevenueServices services;
    @GetMapping("/revenueRecords")
    @ResponseBody
    public ResponseEntity<String> getAllRecordsRoute(){
        services.getAllRevenue();
        return ResponseEntity.ok("Revenue Retrieved");
    }
    @PostMapping("/revenueRecord")
    @ResponseBody
    public ResponseEntity<String> recordRevenueRoute(@RequestBody RevenueModel revenue){
        String response = services.recordRevenue(revenue);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/revenueRecord")
    @ResponseBody
    public ResponseEntity<String> updateRecordRoute(@RequestBody RevenueModel revenue){
        String response = services.updateRevenueRecord(revenue);
        return ResponseEntity.ok(response);
    }
}
