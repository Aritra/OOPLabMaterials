public class FDCodeRobo extends FDStudent implements CodingClubMember, RoboticsClubMember{
    private int codingClubRank;
    private int roboClubRank;
    private String[] robotTypes;
    private String[] languages;
    public FDCodeRobo(String n, String i, String m, String sfp, String std, int cr, int rr, String[] l,String ... t){
        super(n,i,m,sfp,std);
        this.codingClubRank = cr;
        this.roboClubRank = rr;
        this.languages = l;
        this.robotTypes = t;
    }
    public int memberRank(){
        return this.codingClubRank;
    }
    public int memberRankR(){
        return this.roboClubRank;
    }
    public String[] languages(){
        return this.languages;
    }
    public String[] robotTypes(){
        return this.robotTypes;
    }
}
