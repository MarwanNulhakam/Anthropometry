package data;

/**
 *
 * @author Wind Raider Zero
 */
public class Person {
    private String name;
    private boolean isMale;
    private int monthAge;
    private int ageByDay;
    private double weight;
    private double height;
    
    private String weightOfAgeStatus;
    private String weightOfHeightStatus;
    private String heightOfAgeStatus;
    
    public Person(String name, boolean isMale, String dateOfBirth, 
            double weight, double height){
        this.name = name;
        this.isMale=isMale;
        this.weight=weight;
        this.height=height;
        
        String currentDate = new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
        String[] date1 = currentDate.split("-");
        String[] date2 = dateOfBirth.split("-");
        
        monthAge =  ((Integer.parseInt(date1[0])-Integer.parseInt(date2[0]))*12) + 
                        (Integer.parseInt(date1[1])-Integer.parseInt(date2[1])) - 
                        ((Integer.parseInt(date1[2])-Integer.parseInt(date2[2]))<0 ? 1:0);
        
        ageByDay = (monthAge*30) + Integer.parseInt(date1[2])- Integer.parseInt(date2[2]);
    }
    public boolean isMale(){
        return isMale;
    }
    public int getAge(){
        return monthAge;
    }
    public int getAgeByDay(){
        return ageByDay;
    }
    public double getWeight(){
        return weight;
    }
    public double getHeight(){
        return height;
    }
    
    public void setWeightOfAgeStatus(String status){
        this.weightOfAgeStatus = status;
    }
    public void setHeightOfAgeStatus(String status){
        this.heightOfAgeStatus = status;
    }
    public void setWeightOfHeightStatus(String status){
        this.weightOfHeightStatus = status;
    }
    
    public String getWeightOfAgeStatus(){
        return this.weightOfAgeStatus;
    }
    public String getHeightOfAgeStatus(){
        return this.heightOfAgeStatus;
    }
    public String getWeightOfHeightStatus(){
        return this.weightOfHeightStatus;
    }
    
    public void printStatus(){
        System.out.println("name\t\t: "+this.name);
        System.out.println("age (month)\t: "+this.monthAge);
        System.out.println("gender\t\t: "+ (this.isMale?"male":"female"));
        System.out.println("weight\t\t: "+this.weight);
        System.out.println("height\t\t: "+this.height);
        System.out.println("");
        System.out.println("");
        System.out.println("weight of age status : "+ this.weightOfAgeStatus);
        System.out.println("height of age status : "+ this.heightOfAgeStatus);
        System.out.println("weight of height status : "+ this.weightOfHeightStatus);
    }
}
