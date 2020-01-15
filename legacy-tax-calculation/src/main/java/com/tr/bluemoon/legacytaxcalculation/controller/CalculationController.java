package com.tr.bluemoon.legacytaxcalculation.controller;

import com.tr.bluemoon.legacytaxcalculation.services.calc.CalcService;
import com.tr.bluemoon.legacytaxcalculation.services.pbApplication.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class CalculationController {
    @Autowired
    private CalcService calcService;

    @RequestMapping("/calculation")
    @ResponseBody
    public String callServiceCalculation(@RequestParam int empresa, @RequestParam String competencia) throws InterruptedException, IOException {
        int returnCode;
        String returnText;
        CalculationService service = new CalculationService();

        /* Here, can be made a control of application's return */
        returnCode = service.callPBCalculation(empresa, competencia);
        if ( returnCode == 3) {
            if (calcService.getCountCalc() > 0) {
                returnText = "Called PB Application returned success.\nThe value is " + calcService.maxValue() + ".";
            }else{
                returnText = "Called PB Application returned success, but not found records";
            }

        }
        else {
            returnText = "Called PB Application returned error. Code Error: " + returnCode;

            if (returnCode == -1) {
                returnText += " - Connection error.";
            } else{
                returnText += " - Incorrect parameters. It must begin with '-c'";
            }
        }

        System.out.println(returnText);

        return returnText;
    }
}
