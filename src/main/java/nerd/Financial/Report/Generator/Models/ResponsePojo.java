package nerd.Financial.Report.Generator.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Data
public class ResponsePojo {
    private Integer statusCode;
    private Object message;

    public ResponsePojo(){}

    public ResponsePojo(Integer statusCode, Object message){
        this.statusCode = statusCode;
        this.message= message;
    }

}
