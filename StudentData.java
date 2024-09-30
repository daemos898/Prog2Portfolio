import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StudentData {

    public static void main(String[] args) {
        List<Student> studentList = new LinkedList<>();
        try (Scanner scanner = new Scanner(System.in)) {
			// Prompt user for student data entry
			while (true) {
			    System.out.println("Enter student data or 'exit' to close the application:");

			    System.out.print("Name: ");
			    String name = scanner.nextLine();

			    if (name.equalsIgnoreCase("exit")) {
			        break;
			    }

			    System.out.print("Address: ");
			    String address = scanner.nextLine();

			    double GPA;
			    while (true) {
			        System.out.print("GPA: ");
			        try {
			            GPA = Double.parseDouble(scanner.nextLine());
			            if (GPA >= 0 && GPA <= 4.0) {
			                break;
			            } else {
			                System.out.println("Invalid input, GPA must be between 0 and 4");
			            }
			        } catch (NumberFormatException e) {
			            System.out.println("Invalid input, please enter a number");
			        }
			    }

			    studentList.add(new Student(name, address, GPA));
			}
		}

        // Sort the student list by name
        Collections.sort(studentList, (s1, s2) -> s1.getName().compareTo(s2.getName()));

        // Write the sorted student list to a text file
        try (FileWriter writer = new FileWriter("student_data.txt")) {
            for (Student student : studentList) {
                writer.write(student.toString());
            }
            System.out.println("Student data has been written to student_data.txt.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}