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
        calculation.Calculator calc = new calculation.Calculator();
        data.Person marwan = new data.Person("Marwan", true, "2015-01-01", 12, 61.5);
//                                              nama    jk      tgl lhr     w   h
        calc.calculate(marwan);
        marwan.printStatus();
       
        for(int i=1;i<32;i++){
            System.out.print(i+",");
        }
    }
}
