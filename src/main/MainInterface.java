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
//        calculation.Calculator calc = new calculation.Calculator();
//        data.Person marwan = new data.Person("Marwan", true, "2015-01-01", 12, 61.5);
////                                              nama    jk      tgl lhr     w   h
//        calc.calculate(marwan);
//        marwan.printStatus();
//       
//        for(int i=1;i<32;i++){
//            System.out.print(i+",");
//        }

        String gender = "laki";
        
        calculation.ZScoreSystemCalculation cal = new calculation.ZScoreSystemCalculation();
        double ageWeightData[][] = {
//                                  age     weight  length                        
                                    {0,     3.2,    50.8},
                                    {30,    3.8,    53.5},
                                    {60,    4.7,    56.2},
                                    {90,    5.4,    60.1},
                                    {120,   6,      64.8},
                                    {150,   6.7,    68.2},
                                    {180,   7.7,    71.3},
                                    {210,   8.4,    74.1},
                                    {240,   9,      76.4},
                                    {270,   9.5,    78.4},
                                    {300,   9.9,    79.4},
                                    {330,   10.3,   79.9},
                                    {360,   10.6,   80.5},
                                    {390,   10.8,   81.5},
                                    {420,   11,     82.7},
                                    {450,   11.1,   76.4}
        
        };
        
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
