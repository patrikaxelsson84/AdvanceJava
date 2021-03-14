import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Gui extends JFrame {

    private JTextArea taUser;
    private JTextArea taPassword;
    private JPanel jp;
    private String name;
    private JRadioButton admin;
    private JRadioButton anstallda;
    private JRadioButton lantagare;

    Main main = new Main();
    Login login = new Login();

    public Gui() {

        name = "-1";
        this.setTitle("SQL - Front");
        this.setSize(800, 800);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jp = new JPanel();
        jp.setLayout(null);

        taUser = new JTextArea("root");
        taPassword = new JTextArea("123abc123");
        JButton LoginButton = new JButton("Logins");
        admin = new JRadioButton("Admin");
        anstallda = new JRadioButton("Anstalld");
        lantagare = new JRadioButton("Lantagare");


        taUser.setBounds(30, 30, 100, 30);
        taPassword.setBounds(30, 70, 100, 30);
        LoginButton.setBounds(30, 110, 100, 30);
        admin.setBounds(160, 30, 120,20);
        anstallda.setBounds(160, 60, 120,20);
        lantagare.setBounds(160, 90, 120,20);


        admin.addActionListener(e -> {
            anstallda.setSelected(false);
            lantagare.setSelected(false);
        });
        lantagare.addActionListener(e -> {
            anstallda.setSelected(false);
            admin.setSelected(false);
        });
        anstallda.addActionListener(e -> {
            admin.setSelected(false);
            lantagare.setSelected(false);
        });


        LoginButton.addActionListener(e -> {

            if (admin.isSelected()){
               Login.connect(taUser.getText(), taPassword.getText());
            if (login.getCheck()==1){
                AdminGui adminGui = new AdminGui();
                }
            }

            if (anstallda.isSelected()) {
                Login.connect(taUser.getText(), taPassword.getText());
            if (login.getCheck()==1){
                AnstalldGui anstalldGui = new AnstalldGui();
                }
            }

            if (lantagare.isSelected()) {
                Login.connect(taUser.getText(), taPassword.getText());
            if(login.getCheck()==1){
                LantagareGui lantagareGui = new LantagareGui();
                }
            }
        });

        jp.add(taUser);
        jp.add(taPassword);
        jp.add(LoginButton);
        jp.add(admin);
        jp.add(lantagare);
        jp.add(anstallda);


        this.add(jp);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    public String getVal() {
        if (this.name.equals("-1")) {
            return "-1";
        }
        String n = name;
        name = "-1";
        return n;
    }
    public void set(String text) {
        this.taUser.setText("ans: \n" + text);
        this.taPassword.setText("ans: \n" + text);
    }
}