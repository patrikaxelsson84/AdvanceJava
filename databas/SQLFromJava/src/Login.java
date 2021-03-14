import java.sql.*;

public class Login {
    public static Connection connection;
    private static int Check=0;
    public static final int utlanad = 0;
    public static final int hemma = 0;

    public static String username;

public static Connection getConnection(){
    return connection;
}
    public static Connection connect(String username, String password){
        Login.username = username;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/inlämning2", username, password);
            Check = 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
    public int getCheck(){
        return Check;
    }
    public static int getLåntagarID() {
        try {
            PreparedStatement stmt = Login.connection.prepareStatement("select LåntagareID from låntagare where Namn = ?");
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            String answer = "<html>";
            answer += "</html>";
          //  tfSearchBok.setText(answer);
            System.out.println("----");

            if(rs.next()){
                return rs.getInt(1);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return-1;
    }
}
