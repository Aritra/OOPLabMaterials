public class FDCode extends FDStudent implements CodingClubMember {
    private int codingClubRank;
    private String[] languages;
    public FDCode(String n, String i, String m, String sfp, String std, int cr, String ... l){
        super(n,i,m,sfp,std);
        this.codingClubRank = cr;
        this.languages = l;
    }
    public int memberRank(){
        return this.codingClubRank;
    }
    public String[] languages(){
        return this.languages;
    }
    public void printDetails(){
        String stipendDetails = "";
        if(super.stipend==0)
            stipendDetails = "recieves no scholarship";
        else
            stipendDetails = "recives a scholarship of "+super.stipend+" per month.";
        System.out.println(super.name + " is a FD student with major in "+ this.major + "\n"
                           +"The id of the student is "+super.ID+" and email is "+super.email+"\n"
                           +"The student got "+this.schoolFinalPercentage+"/% marks in 12th and "
                           +stipendDetails+".\nAlso the student is a member of the "+printClubName()
                           +" with known "+Global.printList("programming language", this.languages)
                           +" having a rank of "+this.memberRank()+"\n");
    }
}
