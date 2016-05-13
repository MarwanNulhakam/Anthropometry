/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Wind Raider Zero
 */
public class MainInterface {
    public static void main(String[]args){
        calculation.ZScoreSystemCalculation cal = new calculation.ZScoreSystemCalculation();
/*
    *
    *   DEKLARASI VARIABEL DATA
    *
*/        
        String gender = "laki";
        String dateOfBirth = "2015-01-03";
        
        String[] measurementDate = 
            {
                "2015-01-03","2015-2-08","2015-03-01","2015-04-09","2015-05-26","2015-06-17",
                "2015-07-22","2015-08-15","2015-09-10","2015-10-05","2015-11-09","2015-12-12",
                "2016-01-17","2016-02-10","2016-03-08","2016-04-20"
            };
        
        double ageWeightData[][] = {
//          age                                                             weight  length
            {cal.dailyUnitCalculationOf(dateOfBirth, measurementDate[0]),   3.2,    50.8},
            {cal.dailyUnitCalculationOf(dateOfBirth, measurementDate[1]),   3.8,    53.5},
            {cal.dailyUnitCalculationOf(dateOfBirth, measurementDate[2]),   4.7,    56.2},
            {cal.dailyUnitCalculationOf(dateOfBirth, measurementDate[3]),   5.4,    60.1},
            {cal.dailyUnitCalculationOf(dateOfBirth, measurementDate[4]),   6,      64.8},
            {cal.dailyUnitCalculationOf(dateOfBirth, measurementDate[5]),   6.7,    68.2},
            {cal.dailyUnitCalculationOf(dateOfBirth, measurementDate[6]),   7.7,    71.3},
            {cal.dailyUnitCalculationOf(dateOfBirth, measurementDate[7]),   8.4,    74.1},
            {cal.dailyUnitCalculationOf(dateOfBirth, measurementDate[8]),   9,      76.4},
            {cal.dailyUnitCalculationOf(dateOfBirth, measurementDate[9]),   9.5,    78.4},
            {cal.dailyUnitCalculationOf(dateOfBirth, measurementDate[10]),  9.9,    79.4},
            {cal.dailyUnitCalculationOf(dateOfBirth, measurementDate[11]),  10.3,   79.9},
            {cal.dailyUnitCalculationOf(dateOfBirth, measurementDate[12]),  10.6,   80.5},
            {cal.dailyUnitCalculationOf(dateOfBirth, measurementDate[13]),  10.8,   81.5},
            {cal.dailyUnitCalculationOf(dateOfBirth, measurementDate[14]),  11,     82.7},
            {cal.dailyUnitCalculationOf(dateOfBirth, measurementDate[15]),  11.1,   76.4}

        };
//#################################################################################################################        
        
/*
    *
    * PEMROSESAN DATA
    *
*/        
        boolean isMale = gender.equals("laki");
        
        int length = ageWeightData.length;
        
        double zScoreWFA[] = new double[length];
        String statusWFA[] = new String[length];
        double zScoreHFA[] = new double[length];
        String statusHFA[] = new String[length];
        double zScoreWFL[] = new double[length];
        String statusWFL[] = new String[length];
        double zScoreBMIFA[] = new double[length];
        String statusBMIFA[] = new String[length];
        
        for(int i=0;i<length;i++){
            zScoreWFA[i] = cal.countWFA(isMale, (int)ageWeightData[i][0], ageWeightData[i][1]);
            statusWFA[i] = cal.getWFAZScoreClassification(zScoreWFA[i]);
            zScoreHFA[i] = cal.countHFA(isMale, (int)ageWeightData[i][0], ageWeightData[i][2]);
            statusHFA[i] = cal.getHFAZScoreClassification(zScoreHFA[i]);
            zScoreWFL[i] = cal.countWFL(isMale, ageWeightData[i][1], ageWeightData[i][2]);
            statusWFL[i] = cal.getWFLZScoreClassification(zScoreWFL[i]);
            zScoreBMIFA[i] = cal.countBMI(isMale, (int)ageWeightData[i][0],ageWeightData[i][1], ageWeightData[i][2]);
            statusBMIFA[i] = cal.getWFLZScoreClassification(zScoreBMIFA[i]);
        }
//############################################################################################################################    
        
/*
    *
    *TAMPILAN HASIL KLASIFIKASI
    *
*/        
        for(int j=0;j<length;j++){
            System.out.println("WFA "+j+"\t: "+zScoreWFA[j]+",\t "+statusWFA[j]);
        }
        System.out.println("\n");
        for(int j=0;j<length;j++){
            System.out.println("HFA "+j+"\t: "+zScoreHFA[j]+",\t "+statusHFA[j]);
        }
        System.out.println("\n");
        for(int j=0;j<length;j++){
            System.out.println("WFH "+j+"\t: "+zScoreWFL[j]+",\t "+statusWFL[j]);
        }
        System.out.println("\n");
        for(int j=0;j<length;j++){
            System.out.println("BMI "+j+"\t: "+zScoreBMIFA[j]+",\t "+statusBMIFA[j]);
        }
        System.out.println("\n");
        System.gc();
    }
}
