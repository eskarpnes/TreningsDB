/**
 * Created by tollef on 14.03.17.
 */
import java.sql.*;
import java.util.ArrayList;

public class SQL_Workout implements SQL {
    LoadDatabase db;
    ResultSet result = null;
    Statement state = null;
    ArrayList<Workout> workouts;

    SQL_Workout(LoadDatabase db){
        this.workouts = new ArrayList<>();
        this.db = db;
        this.result = db.result;
        this.state = db.state;
    }

    public ArrayList<Workout> getWorkouts(){
        return this.workouts;
    }
    
    @Override
    public void fetch() {
        try {
            state = this.db.conn.createStatement();
            String sql = "select workout_no, " +
                    "workout_date, workout_time, " +
                    "duration, shape, performance from workout";
            result = state.executeQuery(sql);
            while (result.next()) {
                int _num = result.getInt("workout_no");
                String _date = result.getString("workout_date");
                String _time = result.getString("workout_time");
                int _dur = result.getInt("duration");
                int _shape = result.getInt("shape");
                int _perf = result.getInt("performance");
                this.workouts.add(new Workout(_num, _date, _time, _dur, _shape, _perf));
            }
        } catch (SQLException ex) {
            this.db.SQLEx(ex);
        } finally {
            this.db.close();
        }
    }

    @Override
    public void insert(String s) {
    }
}
