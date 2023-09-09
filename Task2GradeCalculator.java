import java.util.Scanner;

public class Task2GradeCalculator {
    private int totalSubjects;
    private int totalMarks;
    private double averagePercentage;
    private String grade;
    private static Scanner input = new Scanner(System.in);;

    public Task2GradeCalculator(int totalSubjects) {
        this.totalSubjects = totalSubjects;
        this.totalMarks = 0;
        this.averagePercentage = 0.0;
        takeInput();
        calculateResult();
        showResult();
    }

    public Task2GradeCalculator() {
    } // default constructure

    private void takeInput() {
        for (int i = 1; i <= this.totalSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + i + ": ");
            int marks = input.nextInt();
            this.totalMarks += marks;
        }
    }

    private void calculateResult() {
        this.averagePercentage = (double) this.totalMarks / this.totalSubjects;
        this.grade = this.calculateGrade(this.averagePercentage);
    }

    private String calculateGrade(double percentage) {
        if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else if (percentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    private void showResult() {
        System.out.println("Total Marks: " + this.totalMarks);
        System.out.println("Average Percentage: " + this.averagePercentage + "%");
        System.out.println("Grade: " + this.grade);
    }

    public static void main(String[] args) {

        System.out.print("Enter the number of subjects: ");
        int numSubjects = input.nextInt();
        new Task2GradeCalculator(numSubjects);
    }

}
