import java.sql.*;
import java.util.Scanner;

public class Portfolio2JDBC {

    public static void main(String[] args) {
        System.out.println("Type 1 for get average grade for student\nType 2 for get average grade for course");

        // Creating a scanner object, to detect when there is an user input
        Scanner oneortwo = new Scanner(System.in);

        // Checking for user input
        String choosePath = oneortwo.nextLine();

        // Checking if the user input is 1 or 2
        if (choosePath.equals("1")) {
            getAverageStudentGrade();
        }
        else if (choosePath.equals("2")) {
            getAverageCourseGrade();
        }
        else {
            System.out.println("Told you to type 1 or 2");
        }
    }

    private static void getAverageStudentGrade() {

        //
        Connection connect = null;
        // Location for database
        String url = "jdbc:sqlite:/Users/awork/Documents/Portfolio2Database/SqlDatabase.sqlite";

        try {
            //connects to the database
            connect = DriverManager.getConnection(url);

            //
            Statement statement = connect.createStatement();

            //Uses scanner again to read the user input
            System.out.println("Type in the ID for the student, you want the average grade from");
            Scanner scanner = new Scanner(System.in);
            int studentID = scanner.nextInt();

            // String containing the SQL syntax for average grade for student
            String queryStudent = "SELECT AVG(gradeResult) FROM grade WHERE studentID =" + studentID;

            //Executes the statement
            ResultSet result = statement.executeQuery(queryStudent);

            // Only happens when the user input is 1 - 10
            if (studentID >= 1 && studentID <= 10) {
                System.out.print("The average grade for the student is: ");

                //Den tager den første (og eneste i dette tilfæde) række i ens SQL statement og behandler det som en float
                // it takes the first row in the sql statement and handle it as a float
                System.out.println(result.getFloat(1));

            } else {
                System.out.println("Can't find the entered student ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void getAverageCourseGrade() {
        Connection connection = null;
        String url = "jdbc:sqlite:/Users/awork/Documents/Portfolio2Database/SqlDatabase.sqlite";

        try {
            connection = DriverManager.getConnection(url);
            //
            Statement stat = connection.createStatement();

            System.out.println("Type in the ID for the course, you want the average grade from");
            System.out.println("1: SD 2019\n2: SD 2020\n3: ES1 2019");
            Scanner scan = new Scanner(System.in);
            int courseID = scan.nextInt();

            // String containing the SQL syntax for average grade for courses
            String queryCourse = "SELECT AVG(gradeResult) FROM grade WHERE courseID =" + courseID;

            //
            ResultSet resultCourse = stat.executeQuery(queryCourse);

            //// Only happens when the user input is 1 -3
            if(courseID >= 1 && courseID <=3) {
                System.out.print("The average grade for the course is: ");
                System.out.println(resultCourse.getFloat(1));
            } else {
                System.out.println("Can't find the entered course ID");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}