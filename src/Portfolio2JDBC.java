
import java.sql.*;
import java.util.Scanner;

public class Portfolio2JDBC {

    public static void main(String[] args) {
        System.out.println("1 or 2");
Scanner oneortwo = new Scanner(System.in);
String choosePath = oneortwo.nextLine();


if (choosePath.equals("1")) {
    getAverageStudentGrade();
        }

else if (choosePath.equals("2")) {
    getAverageCourseGrade();
}
}

    private static void getAverageStudentGrade() {
        //
        Connection connect = null;
        String url = "jdbc:sqlite:/Users/awork/Documents/Portfolio2Database/SqlDatabase.sqlite";

        try {
            connect = DriverManager.getConnection(url);
            //
            Statement statement = connect.createStatement();
            System.out.println("Type in the studentID");
            Scanner scanner = new Scanner(System.in);
            int studentID = scanner.nextInt();

            //
            String query = "SELECT AVG(gradeResult) FROM grade WHERE studentID =" + studentID;

            //
            ResultSet result = statement.executeQuery(query);

            //
            if (studentID >= 1 && studentID <= 10) {
                System.out.println(result.getFloat(1));
            } else {
                System.out.println("Can´t find studentID");
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
            System.out.println("Type in the coureID");
            Scanner scan = new Scanner(System.in);
            int courseID = scan.nextInt();

            //
            String queryCourse = "SELECT AVG(gradeResult) FROM grade WHERE courseID =" + courseID;

            //
            ResultSet resultCourse = stat.executeQuery(queryCourse);

            //
            /*
            if (courseID >= 1 && courseID <= 10) {
                System.out.println(resultCourse.getFloat(1));
            } else {
                System.out.println("Can´t find CourseID");
            }

             */
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}