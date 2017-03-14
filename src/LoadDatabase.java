import java.sql.*;

public class LoadDatabase {
    static final String JDBC = "com.mysql.jdbc.Driver";
    static final String DB = "jdbc:mysql://localhost/TRENING";
    static final String SSL = "&autoReconnect=true&useSSL=false";
    static final String USER = "?user=root";
    static final String PW = "&password=qqq";
    Connection conn = null;
    Statement state = null;
    ResultSet result = null;

    public LoadDatabase(){
        try {
            Class.forName(JDBC).newInstance();
            System.out.println("Set up MySQL Connection to DB: TRENING");
            this.connect();
        } catch (Exception ex) { ex.printStackTrace(); }
    }
    private void connect(){
        try {
            conn = DriverManager.getConnection(DB+USER+PW+SSL);
            System.out.println("Connected to Database TRENING");
        } catch (Exception ex){
            System.out.println("SQLException: " + ex.getMessage());
        }
    }
//    private void fetch(String sql, String...columns){
//        try{
//            state = this.conn.createStatement();
////            result = state.executeQuery("select workout_time, duration from workout");
//            result = state.executeQuery(sql);
//            while(result.next()){
////                String dur = result.getString("duration");
//                for (String s:columns) {
//                    System.out.println(result.getString(s));
//                }
//            }
//        }
//        catch (SQLException ex) { this.SQLEx(ex); }
//        finally{ this.close(); }
//    }
//    private void insert(String sql){
//        try{
//            state = this.conn.createStatement();
//            state.executeUpdate(sql);
//        }
//        catch (SQLException ex) { this.SQLEx(ex); }
//    }

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
