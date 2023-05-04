package nerd.Financial.Report.Generator.Controller;
import nerd.Financial.Report.Generator.Models.ResponsePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import nerd.Financial.Report.Generator.Services.RevenueServices;
import nerd.Financial.Report.Generator.Models.RevenueModel;

import java.util.List;

@RestController
@RequestMapping("revenue-api")
public class RevenueController {
    @Autowired
    RevenueServices services;
    @GetMapping("/getAllRevenueRecords")
    @ResponseBody
    public ResponseEntity<?> getAllRecordsRoute(){
        return services.getAllRevenue();
    }
    @PostMapping("/addRevenue")
    @ResponseBody
    public ResponseEntity<ResponsePojo> recordRevenueRoute(@RequestBody RevenueModel revenue){
        return services.recordRevenue(revenue);
    }
    @PutMapping("/editRevenue")
    @ResponseBody
    public ResponseEntity<ResponsePojo> updateRecordRoute(@RequestBody RevenueModel revenue){
        return services.editRevenueRecord(revenue);
    }
    @DeleteMapping("/deleteRevenueRecord/{id}")
    @ResponseBody
    public ResponseEntity<ResponsePojo> deleteRevenueRecord(@PathVariable Long id){
        return services.deleteRevenue(id);
    }
}
