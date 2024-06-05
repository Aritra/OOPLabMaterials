public interface CodingClubMember {
    default String printClubName(){
        return "The coding club called Crux";
    }
    public int memberRank();
    public String[] languages();
}
