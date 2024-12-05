package studentmanagementapp;

import java.util.ArrayList;
import java.util.List;

// Class Student
class Student {
    private String id;
    private String name;
    private double marks;

    public Student(String id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public String getRanking() {
        if (marks < 5.0) return "Fail";
        else if (marks < 6.5) return "Medium";
        else if (marks < 7.5) return "Good";
        else if (marks < 9.0) return "Very Good";
        else return "Excellent";
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setMarks(double newMarks) {
        this.marks = newMarks;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks + ", Ranking: " + getRanking();
    }
}

// Class StudentManager
class StudentManager {
    private List<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(String id, String name, double marks) {
        Student student = new Student(id, name, marks);
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void editStudent(String id, String newName, double newMarks) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                student.setName(newName);
                student.setMarks(newMarks);
                break;
            }
        }
    }

    public void deleteStudent(String id) {
    for (int i = 0; i < students.size(); i++) {
        if (students.get(i).getId().equals(id)) {
            students.remove(i);
            break;
        }
    }
}
// Search Student by ID
public Student searchStudentById(String id) {
    for (Student student : students) {
        if (student.getId().equalsIgnoreCase(id)) {
            return student;
        }
    }
    System.out.println("No student found with ID: " + id);
    return null;
}

// Search Students by Name
public List<Student> searchStudentsByName(String name) {
    List<Student> matchingStudents = new ArrayList<>();
    for (Student student : students) {
        if (student.getName().equalsIgnoreCase(name)) {
            matchingStudents.add(student);
        }
    }
    if (matchingStudents.isEmpty()) {
        System.out.println("No students found with the name: " + name);
    }
    return matchingStudents;
}

    public void bubbleSortByMarks() {
        for (int i = 0; i < students.size() - 1; i++) {
            for (int j = 0; j < students.size() - 1 - i; j++) {                       
                if (students.get(j).getMarks() > students.get(j + 1).getMarks()) {
                    // Swap students
                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
    }

    public void mergeSortByName() {
        students = mergeSort(students);
    }
    private List<Student> mergeSort(List<Student> list) {
        if (list.size() <= 1) {
            return list;
        }
        int mid = list.size() / 2;
        List<Student> left = mergeSort(list.subList(0, mid));
        List<Student> right = mergeSort(list.subList(mid, list.size()));
        return merge(left, right);
    }
    private List<Student> merge(List<Student> left, List<Student> right) {
        List<Student> merged = new ArrayList<>();
        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getName().compareTo(right.get(j).getName()) <= 0) {
                merged.add(left.get(i));
                i++;
            } else {
                merged.add(right.get(j));
                j++;
            }
        }
        
        while (i < left.size()) {
            merged.add(left.get(i));
            i++;
        }
        while (j < right.size()) {
            merged.add(right.get(j));
            j++;
        }
        return merged;
    }

    public void printStudents() {
    if (students.isEmpty()) {
        System.out.println("No students in the list to display.");
    } else {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
}
