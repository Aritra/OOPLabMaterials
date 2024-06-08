import java.util.ArrayList;
import java.util.List;

public class Course {
    private String name;
    private String code;
    private boolean isCDC;
    private boolean hasLab;
    private int credits;
    private List<BITSStudent> registeredStudents;
    public Course(String name, String code, boolean isCDC, boolean haslab, int credits){
        this.name = name;
        this.code = code;
        this.isCDC = isCDC;
        this.hasLab = haslab;
        this.credits = credits;
        registeredStudents = new ArrayList<BITSStudent>();
    }
    public void addStudent(BITSStudent std){
        this.registeredStudents.add(std);
    }
    public List<BITSStudent> getStudentList(){
        return this.registeredStudents;
    }
    public String getName() {
        return this.name;
    }
    public String getCode() {
        return this.code;
    }
    public int getCredits() {
        return this.credits;
    }
    public boolean isCDC() {
        return this.isCDC;
    }
    public boolean hasLab(){
        return this.hasLab;
    }

}
