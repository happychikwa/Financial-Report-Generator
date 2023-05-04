package nerd.Financial.Report.Generator.Models;

import lombok.Data;

@Data
public class ResponsePojo {
    private Integer statusCode;
    private Object message;
    public ResponsePojo(){}
    public ResponsePojo(Integer code, Object msg){
        this.statusCode = code;
        this.message = msg;
    }
}
