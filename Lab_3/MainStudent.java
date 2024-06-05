public class MainStudent {
    public static void main(String args[]) {
        Student students[] = new Student[4];
        students[0] = new Student("Simran", "2020PS1934H", 8.65, new Address("29/4 Khao Gali", "400001", "Mumbai", "Maharashtra"));
        students[1] = new Student("Raj", "2020PS8695H", 8.24, new Address("81/5/6 Mayur Vihar", "110001", "Delhi", "Delhi"));
        students[2] = new Student("Rahul", "2020PS6932P", 7.21, new Address("33/4 Lalbazar", "700001", "Kolkata", "West Bengal"));
        students[3] = new Student("Soniya", "2020PS1748P", 9.2, new Address("78/2 Nampally", "540001", "Hyderabad", "Telengana"));
        System.out.println("ID\t\tName\t\tCGPA\t\tPincode");
        for (Student s : students) {
            System.out.printf("%s\t%s\t\t%.2f\t\t%s\n",s.getID(),s.getName(),s.getCGPA(),s.getStudentPincode());
        }
    }
}
