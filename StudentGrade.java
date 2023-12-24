import java.util.Scanner;

public class StudentGrade {
    public static void main(String[] agrs){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWelcome To Student Result Valuation In Grade System...!");
        System.out.print("Enter Student Name :- ");
        String StudentName = scanner.nextLine();
        System.out.print("Enter Roll Number :- ");
        int rollno = scanner.nextInt();
        System.out.print("Enter Total Number of Subjects :-");
        int totalSubjects = scanner.nextInt();
        int subjectMarks;
        int totalMarks = 0;
        System.out.println("\nEnter marks obtained out of 100 in each subject :-");
        
        for(int i=1 ;i <= totalSubjects; i++) {
            System.out.print("Enter Marks For Subject - "+ ( i ) + " :- ");
            subjectMarks = scanner.nextInt();
            totalMarks += subjectMarks;
        }
        System.out.println();
        System.out.println("Total Marks :-" +totalMarks+"/"+totalSubjects*100);
        float avgPercent = (float) totalMarks / totalSubjects ;
        System.out.println("Average Percent :-"+String.format("%.2f",avgPercent)+"%");

        char grade;

        if (avgPercent >= 80 && avgPercent <= 100){
            grade ='O';
        }
        else if (avgPercent >= 70 && avgPercent <=79){
            grade ='A';
        }
        else if (avgPercent >= 60 && avgPercent <=69) {
            grade ='B';
        }
        else if (avgPercent >= 55 && avgPercent <=59) {
            grade ='C';
        }
        else if (avgPercent >= 50 && avgPercent <=54) {
            grade ='D';
        }
        else if (avgPercent >= 45 && avgPercent <=49) {
            grade ='E';
        }
        else if (avgPercent >= 40 && avgPercent <=44) {
            grade ='P';
        }
        else {
            grade ='F';
        }
        System.out.println("Grade :- " +grade);

        displayResults(StudentName ,rollno , totalMarks , avgPercent , grade);
        scanner.close(); 
    } 

    public static void displayResults(String StudentName ,int rollno , int totalMarks, double avgPercent, char grade){
        System.out.println();
        System.out.println("Result Valuation Of " + StudentName + " Having Roll No. - " +rollno );
        System.out.println("----------------------------------------------------------");
        System.out.println("                   Result Of "+ StudentName                   );
        System.out.println("----------------------------------------------------------");
        System.out.println("Total_Marks" + "\t|     Average_Percent" + "\t|\tGrade      ");
        System.out.println("----------------------------------------------------------");
        System.out.println( totalMarks + "\t\t\t  " + String.format("%.2f",avgPercent)+" % " + "\t\t" + grade);
        System.out.println("----------------------------------------------------------");
        
    } 
}
