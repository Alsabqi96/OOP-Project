import java.util.*;

public class AdvancedSchoolSystem {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<HashMap<String, Object>> schools = new ArrayList<>();
        boolean continueProgram = true;

        while (continueProgram) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add School");
            System.out.println("2. Add Student");
            System.out.println("3. Add Subject and Marks");
            System.out.println("4. Retrieve Marks for a Student in a Subject");
            System.out.println("5. Calculate Average Marks for a Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    schools.add(getSchoolDetails());
                    break;
                case 2:
                    addStudentToSchool(schools);
                    break;
                case 3:
                    addSubjectAndMarksToStudent(schools);
                    break;
                case 4:
                    retrieveMarksForStudentInSubject(schools);
                    break;
                case 5:
                    calculateAverageMarksForStudent(schools);
                    break;
                case 6:
                    continueProgram = false;
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    public static HashMap<String, Object> getSchoolDetails() {
        HashMap<String, Object> school = new HashMap<>();
        System.out.print("Enter school name: ");
        String nameOfSchool = scanner.nextLine();
        System.out.print("Enter school address: ");
        String address = scanner.nextLine();

        school.put("School Name", nameOfSchool);
        school.put("Address", address);
        school.put("Students", new ArrayList<HashMap<String, Object>>());

        System.out.println("School added successfully!");
        return school;
    }

    public static void addStudentToSchool(List<HashMap<String, Object>> schools) {
        System.out.print("Enter school name to add a student: ");
        String schoolName = scanner.nextLine();

        for (HashMap<String, Object> school : schools) {
            if (school.get("School Name").equals(schoolName)) {
                List<HashMap<String, Object>> students = (List<HashMap<String, Object>>) school.get("Students");
                students.add(getStudentDetails());
                System.out.println("Student added successfully!");
                return;
            }
        }
        System.out.println("School not found.");
    }

    public static HashMap<String, Object> getStudentDetails() {
        HashMap<String, Object> student = new HashMap<>();
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter student grade: ");
        String grade = scanner.nextLine();
        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        student.put("Student Name", studentName);
        student.put("Student ID", studentId);
        student.put("Grade", grade);
        student.put("Age", age);
        student.put("Subjects", new ArrayList<HashMap<String, Object>>());

        return student;
    }

    public static void addSubjectAndMarksToStudent(List<HashMap<String, Object>> schools) {
        System.out.print("Enter school name: ");
        String schoolName = scanner.nextLine();
        System.out.print("Enter student ID to add a subject: ");
        String studentId = scanner.nextLine();

        for (HashMap<String, Object> school : schools) {
            if (school.get("School Name").equals(schoolName)) {
                List<HashMap<String, Object>> students = (List<HashMap<String, Object>>) school.get("Students");

                for (HashMap<String, Object> student : students) {
                    if (student.get("Student ID").equals(studentId)) {
                        List<HashMap<String, Object>> subjects = (List<HashMap<String, Object>>) student.get("Subjects");
                        subjects.add(getSubjectDetails());
                        System.out.println("Subject added successfully!");
                        return;
                    }
                }
                System.out.println("Student not found.");
                return;
            }
        }
        System.out.println("School not found.");
    }

    public static HashMap<String, Object> getSubjectDetails() {
        HashMap<String, Object> subject = new HashMap<>();
        System.out.print("Enter subject name: ");
        String subjectName = scanner.nextLine();
        System.out.print("Enter teacher's name: ");
        String teacherName = scanner.nextLine();
        System.out.print("Enter credit hours: ");
        int creditHours = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        List<HashMap<String, Object>> marks = getMarks();
        subject.put("Subject Name", subjectName);
        subject.put("Teacher", teacherName);
        subject.put("Credit Hours", creditHours);
        subject.put("Marks", marks);

        return subject;
    }

    public static List<HashMap<String, Object>> getMarks() {
        List<HashMap<String, Object>> marks = new ArrayList<>();

        while (true) {
            HashMap<String, Object> markDetails = new HashMap<>();
            System.out.print("Enter test name: ");
            String testName = scanner.nextLine();
            System.out.print("Enter marks: ");
            int mark = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            markDetails.put("Test Name", testName);
            markDetails.put("Marks", mark);
            marks.add(markDetails);

            System.out.print("Would you like to add another test mark? (yes/no): ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("no")) {
                break;
            }
        }
        return marks;
    }

    public static void retrieveMarksForStudentInSubject(List<HashMap<String, Object>> schools) {
        System.out.print("Enter School Name: ");
        String schoolName = scanner.nextLine();
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter Subject Name: ");
        String subjectName = scanner.nextLine();

        for (HashMap<String, Object> school : schools) {
            if (school.get("School Name").equals(schoolName)) {
                List<HashMap<String, Object>> students = (List<HashMap<String, Object>>) school.get("Students");

                for (HashMap<String, Object> student : students) {
                    if (student.get("Student ID").equals(studentId)) {
                        List<HashMap<String, Object>> subjects = (List<HashMap<String, Object>>) student.get("Subjects");

                        for (HashMap<String, Object> subject : subjects) {
                            if (subject.get("Subject Name").equals(subjectName)) {
                                System.out.println("Marks Details: " + subject.get("Marks"));
                                return;
                            }
                        }
                        System.out.println("Subject not found.");
                        return;
                    }
                }
                System.out.println("Student not found.");
                return;
            }
        }
        System.out.println("School not found.");
    }

    public static void calculateAverageMarksForStudent(List<HashMap<String, Object>> schools) {
        System.out.print("Enter School Name: ");
        String schoolName = scanner.nextLine();
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();

        for (HashMap<String, Object> school : schools) {
            if (school.get("School Name").equals(schoolName)) {
                List<HashMap<String, Object>> students = (List<HashMap<String, Object>>) school.get("Students");

                for (HashMap<String, Object> student : students) {
                    if (student.get("Student ID").equals(studentId)) {
                        List<HashMap<String, Object>> subjects = (List<HashMap<String, Object>>) student.get("Subjects");

                        int totalMarks = 0;
                        int subjectCount = 0;
                        for (HashMap<String, Object> subject : subjects) {
                            List<HashMap<String, Object>> marks = (List<HashMap<String, Object>>) subject.get("Marks");

                            for (HashMap<String, Object> mark : marks) {
                                totalMarks += (int) mark.get("Marks");
                            }
                            subjectCount += marks.size();
                        }
                        if (subjectCount > 0) {
                            float averageMarks = (float) totalMarks / subjectCount;
                            System.out.println("Average Marks: " + averageMarks);
                        } else {
                            System.out.println("No marks available for calculation.");
                        }
                        return;
                    }
                }
                System.out.println("Student not found.");
                return;
            }
        }
        System.out.println("School not found.");
    }
}








