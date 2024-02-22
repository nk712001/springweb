package com.example.springweb.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class searchFields {
    @Column
    private String sumInsured;
    @Column
    private String period;
    @Column
    private String searchField;

    public searchFields(String period, String sumInsured, String searchField) {
        this.period = period;
        this.sumInsured = sumInsured;
        this.searchField = searchField;

    }

    public searchFields() {
    }
}
