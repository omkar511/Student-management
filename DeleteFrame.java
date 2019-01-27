import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class DeleteFrame extends JFrame
{
Container c;
JLabel lblRno;
JTextField txtRno;
JButton btnSave,btnBack;
JPanel p1,p2;
DeleteFrame()
{
c=getContentPane();
c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));
p1=new JPanel();
lblRno=new JLabel("enter rno");
txtRno=new JTextField(3);
p1.add(lblRno);
p1.add(txtRno);
c.add(p1);
p2=new JPanel();
btnSave=new JButton("Delete");
btnBack=new JButton("Back");
p2.add(btnSave);
p2.add(btnBack);
c.add(p2);
ActionListener a=(ae)->{MainFrame af=new MainFrame();dispose();};
btnBack.addActionListener(a);

ActionListener a1=(ae)->{
String r=txtRno.getText();
DbHandler db=new DbHandler();
try{
db.deleteStudent(Integer.parseInt(r));
txtRno.setText("");
}
catch(NumberFormatException e)
{
JOptionPane.showMessageDialog(c,"only numbers allowed in rno");
}
};
btnSave.addActionListener(a1);
setTitle("Delete Student");
setSize(350,200);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}

