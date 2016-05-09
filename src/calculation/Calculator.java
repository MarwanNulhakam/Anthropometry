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
public class Calculator {
    private data.ReferenceTable table = new data.ReferenceTable();
    private data.Person person;
    
    public void calculate(data.Person person){
        this.person=person;
        if(person.getAge()<0){
            javax.swing.JOptionPane.showMessageDialog(null, "you have enter the wrong date of birth", "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
            return;
        }
        person.setHeightOfAgeStatus(checkHeightOfAgeStatus());
        person.setWeightOfAgeStatus(checkWeightOfAgeStatus());
        person.setWeightOfHeightStatus(checkWeightOfHeightStatus());
        
    }
    
    private String checkWeightOfAgeStatus(){
        double [][]weightAgeStandard;
        String [] weightAgeStandardIndex;
        if(person.isMale()){
            weightAgeStandard = table.boyWeightAgeStandard;
            weightAgeStandardIndex = table.boyWeightAgeStandardIndex;
        }else{
            weightAgeStandard = table.girlWeightAgeStandard;
            weightAgeStandardIndex = table.girlWeightAgeStandardIndex;
        }
        
        if(person.getAge()>60)
            return "error";
        return  weightAgeStandard[person.getAge()][0]>person.getWeight() ? weightAgeStandardIndex[0]:
                weightAgeStandard[person.getAge()][1]>person.getWeight() ? weightAgeStandardIndex[1]:
                weightAgeStandard[person.getAge()][5]<person.getWeight() ? weightAgeStandardIndex[3]:
                weightAgeStandardIndex[2];
        
    }
    
    private String checkHeightOfAgeStatus(){
        double [][]heightAgeStandard;
        String [] heightAgeStandardIndex;
        if(person.isMale()){
            heightAgeStandard = table.boyHeightAgeStandard;
            heightAgeStandardIndex = table.boyHeightAgeStandardIndex;
        }else{
            heightAgeStandard = table.girlHeightAgeStandard;
            heightAgeStandardIndex = table.girlHeightAgeStandardIndex;
        }
        
        if(person.getAge()>60)
            return "error";
        
        return  heightAgeStandard[person.getAge()][0]>person.getHeight() ? heightAgeStandardIndex[0]:
                heightAgeStandard[person.getAge()][1]>person.getHeight() ? heightAgeStandardIndex[1]:
                heightAgeStandard[person.getAge()][5]<person.getHeight() ? heightAgeStandardIndex[3]:
                heightAgeStandardIndex[2];
        
    }
    
    private String checkWeightOfHeightStatus(){
        int index = 0;
        double [][]weightHeightStandard;
        String [] weightHeightStandardIndex;
        
        if(person.getAge()<=24){
            index = person.getHeight()>45 ? (int)((person.getHeight() - 45)*2):0;
            if(person.isMale()){
                weightHeightStandard = table.boyWeightLengthStandard;
                weightHeightStandardIndex = table.boyWeightHeightStandardIndex;
            }else{
                weightHeightStandard = table.girlWeightLengthStandard;
                weightHeightStandardIndex = table.girlWeightHeightStandardIndex;
            }
        }
        else{
            index = person.getHeight()>65 ? (int)((person.getHeight() - 65)*2):0;
            if(person.isMale()){
                weightHeightStandard = table.boyWeightHeightStandard;
                weightHeightStandardIndex = table.boyWeightHeightStandardIndex;
            }else{
                weightHeightStandard = table.girlWeightHeightStandard;
                weightHeightStandardIndex = table.girlWeightHeightStandardIndex;
            }
        }
        
        return  weightHeightStandard[index][0]>person.getWeight() ? weightHeightStandardIndex[0]:
                weightHeightStandard[index][1]>person.getWeight() ? weightHeightStandardIndex[1]:
                weightHeightStandard[index][5]<person.getWeight() ? weightHeightStandardIndex[3]:
                weightHeightStandardIndex[2];
        
    }
}
