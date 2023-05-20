import java.sql.*;
import javax.swing.JOptionPane;

public class ConnectiontoDB {
    Connection con = null;
    public Connection EstablishConnection()
    {
        try
        {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            con=DriverManager.getConnection("jdbc:ucanaccess://E:\\Database61.accdb");
            //JOptionPane.showMessageDialog(null, "Connected");
        }
        catch(Exception ex)
        {
             JOptionPane.showMessageDialog(null, ex);
        }
        return con;
    }
}
