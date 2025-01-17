import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UserService {
    public int loginUser() {
        try (Connection con = DBConnection.getConnection()) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Email: ");
            String email = sc.nextLine();
            System.out.println("Enter Password: ");
            String password = sc.nextLine();

            String sql = "SELECT user_id FROM Users WHERE email = ? AND password = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, email);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println("Login Successful!");
                return rs.getInt("user_id");
            } else {
                System.out.println("Invalid Email or Password.");
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void registerUser() {
        try (Connection con = DBConnection.getConnection()) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Name: ");
            String name = sc.nextLine();
            System.out.println("Enter Email: ");
            String email = sc.nextLine();
            System.out.println("Enter Password: ");
            String password = sc.nextLine();

            String sql = "INSERT INTO Users (name, email, password) VALUES (?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, password);

            int rows = pst.executeUpdate();
            if (rows > 0) {
                System.out.println("User registered successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
