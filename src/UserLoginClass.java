
import java.sql.*;
import javax.swing.JOptionPane;


public class UserLoginClass {
    ConnectiontoDB con = new ConnectiontoDB();
    Connection con_obj = con.EstablishConnection();
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet res = null;
    
    public boolean login(String uname, String upass)
    {
        String loginString="select * from login where Login_ID='"+uname+"' and Pass='"+upass+"'";
        boolean s;
        try
        {
            pstmt = con_obj.prepareStatement(loginString);
            res = pstmt.executeQuery();
            if(res.next())
                s=true;
            else
                s=false;
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
            s=false;
        }
        return s;
    }
    public boolean adduser(String user, String pwd)
    {
        boolean st = false;
        String sql="insert into login(Login_ID, Pass) values('"+user+"', '"+pwd+"')";
        try
        {
            stmt = con_obj.createStatement();
            int res = stmt.executeUpdate(sql);
            if(res>0)
            st=true;
            else
            st=false;
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
        return st;
    }
}

