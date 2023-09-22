package Exam;

public class Member {

    private String memberId ;
    private String memberPassword ;
    private String nickName ;

    public Member(String memberId, String memberPassword, String nickName){
        this.memberId = memberId;
        this.memberPassword = memberPassword;
        this.nickName = nickName;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberPassword() {
        return memberPassword;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
