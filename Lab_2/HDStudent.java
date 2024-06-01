public class HDStudent extends BITSStudent{
    String major;
    double schoolFinalPercentage;
    double graduationCGPA;

    public void setQualification(String q) {
        String[] qArr = Global.getCGPAs(q);
        this.schoolFinalPercentage = Double.parseDouble(qArr[0]);
        this.graduationCGPA = Double.parseDouble(qArr[1]);
    }

    public void setScholarship(String stipendClass) {
        if (stipendClass.equals("PG"))
            super.stipend = 12000;
        else if (stipendClass.equals("PGGate"))
            super.stipend = 12500;
        else
            super.stipend = Integer.parseInt(stipendClass);
    }
    public void printDetails(){
        String stipendDetails = "";
        if(super.stipend==0)
            stipendDetails = "recieves no scholarship";
        else
            stipendDetails = "recives a scholarship of "+super.stipend+" per month.";
        System.out.println(super.name + " is a HD student with major in "+ this.major + "\n"
                           +"The id of the student is "+super.ID+" and email is "+super.email+"\n"
                           +"The student got "+this.schoolFinalPercentage+"/% marks in 12th and "
                           +this.graduationCGPA+" CGPA in graduation and "
                           +stipendDetails+"\n");
    }

    public HDStudent(String name, String ID, String major, String sfP, String stipend){
        super.name = name;
        super.ID = ID;
        super.email = "h"+ID+"@hyderabad.bits-pilani.ac.in";
        this.major = major;
        setScholarship(stipend);;
        setQualification(sfP);
    }
}
