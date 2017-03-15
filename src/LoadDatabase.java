import java.sql.*;

public class LoadDatabase {
    public static final String JDBC = "com.mysql.jdbc.Driver";
    public static final String DB = "jdbc:mysql://localhost/";
    public static final String DBNAME = "TRENING";
    public static final String SSL = "&autoReconnect=true&useSSL=false";
    public static final String USER = "?user=root";
    public static final String PW = "&password=qqq";
    Connection conn = null;
    Statement state = null;
    ResultSet result = null;
    private boolean connectedToDatabase = false;

    public LoadDatabase(){
        try {
            Class.forName(JDBC).newInstance();
            System.out.println("Set up MySQL Connection to DB: TRENING");
            this.connect();
        } catch (Exception ex) {
            ex.printStackTrace();
            this.connectedToDatabase = true;
        }
        if (this.connectedToDatabase){
            this.createDatabase();
        }
    }

    private void connect(){
        try {
            conn = DriverManager.getConnection(DB+DBNAME+USER+PW+SSL);
            System.out.println("Connected to Database TRENING");
        } catch (Exception ex){
            System.out.println("SQLException: " + ex.getMessage());
        }
    }

    private void createDatabase(){
        System.out.println("No database found - Beginning creation process");
        try {
            Class.forName(JDBC);
            System.out.println("Connecting to new database...");
            this.conn = DriverManager.getConnection(DB,"root","root");
            System.out.println("Connection succeeded");
            System.out.println("Creating database...");
            this.state = this.conn.createStatement();
            state.executeUpdate("CREATE DATABASE "+DBNAME);
            System.out.println("Successfully created the database "+this.DBNAME);
        }
        catch (ClassNotFoundException e){e.printStackTrace();}
        catch (SQLException e) {this.SQLEx(e);}
    }

    public void SQLEx(SQLException ex){
        System.out.println("SQL Exception: " + ex.getMessage());
    }
    public void close(){
        if (result!=null){
            try{
                result.close();
            }catch(SQLException ex) {
                System.out.println("Error closing result handler...");
            }
            result = null;
        }
        if (state != null){
            try{
                state.close();
            }catch(SQLException ex){
                System.out.println("Error closing statement handler");
            }
        }
    }

}
