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

public class NewClass {
    public static void main(String[]args){
//        for(int i=0;i<32;i++){
//            System.out.print(i+",");
//        }
        double L=0.2517,M=3.8828,S=0.13996,y=2.2;
        
        double result = (Math.pow((y/M),L)-1)/(S*L);
        
        if(result<-3){
            double sd23 = (M*Math.pow((1+L*S*-2),1/L)) - (M*Math.pow((1+L*S*-3),1/L));
            double sd3 = (M*Math.pow((1+L*S*-3),1/L));
            
            result = -3+((y-sd3)/sd23);
        }
        else if(result>3){
            double sd23 = (M*Math.pow((1+L*S*3),1/L)) - (M*Math.pow((1+L*S*2),1/L));
            double sd3 = (M*Math.pow((1+L*S*3),1/L));
            
            result = -3+((y-sd3)/sd23);
        }
        
        System.out.println("L = "+L);
        System.out.println("M = "+M);
        System.out.println("S = "+S);
        System.out.println("");
        System.out.println("y = "+y+"\n\n");
        System.out.println("Z score = "+result);
        
        
    }
}
