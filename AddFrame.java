import java.util.regex.Pattern;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class AddFrame extends JFrame
{
Container c;
JLabel lblRno,lblName;
JTextField txtRno,txtName;
JButton btnSave,btnBack;
JPanel p1,p2;
AddFrame()
{
c=getContentPane();
c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));
p1=new JPanel();
lblRno=new JLabel("enter rno");
txtRno=new JTextField(3);
lblName=new JLabel("enter name");
txtName=new JTextField(10);
p1.add(lblRno);
p1.add(txtRno);
p1.add(lblName);
p1.add(txtName);
c.add(p1);
p2=new JPanel();
btnSave=new JButton("Save");
btnBack=new JButton("Back");
p2.add(btnSave);
p2.add(btnBack);
c.add(p2);
ActionListener a=(ae)->{MainFrame af=new MainFrame();dispose();};
btnBack.addActionListener(a);
ActionListener a1=(ae)->{
int k=0;
String r=txtRno.getText();
try{
k=Integer.parseInt(r);
}
catch(NumberFormatException e)
{
JOptionPane.showMessageDialog(c,"only numbers allowed in rno");
}
if(k<0)
{
JOptionPane.showMessageDialog(c,"positive numbers onlys");
}
else{
String n=txtName.getText();
if(!(Pattern.matches("[a-zA-Z]+",n)))
{
JOptionPane.showMessageDialog(c,"only alphabets allowed in name");
}
else
{
DbHandler db=new DbHandler();
try{
db.addStudent(Integer.parseInt(r),n);
txtRno.setText("");
txtName.setText("");
}
catch(NumberFormatException e)
{
//JOptionPane.showMessageDialog(c,"only numbers allowed in rno");
}
}
}
};
btnSave.addActionListener(a1);
setTitle("add Student");
setSize(350,200);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}

