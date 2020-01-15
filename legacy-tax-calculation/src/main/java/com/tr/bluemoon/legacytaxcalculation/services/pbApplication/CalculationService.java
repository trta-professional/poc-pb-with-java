package com.tr.bluemoon.legacytaxcalculation.services.pbApplication;

import java.io.IOException;

public class CalculationService {
    public int callPBCalculation(int empresa, String competencia) throws InterruptedException, IOException {
 		/*
		Set folder path that contains the PB application
		It must be in the current folder in a folder named "\PBapplication" and inside, has the following name: tax-calculation.exe
		*/
        Process process = new ProcessBuilder(System.getProperty("user.dir") + "\\\\PBapplication\\tax-calculation.exe", "-c", "/empresa " + empresa, "/competencia " + competencia).start();

        return process.waitFor();
    }
}
