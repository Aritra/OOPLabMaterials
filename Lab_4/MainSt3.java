import java.util.Scanner;

public class MainSt3 {
    public static void main(String[] args) {
        BITSStudent studentBand[] = new BITSStudent[7];
        studentBand[0] = new FDStudent("Noori", "2020PS4576H", Major.Computer_Science, "96", "2000");
        studentBand[1] = new FDCode("Rohit", "2020PS9876H", Major.Mechanical, "98", "UGNS",3,"C","C++","python");
        studentBand[2] = new FDCodeRobo("Sayani", "2020PS3645H", Major.Mechanical, "94", "UG",2,3,new String[]{"C","Matlab"},"Drones","humanoids");
        studentBand[3] = new HDStudent("Maya", "2023TS7656H", "CS", "92,8.45", "PG");
        studentBand[4] = new HDStudent("Kalki", "2023TS8765H", "EC", "91,7.92", "PGGate");
        studentBand[5] = new HDStudent("Harsh", "2023TS3517H", "Math", "97,9.4", "20000");
        studentBand[6] = new FDCodeRobo("Joseph", "2020PS9988H", Major.Computer_Science, "94", "UG","1,2",new String[]{"C","Python"},"Drones","Submarines");
        Course ml = new Course("Machine Learning", "BITS F441", false, false, 3);
        Course oop = new Course("Object Oriented Programming", "CS F213", true, true, 4);
        
        ml.addStudent(studentBand[0]);
        ml.addStudent(studentBand[1]);
        oop.addStudent(studentBand[0]);
        oop.addStudent(studentBand[3]);
        
        Scanner sc = new Scanner(System.in);
        System.out.println("What name do you want?");
        String key = sc.nextLine();
        Boolean found = false;
        for(BITSStudent student:studentBand){
            if(!found){
                if(key.equalsIgnoreCase(student.name)){
                    System.out.println("The student details are: \n");
                    student.printDetails();
                    found = true;
                    continue;
                }
            }
        }
        if(!found){
            System.out.println("Sorry this student does not exist!");
        }

        System.out.println("\n\nThe Course Student Lists are:");
        System.out.println("*****" + ml.getName() + "*****");
        for(BITSStudent bts:ml.getStudentList())
            System.out.println(bts.name);
        System.out.println("\n*****" + oop.getName() + "*****");
        for(BITSStudent bts:oop.getStudentList())
            System.out.println(bts.name);
    }
}


