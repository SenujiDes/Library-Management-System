public class Member {
    private String memberName;
    private int memberId;

    Member(String _memberName, int _regNUm){
        memberName=_memberName;
        memberId=_regNUm;
    }

    //setters
    public void setMemberName(String _memberName){
        memberName=_memberName;
    }

    public void setRegNum(int _regNum){
        memberId=_regNum;
    }

     //getters
     public String getMemberName(){
        return memberName;
    }

    public int getMemberID(){
        return memberId;
    }

    public void registered_members(){
        System.out.println("Memeber name         :" + memberName);
        System.out.println("registration number  : " + memberId);
        System.out.println("______________________________________________");
        System.out.println();
    }


}
