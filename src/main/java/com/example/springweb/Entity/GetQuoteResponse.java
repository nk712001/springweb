package com.example.springweb.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;


@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table
@Data
public class GetQuoteResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String premiumAmount;
    private String premiumTax;
    private String totalAmount;
    private String message;
    private  String productCode;
    private  String sumInsured;
    private String period;

    public GetQuoteResponse(String premiumAmount, String premiumTax, String totalAmount, String message, String productCode ,String sumInsured,String period) {
        this.premiumAmount = premiumAmount;
        this.premiumTax = premiumTax;
        this.totalAmount = totalAmount;
        this.message = message;
        this.productCode = productCode;
        this.sumInsured = sumInsured;
        this.period = period;
    }

    public GetQuoteResponse() {
    }

    @Override
    public String toString() {
        return "GetQuoteResponse{" +
                "premiumAmount=" + premiumAmount +
                "premiumTax=" + premiumTax +
                "totalAmount=" + totalAmount +
                "totalAmount=" + totalAmount +
                "message=" + message +
                "productCode="+productCode+
                "sumInsured="+sumInsured+
                "period="+period+
                '}';
    }

}
