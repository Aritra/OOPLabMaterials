public interface RoboticsClubMember {
    default String printRClubName(){
        return "The robotics club called Asimov";
    }
    public int memberRankR();
    public String[] robotTypes();
}
