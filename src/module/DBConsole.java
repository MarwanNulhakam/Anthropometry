package module;
/*
 * Created By. Wind Raider Zero
 * java programmer @AtoSoft Corp.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DBConsole {
    private Statement state;
    private Connection con;
    boolean nothing_error=true;
    public String comment;
    
    private String url = "jdbc:mysql:";
    public ResultSet rs;
    
    public DBConsole(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            url+="//localhost/mysql";
            con=DriverManager.getConnection(url,"root","");
            state=con.createStatement();
            nothing_error&=true;
            System.out.println("Database Connected");
        }catch(ClassNotFoundException e){
            nothing_error&=false;
            System.out.println(e.getMessage());
        }catch(SQLException ex){
            nothing_error&=false;
            System.out.println("error found : "+ex.getMessage());
        }
    }
    
    public DBConsole(String addr, String databaseName, String id,String pass){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            url+="//"+addr+"/"+databaseName;
            con=DriverManager.getConnection(url,id,pass);
            state=con.createStatement();
            nothing_error&=true;
            System.out.println("Database Connected");
            System.gc();
        }catch(ClassNotFoundException e){
            nothing_error&=false;
            System.out.println(e.getMessage());
        }catch(SQLException ex){
            nothing_error&=false;
            System.out.println("error found : "+ex.getMessage());
            System.gc();
        }
    }

    public void testConnection(String dbName){
        try{
            state.executeUpdate("use "+dbName);
            System.out.println("database created successfully");
            nothing_error&=true;
            System.gc();
        }catch(SQLException ex){
            System.out.println("error found : "+ex.getMessage());
            nothing_error&=false;
            System.gc();
        }
    }

    public void doStatement(String a){
        try{
            state.executeUpdate(a);
            javax.swing.JOptionPane.showMessageDialog(null, "Process Completed", "info", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            nothing_error&=true;
            System.gc();
        }catch(SQLException ex){
            javax.swing.JOptionPane.showMessageDialog(null, "sorry, "+ex.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
            nothing_error&=false;
            System.gc();
        }
    }
    public void doStatement(String a,int hide){
        try{
            state.executeUpdate(a);
            nothing_error&=true;
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            String x= (ex.getMessage()).substring(0, 15);
            System.out.println(x);
            System.gc();
            if(x.equals("Duplicate entry")){
                nothing_error&=true;
            }
            else{
                nothing_error&=false;
                javax.swing.JOptionPane.showMessageDialog(null, "sorry, "+ex.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
                System.gc();
            }
        }
    }

    public String [] doQuery(String query){
        //System.out.println(query);
        String[]Result=null;
        ResultSet result;
        int x=0;
        try{
            result = state.executeQuery(query);
            result.last();
            x=result.getRow();
            //System.out.println("last row index = "+x);
            if(x<1)
                return (Result);
            Result = new String[x];
            result.first();
            int i=0;
            do{
                Result[i]=result.getString(1);
                //System.out.println(i+" : "+Result[i]);
                i++;
            }while(result.next());
        }catch(SQLException ex){
            javax.swing.JOptionPane.showMessageDialog(null, "sorry, "+ex.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
            System.gc();
            return null;
        }
        System.gc();
        return Result;
        
    }
    public String [][] doQuery(String query,int QueryAttribute){
        //System.out.println(query);
        String[][]Result=null;
        ResultSet result;
        int x=0;        
        try{
            result = state.executeQuery(query);
            if(!result.next()){
                return null;
            }
            rs=result;
            int y= numberOfColumn();
            result.last();
            x=result.getRow();
            Result = new String[x][y];
            result.first();
            
            int i=0;
            do{                
                for(int j=0;j<y;j++){
                    Result[i][j]=result.getString(j+1);
                }
//                while(result.getString(j)!=null){
//                    Result[i][j]=result.getString(j+1);
//                    j++;
//                }
                
                i++;
            }while(result.next());
        }catch(SQLException ex){
            javax.swing.JOptionPane.showMessageDialog(null, "sorry, "+ex.getMessage(), "ERROR", javax.swing.JOptionPane.ERROR_MESSAGE);
            System.gc();
            return null;
            
        }catch(NullPointerException npe){
            System.gc();
        }
        System.gc();
        return Result;
    }

    public void closed(){
        try {
            state.close();
            con.close();
//            System.out.println("connection closed");
        } catch (SQLException ex) {
            System.out.println("error found : "+ex.getMessage());
        }
    }
    
    public int numberOfColumn(){
        if(rs==null){
            return 0;
        }        
        int as=0;        
        String x="";
        try{
            rs.first();
            while(rs.getString(as+1)!=null){
               as++;                
            }
        }catch(SQLException sqle){}
        return as;
    }
}