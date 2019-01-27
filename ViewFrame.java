import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class ViewFrame extends JFrame
{
Container c;
TextArea ta;
JButton btnBack;
ViewFrame()
{
c=getContentPane();
ta=new TextArea(4,40);
c.add(ta);
btnBack=new JButton("Back");
c.add("South",btnBack);
ta.setText(new DbHandler().viewStudent());
ActionListener a=(ae)->{MainFrame af=new MainFrame();dispose();};
btnBack.addActionListener(a);
setTitle("add Student");
setSize(350,200);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
ta.setEditable(false);
}
}
