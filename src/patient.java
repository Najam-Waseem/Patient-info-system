import java.sql.*;
import javax.swing.JOptionPane;
public class patient extends Person{
        ConnectiontoDB con = new ConnectiontoDB();
    Connection con_obj = con.EstablishConnection();
    Statement stmt = null;
    PreparedStatement pstmt = null;
    ResultSet res = null;

    /**
     *
     * @param f
     * @param s
     * @param p
     * @param dob
     * @param a
     * @param address
     * @param d
     * @param dr
     * @param g
     * @return
     */
    @Override
    public boolean addpatient(String f, String s, String p, String dob, String a, String address, String d, String dr, String g)
    {
        boolean st = false;
        String sql="insert into information(First_Name, Last_Name, Phone_Number, DOB, Age, Address, Disease, Doctor_Name, GENDER) values('"+f+"', '"+s+"', '"+p+"', '"+dob+"', '"+a+"', '"+address+"', '"+d+"', '"+dr+"', '"+g+"')";
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
        @Override
    public boolean delpatient(int id)
    {
        boolean st = false;
        String sql="delete from information where ID = '"+id+"'";
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
    int id;
         public boolean searchpatient(int id)
         {
             String sea="select * from information where ID = '"+id+"'";
             boolean st = false;
             try
             {
                 pstmt=con_obj.prepareStatement(sea);
                 res=pstmt.executeQuery();
                 while(res.next())
                 {
                    //this.id=id;
                    a = res.getString("First_Name");
                    b = res.getString("Last_Name");
                    c = res.getString("Phone_Number");
                    d = res.getString("DOB");
                    e = res.getString("AGE");
                    f = res.getString("Address");
                    g=res.getString("Disease");
                    h=res.getString("Doctor_Name");
                    i=res.getString("GENDER");
                   st=true;
                 }
             }
             catch(Exception ex)
             {
                 JOptionPane.showMessageDialog(null, ex);
             }
             return st;
             }
         public boolean updatepatient(String f, String s, String p, String dob, String a, String address, String d, String dr, String g)
         {
             String sea="select * from information";
             boolean st = false;
             try
             {
                 pstmt=con_obj.prepareStatement(sea);
                 res=pstmt.executeQuery();
                 while(res.next())
                 {
                     st=true;
                 }
             }
             catch(Exception ex)
             {
                 JOptionPane.showMessageDialog(null, ex);
             }
             return st;
         }
}


