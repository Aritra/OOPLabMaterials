public abstract class BITSStudent {
    String name;
    String ID;
    String email;
    String qualification;
    int stipend;
    Major major;
    double schoolFinalPercentage;
    public abstract void setQualification(String q); 
    public abstract void setScholarship(String stipendClass);
    public abstract void printDetails();
}
