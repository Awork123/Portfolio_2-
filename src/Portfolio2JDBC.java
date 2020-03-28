
import java.sql.*;
import java.util.Scanner;

public class Portfolio2JDBC {

    public static void main(String[] args) {

    }

    private static void getAverageStudentGrade() {
        //
        Connection connect = null;
        String url = "jdbc:sqlite:CoursePort.sqlite";

        try {
            connect = DriverManager.getConnection(url);
            //
            Statement statement = connect.createStatement();
            System.out.println("Type in the studentID");
            Scanner scanner = new scanner.nextInt();

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

    }
}