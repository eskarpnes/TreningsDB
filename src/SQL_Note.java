///**
// * Created by tollef on 14.03.17.
// */
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//
//public class SQL_Note implements SQL {
//    LoadDatabase db;
//    ResultSet result = null;
//    Statement state = null;
//    ArrayList<Note> notes;
//
//    SQL_Note(LoadDatabase db){
//        this.notes = new ArrayList<>();
//        this.db = db;
//        this.result = db.result;
//        this.state = db.state;
//    }
//
//    public ArrayList<Workout> getWorkouts(){
//        return this.workouts;
//    }
//
//    @Override
//    public String fetch() {
//        try {
//            state = this.db.conn.createStatement();
//            String sql = "select workout_no, " +
//                    "workout_date, workout_time, " +
//                    "duration, shape, performance from workout";
//            result = state.executeQuery(sql);
//            while (result.next()) {
//                this.notes.add(new Workout(_num, _date, _time, _dur, _shape, _perf));
//            }
//        } catch (SQLException ex) {
//            this.db.SQLEx(ex);
//        } finally {
//            this.db.close();
//        }
//        return "";
//    }
//
//    @Override
//    public void insert(String s) {
//    }
//}
