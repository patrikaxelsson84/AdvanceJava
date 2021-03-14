import javax.swing.*;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LantagareGui extends JFrame {

    private JPanel jp;
    private JButton SearchBok;
    private JTextPane tfSearchBok;
    private JTextArea taSearchBok;
    private JButton SearchTidsskrift;
    private JTextPane tfSearchTidsskrift;
    private JTextArea taSearchTidsskrift;
    private JButton buttonlana;
    private JButton buttonlamna;
    private JRadioButton Utlanad;
    private JRadioButton Hemma;
    private JTextField Bocker;
    private JTextField Tidsskrifter;

    private String name;
    private String ans;

    public LantagareGui() {
        name = "-1";
        this.setTitle("SQL - Front");
        this.setSize(800, 800);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jp = new JPanel();
        jp.setLayout(null);

        SearchBok = new JButton("Sök Bok");
        taSearchBok = new JTextArea("");
        tfSearchBok = new JTextPane();
        SearchTidsskrift = new JButton("Sök tidsskrift");
        taSearchTidsskrift = new JTextArea("");
        tfSearchTidsskrift = new JTextPane();
        buttonlana = new JButton("Låna");
        buttonlamna = new JButton("Lämna tillbaka");
        Utlanad = new JRadioButton("Utlanad");
        Hemma = new JRadioButton("Hemma");

        tfSearchBok.setContentType("text/html");
        tfSearchTidsskrift.setContentType("text/html");

        //   Bocker.setBounds(30, 30, 180, 100);
        SearchBok.setBounds(20, 20,120,30);
        taSearchBok.setBounds(20, 60,120,30);
        tfSearchBok.setBounds(20, 100, 220, 80);
        SearchTidsskrift.setBounds(270, 20,120,30);
        taSearchTidsskrift.setBounds(270, 60,120,30);
        tfSearchTidsskrift.setBounds(270, 100, 220, 80);
        buttonlana.setBounds(20, 300, 80, 20);
        buttonlamna.setBounds(100, 300, 80, 20);
        Utlanad.setBounds(20, 220, 90,20);
        Hemma.setBounds(20, 250, 90,20);

        jp.add(SearchBok);
        jp.add(taSearchBok);
        jp.add(tfSearchBok);
        jp.add(SearchTidsskrift);
        jp.add(taSearchTidsskrift);
        jp.add(tfSearchTidsskrift);
        jp.add(buttonlana);
        jp.add(buttonlamna);
        jp.add(Utlanad);
        jp.add(Hemma);
        // jp.add(Tidsskrifter);
        // jp.add(Lantagare);

        buttonlana.addActionListener(e -> {
         //   int bokId =0;
         //   int låntagareId=0;

            PreparedStatement stmt = null;
            try {
                stmt = Login.connection.prepareStatement
                        ("INSERT INTO lån (låntagare, bokid, start_datum, slut_datum) VALUES (?, ?, ?, NULL)");
                stmt.setInt(1, Login.getLåntagarID());
                stmt.setInt(2, Integer.parseInt(taSearchBok.getText()));
          //      stmt.setInt(3, bokId);
                stmt.setDate(3, new Date(System.currentTimeMillis()));
          //      stmt.setString(4,"UPDATE LånadeBöcker.låntagare SET LånadeBöcker = LånadeBöcker + 1, WHERE BookID = ?");
                stmt.executeUpdate();
          //      ResultSet rs = stmt.executeQuery();
        //        {
        //            stmt = Login.getConnection().prepareStatement("UPDATE Böcker SET  Utlånad = ? WHERE LånId = ?");
        //            stmt.setInt(1, Integer.parseInt(taSearchBok.getText()));
        //            stmt.setInt(2, Login.utlanad);
        //        }
                {
                    stmt = Login.getConnection().prepareStatement("UPDATE Låntagare SET  LånadeBöcker = ? WHERE  LåntagareID = ?");

                    stmt.setInt(1, Integer.parseInt(taSearchBok.getText()));
         //           stmt.setInt(2, Login.utlanad);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

        buttonlamna.addActionListener(e -> {
            int lanId = 0;

            PreparedStatement stmt = null;
            try {
                stmt = Login.connection.prepareStatement
                        ("UPDATE lån SET slut_datum=? WHERE id=?");

                stmt.setDate(1, new Date(System.currentTimeMillis()));
                stmt.setInt(2, Login.hemma);

                stmt.executeUpdate();
              //  ResultSet rs = stmt.executeQuery();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        });
        tfSearchTidsskrift.setText("sads");
        SearchBok.addActionListener(e -> {
            try {
                PreparedStatement stmt = Login.connection.prepareStatement("select * from böcker where Titel = ?");
                stmt.setString(1,taSearchBok.getText().trim());


                ResultSet rs = stmt.executeQuery();
                String answer = "<html>";

                while (rs.next()) {
                    answer += "<br>"+ (rs.getInt(1) + "  " + rs.getString(2) + " <br> " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5)+"");
                    System.out.println("---------");
                }
                answer+="</html>";
                tfSearchBok.setText(answer);

                System.out.println("----");

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }});

        SearchTidsskrift.addActionListener(e -> {
        try {
            PreparedStatement stmt = Login.connection.prepareStatement("select * from tidsskrifter where Titel = ?");
            stmt.setString(1,taSearchTidsskrift.getText().trim());
            ResultSet rs = stmt.executeQuery();
            String answer = "<html>";


            while (rs.next()) {
                answer += "<br>"+ (rs.getInt(1) + "  " + rs.getString(2) + " <br> " + rs.getDate(3) + " " + rs.getString(4));
                System.out.println("---------");
            }
            System.out.println("sök"+taSearchTidsskrift.getText());
            System.out.println(answer);
            answer+="</html>";
            tfSearchTidsskrift.setText(answer);
            System.out.println(answer);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }});


        this.add(jp);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }
}