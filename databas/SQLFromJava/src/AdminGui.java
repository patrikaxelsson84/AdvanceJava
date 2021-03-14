import javax.swing.*;

public class AdminGui extends JFrame {
    private JTextField tf;
    private JTextField Bocker;
    private JTextField Tidsskrifter;
    private JTextField Lantagare;
    private JTextField Anstallda;
    private JPanel jp;
    private JButton Search;
    private String name;

    public AdminGui() {
        name = "-1";
        this.setTitle("SQL - Front");
        this.setSize(800, 800);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jp = new JPanel();
        jp.setLayout(null);

        JButton Search = new JButton("Sök");
        tf = new JTextField("text", 20);

     //   Bocker.setBounds(30, 30, 180, 100);
        Search.setBounds(30, 30,100,30);
        tf.setBounds(30, 150, 180, 100);

        jp.add(Search);
        jp.add(tf);
       // jp.add(Bocker);
       // jp.add(Tidsskrifter);
       // jp.add(Lantagare);

        this.add(jp);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }
}
