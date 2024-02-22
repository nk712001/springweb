package com.example.springweb.Repository;

import com.example.springweb.Entity.GetQuoteResponse;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface GetQuoteResponseRepo extends JpaRepository<GetQuoteResponse, Long> {
    @Query(nativeQuery = true, value = "select * from get_quote_response WHERE sum_insured=?1 AND period=?2")
    List<GetQuoteResponse> searchField(String sum, String period);

    @Query(nativeQuery = true, value = "select * from get_quote_response WHERE sum_insured=?1")
    List<GetQuoteResponse> searchSum(String sum);

    @Query(nativeQuery = true, value = "select * from get_quote_response WHERE period=?1")
    List<GetQuoteResponse> searchYear(String period);
}

