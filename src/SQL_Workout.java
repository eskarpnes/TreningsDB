/**
 * Created by tollef on 14.03.17.
 */
import java.sql.*;

public class SQL_Workout implements SQL {
    LoadDatabase db;
    ResultSet result = null;
    Statement state = null;

    SQL_Workout(LoadDatabase db){
        this.db = db;
        this.result = db.result;
        this.state = db.state;
    }

    @Override
    public String fetch() {
        try {
            state = this.db.conn.createStatement();
            String sql = "select workout_no, workout_date, workout_time, duration, shape, performance from workout";
            result = state.executeQuery(sql);
            while (result.next()) {
                System.out.println(result.getString("workout_no"));
            }
        } catch (SQLException ex) {
            this.db.SQLEx(ex);
        } finally {
            this.db.close();
        }
        return "";
    }

    @Override
    public void insert(String s) {
    }
}
