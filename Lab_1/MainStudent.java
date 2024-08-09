public class MainStudent {
    public static void main(String args[]) {
        Student students[] = new Student[6];
        students[0] = new Student("Simran", "2020PS1934H", 8.65);
        students[1] = new Student("Raj", "2020PS8695H", 8.24);
        students[2] = new Student("Rahul", "2020PS6932P", 7.21);
        students[3] = new Student("Soniya", "2020PS1748P", 9.2);
        students[4] = new Student("Veer", "2020PS3874G", 8.7);
        students[5] = new Student("Zaara", "2020PS3225G", 8.7);
        System.out.println("ID\t\tName\t\tCGPA");
        for (Student s : students) {
            System.out.printf("%s\t%s\t\t%.2f\n",s.ID,s.name,s.CGPA);
        }
    }
}
