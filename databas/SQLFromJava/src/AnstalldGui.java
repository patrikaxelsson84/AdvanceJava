import javax.swing.*;

public class AnstalldGui extends JFrame {

    private JButton SearchBok;
    private JTextPane tfSearchBok;
    private JTextArea taSearchBok;
    private JButton SearchLantagare;
    private JTextArea taSearchLantagare;
    private JTextPane tfSearchLantagare;
    private JTextField Bocker;
    private JTextField Tidsskrifter;
    private JTextField Lantagare;
    private JPanel jp;
    private String name;

    public AnstalldGui() {


        name = "-1";
        this.setTitle("SQL - Front");
        this.setSize(800, 800);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jp = new JPanel();
        jp.setLayout(null);

        SearchBok = new JButton("Sök Bok");
        taSearchBok = new JTextArea("");
        tfSearchBok = new JTextPane();
        SearchLantagare = new JButton("Sök Låntagare");
        taSearchLantagare = new JTextArea("");
        tfSearchLantagare = new JTextPane();

        Bocker = new JTextField("text", 20);

        tfSearchBok.setContentType("text/html");
        tfSearchLantagare.setContentType("text/html");

        SearchBok.setBounds(20, 20,120,30);
        tfSearchBok.setBounds(20, 100, 180, 60);
        SearchLantagare.setBounds(270, 20,120,30);
        tfSearchLantagare.setBounds(270, 100,180,60);
        Bocker.setBounds(20, 170, 180, 80);

        jp.add(SearchBok);
        jp.add(taSearchBok);
        jp.add(tfSearchBok);
        jp.add(SearchLantagare);
        jp.add(taSearchLantagare);
        jp.add(tfSearchLantagare);
        jp.add(Bocker);

        this.add(jp);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }
}
