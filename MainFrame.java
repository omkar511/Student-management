import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class MainFrame extends JFrame
{
Container c;
JButton btnAdd,btnView,btnUpdate,btnDelete;
MainFrame()
{
c=getContentPane();
c.setLayout(new FlowLayout());
btnAdd=new JButton("Add");
btnView=new JButton("View");
btnUpdate=new JButton("Update");
btnDelete=new JButton("Delete");
c.add(btnAdd);
c.add(btnView);
c.add(btnUpdate);
c.add(btnDelete);

ActionListener a=(ae)->{
AddFrame af=new AddFrame();
dispose();
};
btnAdd.addActionListener(a);

ActionListener a1=(ae)->{
ViewFrame af=new ViewFrame();
dispose();
};
btnView.addActionListener(a1);

ActionListener a2=(ae)->{
UpdateFrame af=new UpdateFrame();
dispose();
};
btnUpdate.addActionListener(a2);

ActionListener a3=(ae)->{
DeleteFrame af=new DeleteFrame();
dispose();
};
btnDelete.addActionListener(a3);

setTitle("Student Management System");
setSize(350,200);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
public static void main(String args[])
{
MainFrame m=new MainFrame();
}
}
class DbHandler
{
public void addStudent(int rno,String name)
{
try
{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
String sql="insert into student values(?,?)";
PreparedStatement pst=con.prepareStatement(sql);
pst.setInt(1,rno);
pst.setString(2,name);
try
{
int r=pst.executeUpdate();
JOptionPane.showMessageDialog(new JDialog(),r + "record inserted");
}
catch(SQLException e)
{
System.out.println("insert issue" + e);
}
con.close();
}
catch(SQLException e)
{
System.out.println("add issue" + e);
}
}

public String viewStudent()
{
StringBuffer sb=new StringBuffer();
try
{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");

String sql="Select * from student";
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery(sql);
while(rs.next())
{
int r=rs.getInt("rno");
String n=rs.getString("name");
sb.append("rno " + r + "name " +n + "\n");
}
rs.close();
con.close();
}
catch(SQLException e)
{
System.out.println("add issue" +e);
}
return sb.toString();
}
public void updateStudent(int rno,String name)
{
try
{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
String s2="update student set name=? where rno=?";
PreparedStatement pst1=con.prepareStatement(s2);
pst1.setInt(2,rno);
pst1.setString(1,name);
try
{
int r1=pst1.executeUpdate();
JOptionPane.showMessageDialog(new JDialog(),r1 + " record updated");
}
catch(SQLException e)
{
System.out.println("insert issue" + e);
}
con.close();
}
catch(SQLException e)
{
System.out.println("update issue" + e);
}
}
public void deleteStudent(int rno)
{
try
{
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection con=DriverManager.getConnection
("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
String s2="delete from student where rno=?";
PreparedStatement pst2=con.prepareStatement(s2);
pst2.setInt(1,rno);
try
{
int r3=pst2.executeUpdate();
JOptionPane.showMessageDialog(new JDialog(),r3 + " record deleted");
}
catch(SQLException e)
{
System.out.println("insert issue" + e);
}
con.close();
}
catch(SQLException e)
{
System.out.println("update issue" + e);
}
}

}





