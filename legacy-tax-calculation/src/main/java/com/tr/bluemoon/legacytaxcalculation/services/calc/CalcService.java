package com.tr.bluemoon.legacytaxcalculation.services.calc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CalcService {

    @Autowired
    private CalcRepository calcRepository;

    public Optional<Calc> getCalc(Integer id){
        return calcRepository.findById(id);
    }

    public long getCountCalc(){
        return calcRepository.count();
    }

    public double maxValue(){
        return calcRepository.maxValue();
    }
}
