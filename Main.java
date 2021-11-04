package gpacalculator;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    /*
    GPA Calculator

    = Total Points / Total Credits
    = Points = Grade Value * Credits
    = A = 4, B= 3
     */


    public static void main(String[] args) {

       Scanner myScan = new Scanner(System.in);


        Integer totalPoints = 0;
        Integer totalCredits = 0;

        boolean moreClasses = false;
        do {

            Integer credits = 0;
            boolean validCredits = true;
            do {
                validCredits = true;
                System.out.println("Enter Number Of Credits: ");
                String creditsString = myScan.nextLine();

                try {
                    credits = Integer.parseInt(creditsString);


                } catch (NumberFormatException e) {
                    //System.out.println(e.getMessage());
                    System.out.println("Please enter a valid integer");
                    validCredits = false;
                }
            } while (!validCredits);


            boolean validGrade = true;
            Integer gradeValue = 0;
            String grade = "";

            do {
                validGrade = true;

                System.out.println("Enter Grade: ");
                grade = myScan.nextLine();

                if (grade.equalsIgnoreCase("A")) {
                    gradeValue = 4;
                } else if (grade.equalsIgnoreCase("B")) {
                    gradeValue = 3;
                } else if (grade.equalsIgnoreCase("C")) {
                    gradeValue = 2;
                } else if (grade.equalsIgnoreCase("D")) {
                    gradeValue = 1;
                } else if (grade.equalsIgnoreCase("F")) {
                    gradeValue = 0;
                } else {
                    System.out.println("You didn't enter a valid grade");
                    validGrade = false;
                }
            } while (!validGrade);

            Integer points = gradeValue * credits;

            totalPoints = totalPoints + points;
            totalCredits = totalCredits + credits;

            System.out.println("Would you like to enter another class? (Y/N)");
            String moreClassesString = myScan.nextLine();

            moreClasses = moreClassesString.equalsIgnoreCase("Y");

        } while (moreClasses);

        Double gpa = Double.valueOf(totalPoints)/Double.valueOf(totalCredits);
        //Integer gpa = totalPoints/totalCredits;

        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("Credits: " + totalCredits);
       // System.out.println("Grade: " + grade);
        System.out.println("Points: " + totalPoints);
        System.out.println("GPA: " + df.format(gpa));

        myScan.close();
    }
}
