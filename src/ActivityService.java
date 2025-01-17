import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ActivityService {
    public void addActivity(int userId) {
        try (Connection con = DBConnection.getConnection()) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Date (YYYY-MM-DD): ");
            String date = sc.nextLine();
            System.out.println("Enter Workout Duration (minutes): ");
            int workoutDuration = sc.nextInt();
            System.out.println("Enter Calories Burned: ");
            int calories = sc.nextInt();
            System.out.println("Enter Steps Taken: ");
            int steps = sc.nextInt();
            System.out.println("Enter Water Intake (ml): ");
            int water = sc.nextInt();

            String sql = "INSERT INTO activities (user_id, date, workout_duration, calories_burned, steps, water_intake) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, userId);
            pst.setString(2, date);
            pst.setInt(3, workoutDuration);
            pst.setInt(4, calories);
            pst.setInt(5, steps);
            pst.setInt(6, water);

            int rows = pst.executeUpdate();
            if (rows > 0) {
                System.out.println("Activity added successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void viewActivities(int userId) {
        try (Connection con = DBConnection.getConnection()) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Start Date (YYYY-MM-DD): ");
            String startDate = sc.nextLine();
            System.out.println("Enter End Date (YYYY-MM-DD): ");
            String endDate = sc.nextLine();

            String sql = "SELECT * FROM Activities WHERE user_id = ? AND date BETWEEN ? AND ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, userId);
            pst.setString(2, startDate);
            pst.setString(3, endDate);

            ResultSet rs = pst.executeQuery();
            System.out.println("Activity History:");
            while (rs.next()) {
                System.out.println("Date: " + rs.getDate("date") +
                        ", Workout: " + rs.getInt("workout_duration") + " mins, " +
                        "Calories: " + rs.getInt("calories_burned") + ", " +
                        "Steps: " + rs.getInt("steps") + ", " +
                        "Water: " + rs.getInt("water_intake") + " ml");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
