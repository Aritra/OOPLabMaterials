public class FDCodeRobo extends FDStudent implements CodingClubMember, RoboticsClubMember{
    private int codingClubRank;
    private int roboClubRank;
    private String[] robotTypes;
    private String[] languages;
    public FDCodeRobo(String n, String i, Major m, String sfp, String std, int cr, int rr, String[] l,String ... t){
        super(n,i,m,sfp,std);
        this.codingClubRank = cr;
        this.roboClubRank = rr;
        this.languages = l;
        this.robotTypes = t;
    }
    
    public FDCodeRobo(String n, String i, Major m, String sfp, String std, String crandrr, String[] l,String ... t){
        super(n,i,m,sfp,std);
        String[] ranks = crandrr.split(",");
        this.codingClubRank = Integer.parseInt(ranks[0]);
        this.roboClubRank = Integer.parseInt(ranks[1]);
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
