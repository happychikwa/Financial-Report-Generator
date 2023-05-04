package nerd.Financial.Report.Generator.Services;

import nerd.Financial.Report.Generator.Repository.RevenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import nerd.Financial.Report.Generator.Models.RevenueModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import nerd.Financial.Report.Generator.Models.ResponsePojo;

import java.util.List;
@Service
public class RevenueServices {
    @Autowired
    private RevenueRepository revenueRepository;
    //record the generated Revenue
    public ResponseEntity<ResponsePojo> recordRevenue(RevenueModel revenue){
        if(revenueRepository.findById(revenue.getId()).isPresent()) return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).body(new ResponsePojo(HttpStatus.NO_CONTENT.value(), "Revenue record Exists."));
        revenueRepository.save(revenue);
        return ResponseEntity.ok(new ResponsePojo(HttpStatus.OK.value(), "Revenue Recorded."));
    }
    public RevenueModel getRecordById(Long recordId){
        RevenueModel record = revenueRepository.findById(recordId).get();
        if(revenueRepository.findById(recordId).isPresent()) return record;
        return null ;
    }
    //Retrieves all recorded revenue
    public ResponseEntity<?> getAllRevenue(){
        if(revenueRepository.findAll().isEmpty()) return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).body(new ResponsePojo(HttpStatus.NO_CONTENT.value(),"No Revenue found"));
        return ResponseEntity.ok(new ResponsePojo(HttpStatus.OK.value(),revenueRepository.findAll()));
    }
    public ResponseEntity<ResponsePojo> editRevenueRecord(RevenueModel record){
        Long recordId = record.getId();
        String source = record.getRevenueSource();
        int amount = record.getAmount();
        String date = record.getUpdatedAt();

        if(revenueRepository.findById(recordId).isEmpty()) return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).body(new ResponsePojo(HttpStatus.NO_CONTENT.value(), "Record does not Exist."));
        RevenueModel revenueRecord = revenueRepository.findById(recordId).get();
        revenueRecord.setRevenueSource(source);
        revenueRecord.setAmount(amount);
        revenueRecord.setUpdatedAt(date);
        revenueRepository.save(revenueRecord);
        return ResponseEntity.ok(new ResponsePojo(HttpStatus.OK.value(),"Revenue Saved"));
    }
    public ResponseEntity<ResponsePojo> deleteRevenue(Long recordId){
        if(revenueRepository.findById(recordId).isEmpty()) return ResponseEntity.status(HttpStatus.NO_CONTENT.value()).body(new ResponsePojo(HttpStatus.NO_CONTENT.value(), "Revenue record does not Exist."));
        revenueRepository.deleteById(recordId);
        return ResponseEntity.ok(new ResponsePojo(HttpStatus.OK.value(), "Revenue record deleted."));
    }

}
