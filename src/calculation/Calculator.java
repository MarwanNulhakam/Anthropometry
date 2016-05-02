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
        
        person.setHeightOfAgeStatus(checkHeightOfAgeStatus());
        person.setWeightOfAgeStatus(checkWeightOfAgeStatus());
        person.setWeightOfHeightStatus(checkWeightOfHeightStatus());
        
    }
    
    private String checkWeightOfAgeStatus(){
        if(person.getAge()>60)
            return "error";
        return  table.boyWeightAgeStandard[person.getAge()][0]>person.getWeight() ? table.boyWeightAgeStandardIndex[0]:
                table.boyWeightAgeStandard[person.getAge()][1]>person.getWeight() ? table.boyWeightAgeStandardIndex[1]:
                table.boyWeightAgeStandard[person.getAge()][5]<person.getWeight() ? table.boyWeightAgeStandardIndex[3]:
                table.boyWeightAgeStandardIndex[2];
        
    }
    
    private String checkHeightOfAgeStatus(){
        if(person.getAge()>60)
            return "error";
        else
            return  table.boyHeightAgeStandard[person.getAge()][0]>person.getHeight() ? table.boyHeightAgeStandardIndex[0]:
                table.boyHeightAgeStandard[person.getAge()][1]>person.getHeight() ? table.boyHeightAgeStandardIndex[1]:
                table.boyHeightAgeStandard[person.getAge()][5]<person.getHeight() ? table.boyHeightAgeStandardIndex[3]:
                table.boyHeightAgeStandardIndex[2];
        
    }
    
    private String checkWeightOfHeightStatus(){
        int index = 0;
        
        if(person.getAge()<=24){
            index = (int)((person.getHeight() - 45)*2);
            return  table.boyWeightLengthStandard[index][0]>person.getWeight() ? table.boyWeightHeightStandardIndex[0]:
                table.boyWeightLengthStandard[index][1]>person.getWeight() ? table.boyWeightHeightStandardIndex[1]:
                table.boyWeightLengthStandard[index][5]<person.getWeight() ? table.boyWeightHeightStandardIndex[3]:
                table.boyWeightHeightStandardIndex[2];
        }
        else{
            index = (int)((person.getHeight() - 65)*2);
            return  table.boyWeightHeightStandard[index][0]>person.getWeight() ? table.boyWeightHeightStandardIndex[0]:
                table.boyWeightHeightStandard[index][1]>person.getWeight() ? table.boyWeightHeightStandardIndex[1]:
                table.boyWeightHeightStandard[index][5]<person.getWeight() ? table.boyWeightHeightStandardIndex[3]:
                table.boyWeightHeightStandardIndex[2];
        }
    }
}
