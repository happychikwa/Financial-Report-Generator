package nerd.Financial.Report.Generator.Controller;

import nerd.Financial.Report.Generator.Repository.RevenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import nerd.Financial.Report.Generator.Models.RevenueModel;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RevenueServices {
    @Autowired
    private RevenueRepository revenueRepository;
    //record the generated Revenue
    public String recordRevenue(RevenueModel revenue){
        if(revenueRepository.findById(revenue.getId()).isPresent()) return "Record Exists";
        revenueRepository.save(revenue);
        return "Revenue Recorded.";
    }
    public RevenueModel getRecordById(Long recordId){
        RevenueModel record = revenueRepository.findById(recordId).get();
        if(revenueRepository.findById(recordId).isPresent()) return record;
        return null ;
    }
    //Retrieves all recorded revenue
    public List<RevenueModel> getAllRevenue(){
        return revenueRepository.findAll();
    }
    public String updateRevenueRecord(RevenueModel record){
        Long recordId = record.getId();
        String source = record.getRevenueSource();
        int amount = record.getAmount();
        String date = record.getUpdatedAt();

        if(revenueRepository.findById(recordId).isEmpty()) return "Record does not Exist.";
        RevenueModel revenueRecord = revenueRepository.findById(recordId).get();
        revenueRecord.setRevenueSource(source);
        revenueRecord.setAmount(amount);
        revenueRecord.setUpdatedAt(date);
        revenueRepository.save(revenueRecord);
        return "Record updated";
    }
    public String deleteRevenue(Long recordId){
        if(revenueRepository.findById(recordId).isEmpty()) return "Record does not Exist.";
        revenueRepository.deleteById(recordId);
        return "Record Deleted.";
    }

}
