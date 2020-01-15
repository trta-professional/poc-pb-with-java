package com.tr.bluemoon.legacytaxcalculation.services.calc;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("calc")
public class Calc {

    @Id
    private Integer id;
    private double calculation_period;

    public Calc(){

    }

    public Calc(Integer id, double calculation_period){
        this.id = id;
        this.calculation_period = calculation_period;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getCalculation_period() {
        return calculation_period;
    }

    public void setCalculation_period(double calculation_period) {
        this.calculation_period = calculation_period;
    }

    @Override
    public String toString() {
        return "Calc{" +
                "id=" + id +
                ", calculation_period=" + calculation_period +
                '}';
    }
}
