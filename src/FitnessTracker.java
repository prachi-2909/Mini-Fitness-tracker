import java.util.Scanner;

public class FitnessTracker {
    public static void main(String[] args) {
        UserService userService = new UserService();
        ActivityService activityService = new ActivityService();
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Register");
        System.out.println("2. Login");
        int choice = sc.nextInt();
        sc.nextLine();

        int userId = -1;
        if (choice == 1) {
            userService.registerUser();
        } else if (choice == 2) {
            userId = userService.loginUser();
        }

        if (userId > 0) {
            while (true) {
                System.out.println("\n1. Add Activity");
                System.out.println("2. View Activities");
                System.out.println("3. Logout");
                choice = sc.nextInt();
                sc.nextLine();

                if (choice == 1) {
                    activityService.addActivity(userId);
                } else if (choice == 2) {
                    activityService.viewActivities(userId);
                } else if (choice == 3) {
                    System.out.println("Logged out.");
                    break;
                }
            }
        }
    }
}
