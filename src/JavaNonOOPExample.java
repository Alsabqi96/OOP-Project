import java.util.*;

public class JavaNonOOPExample {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<HashMap<String, Object>> schools = getSchools();
        System.out.println(schools);  // Display the entered information (optional)
        scanner.close();
    }

    public static List<HashMap<String, Object>> getSchools() {
        List<HashMap<String, Object>> listOfSchools = new ArrayList<>();

        while (true) {
            HashMap<String, Object> school = getSchoolDetails();

            List<HashMap<String, Object>> students = getStudents();
            school.put("Students", students);

            listOfSchools.add(school);

            System.out.println("Would you like to add another school? (yes/no)");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("no")) {
                break;
            }
        }
        return listOfSchools;
    }

    // Function to get school details
    public static HashMap<String, Object> getSchoolDetails() {
        HashMap<String, Object> school = new HashMap<>();
        System.out.println("Enter school name: ");
        String nameOfSchool = scanner.nextLine();
        System.out.println("Enter school address: ");
        String address = scanner.nextLine();

        school.put("School Name", nameOfSchool);
        school.put("Address", address);
        return school;
    }

    // Function to get list of students for a school
    public static List<HashMap<String, Object>> getStudents() {
        List<HashMap<String, Object>> students = new ArrayList<>();

        while (true) {
            HashMap<String, Object> student = getStudentDetails();

            List<HashMap<String, Object>> subjects = getSubjects();
            student.put("Subjects", subjects);

            students.add(student);

            System.out.println("Would you like to add another student? (yes/no)");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("no")) {
                break;
            }
        }
        return students;
    }

    // Function to get student details
    public static HashMap<String, Object> getStudentDetails() {
        HashMap<String, Object> student = new HashMap<>();
        System.out.println("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.println("Enter student ID: ");
        String studentId = scanner.nextLine();
        System.out.println("Enter student grade: ");
        String grade = scanner.nextLine();
        System.out.println("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        student.put("Student Name", studentName);
        student.put("Student ID", studentId);
        student.put("Grade", grade);
        student.put("Age", age);
        return student;
    }

    // Function to get list of subjects for a student
    public static List<HashMap<String, Object>> getSubjects() {
        List<HashMap<String, Object>> subjects = new ArrayList<>();

        while (true) {
            HashMap<String, Object> subject = getSubjectDetails();

            List<HashMap<String, Object>> marks = getMarks();
            subject.put("Marks", marks);

            subjects.add(subject);

            System.out.println("Would you like to add another subject? (yes/no)");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("no")) {
                break;
            }
        }
        return subjects;
    }

    // Function to get subject details
    public static HashMap<String, Object> getSubjectDetails() {
        HashMap<String, Object> subject = new HashMap<>();
        System.out.println("Enter subject name: ");
        String subjectName = scanner.nextLine();
        System.out.println("Enter teacher's name: ");
        String teacherName = scanner.nextLine();
        System.out.println("Enter credit hours: ");
        int creditHours = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        subject.put("Subject Name", subjectName);
        subject.put("Teacher", teacherName);
        subject.put("Credit Hours", creditHours);
        return subject;
    }

    // Function to get list of marks for a subject
    public static List<HashMap<String, Object>> getMarks() {
        List<HashMap<String, Object>> marks = new ArrayList<>();

        while (true) {
            HashMap<String, Object> markDetails = new HashMap<>();
            System.out.println("Enter test name: ");
            String testName = scanner.nextLine();
            System.out.println("Enter marks: ");
            int mark = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            markDetails.put("Test Name", testName);
            markDetails.put("Marks", mark);

            marks.add(markDetails);

            System.out.println("Would you like to add another test mark? (yes/no)");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("no")) {
                break;
            }
        }
        return marks;
    }
}





