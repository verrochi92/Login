
package Data;
 import java.sql.*;

/**
 *
 * @author Yassine
 */
public class ConnectToDB {
    
    private Connection connect;
    private Statement stm;
    
       public ConnectToDB()
    {
        String url="jdbc:mysql://localhost:3306/login";
        String password="";
        String username="root";
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            connect=DriverManager.getConnection(url,username,password);
            stm=connect.createStatement();
            
        }catch(ClassNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }
         catch (SQLException ex){
             System.out.println(ex.getMessage());
         }
        
    }
       
    public Connection getConnect(){
      
        return connect;
    }
    public void setConnect(Connection connect)
    {
        this.connect=connect;
    }
    
    public Statement getStm()
    {
        return stm;
    }
    public void setStm(Statement stm)
    {
        this.stm=stm;
    }
}
