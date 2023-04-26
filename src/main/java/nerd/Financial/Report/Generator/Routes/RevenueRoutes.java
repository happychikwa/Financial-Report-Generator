package nerd.Financial.Report.Generator.Routes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import nerd.Financial.Report.Generator.Controller.RevenueServices;
import nerd.Financial.Report.Generator.Models.RevenueModel;

import java.util.List;

@RestController
@RequestMapping("revenue-api")
public class RevenueRoutes {
    @Autowired
    RevenueServices services;
    @GetMapping("/getAllRevenueRecords")
    @ResponseBody
    public ResponseEntity<List<RevenueModel>> getAllRecordsRoute(){
        return ResponseEntity.ok(services.getAllRevenue());
    }
    @PostMapping("/addRevenueRecord")
    @ResponseBody
    public ResponseEntity<String> recordRevenueRoute(@RequestBody RevenueModel revenue){
        String response = services.recordRevenue(revenue);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/editRevenueRecord")
    @ResponseBody
    public ResponseEntity<String> updateRecordRoute(@RequestBody RevenueModel revenue){
        String response = services.updateRevenueRecord(revenue);
        return ResponseEntity.ok(response);
    }
    @DeleteMapping("/deleteRevenueRecord/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteRevenueRecord(@PathVariable Long id){
        return ResponseEntity.ok(services.deleteRevenue(id));
    }
}
