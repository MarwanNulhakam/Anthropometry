/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculation;

/**
 *
 * @author Wind Raider Zero
 */
public class ZScoreSystemCalculation {
    
    private double[]coefficient;
    public data.Person person;
    
    private String zScoreClassification(String[]classificationTable, double zScore){
        return  zScore < -3 ?   classificationTable[0] :
                zScore < -2 ?   classificationTable[1] :
                zScore <  3 ?    classificationTable[2] :
                                classificationTable[3];
    }
    
    public String getWFAZScoreClassification(double zScore){
        return zScoreClassification(new data.ReferenceTableForDailyIndex().WeightAgeStandardIndex,zScore);
    }
    
    public String getHFAZScoreClassification(double zScore){
        return zScoreClassification(new data.ReferenceTableForDailyIndex().HeightAgeStandardIndex,zScore);
    }
    
    public String getWFLZScoreClassification(double zScore){
        return zScoreClassification(new data.ReferenceTableForDailyIndex().WeightHeightStandardIndex,zScore);
    }
    
    private double zScoreCalculation(double Y,double[]coefficient){
        double L = coefficient[1];        
        double M = coefficient[2];        
        double S = coefficient[3];        
        
        double result = (Math.pow((Y/M),L)-1)/(S*L);
        
        if(result<-3){
            double sd23 = (M*Math.pow((1+L*S*-2),1/L)) - (M*Math.pow((1+L*S*-3),1/L));
            double sd3 = (M*Math.pow((1+L*S*-3),1/L));
            result = -3+((Y-sd3)/sd23);
        }
        else if(result>3){
            double sd23 = (M*Math.pow((1+L*S*3),1/L)) - (M*Math.pow((1+L*S*2),1/L));
            double sd3 = (M*Math.pow((1+L*S*3),1/L));
            result = 3+((Y-sd3)/sd23);
        }
        return result;
    }
    
    public double countWFA(boolean isMale,int age,double weight){
        
        coefficient = isMale ? new data.ReferenceTableForDailyIndex().getBoysWeightForAge(age):
                               new data.ReferenceTableForDailyIndex().getGirlsWeightForAge(age);
        return this.zScoreCalculation(weight, coefficient);
    }
    
    public double countHFA(boolean isMale,int age, double height){
        
        coefficient = isMale ? new data.ReferenceTableForDailyIndex().getBoysLengthForAge(age):
                               new data.ReferenceTableForDailyIndex().getGirlsLengthForAge(age);
        return this.zScoreCalculation(height, coefficient);
    }
    
    public double countWFL(boolean isMale, double weight, double length){
        int index = length <=45 ? 0: (int)((length - 45.0)*10);
        coefficient = isMale ? new data.ReferenceTableForDailyIndex().getBoysWeightForLength(index):
                               new data.ReferenceTableForDailyIndex().getGirlsWeightForLength(index);
        return this.zScoreCalculation(weight, coefficient);
    }
    
    public double countWFH(boolean isMale, double weight,double height){
        int index = height <=65 ? 0: (int)((height - 65.0)*10);
        coefficient = isMale ? new data.ReferenceTableForDailyIndex().getBoysWeightForHeight(index):
                               new data.ReferenceTableForDailyIndex().getGirlsWeightForHeight(index);
        return this.zScoreCalculation(weight, coefficient);
    }
    
    public double countBMI(boolean isMale, int age, double weight,double height){
        double param = weight/Math.pow(height/100,2);
        coefficient = isMale ? new data.ReferenceTableForDailyIndex().getBoysBMIForAge(age):
                               new data.ReferenceTableForDailyIndex().getGirlsBMIForAge(age);
        return this.zScoreCalculation(param, coefficient);
    }
    
    public int dailyUnitCalculationOf(String dateFrom,String dateTo){
        String[]d1 = dateFrom.split("-");
        String[]d2 = dateTo.split("-");
        
        int day1=Integer.parseInt(d1[2]),month1=Integer.parseInt(d1[1]),year1=Integer.parseInt(d1[0]);
        int day2=Integer.parseInt(d2[2]),month2=Integer.parseInt(d2[1]),year2=Integer.parseInt(d2[0]);
       
        int[]dayLength = {31,28,31,30,31,30,31,31,30,31,30,31};
        int counter = 0;
        dayLength[1] = year1%4 == 0 ? 29 :28;
        
        while(day1<=day2 || month1<month2 || year1<year2){
            counter++;
            day1++;
            if (day1>dayLength[month1-1]){
                day1 = 1;
                month1++;
            }
            if (month1 > 12){
                month1=1;
                year1++;
                dayLength[1] = year1 % 4 == 0 ? 29:28;
            }
        }
        
        return counter;
    }
}
