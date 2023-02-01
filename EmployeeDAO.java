import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDAO {

    String dbDriver = "com.mysql.jdbc.Driver";
    String dbURL = "jdbc:mysql://localhost:3306/myschema";
    String username = "root";
    String pwd = "Parth@4601#";
    Connection dbCon;

    private boolean connectToDtbc() throws SQLException, ClassNotFoundException {
        Class.forName(dbDriver);
        dbCon = DriverManager.getConnection(dbURL, username, pwd);
        return true;
    }

    public boolean insertRecord(Employee empObj)
    {
        String insertQueryStr = "insert into employee values(?,?,?,?,?,?,?)";

        try {
            if (connectToDtbc())
            {
                PreparedStatement ppStmt = dbCon.prepareStatement(insertQueryStr);
                ppStmt.setInt(1, empObj.getEmpid());
                ppStmt.setString(2, empObj.getEmpFirstName());
                ppStmt.setString(3, empObj.getEmpMdName());
                ppStmt.setString(4, empObj.getEmpLsName());
                ppStmt.setInt(5, empObj.getEmpAge());
                ppStmt.setString(6, empObj.getEmpDept());
                ppStmt.setString(7, empObj.getEmpAddr());
                ppStmt.executeUpdate();
                ppStmt.close();
                dbCon.close();
                return true;
            } 
            else 
            {
                return false;
            }
        } 
        catch (Exception e)
        {
        	return false;
        }

        
    }
}