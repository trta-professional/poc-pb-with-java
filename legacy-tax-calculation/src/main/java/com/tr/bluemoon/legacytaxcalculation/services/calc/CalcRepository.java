package com.tr.bluemoon.legacytaxcalculation.services.calc;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalcRepository extends CrudRepository<Calc, Integer> {
    List<Calc> findAll();

    @Query("select max(calculation_period) from calc")
    double maxValue();
}
