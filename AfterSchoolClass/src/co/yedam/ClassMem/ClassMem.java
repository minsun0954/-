package co.yedam.ClassMem;

public class ClassMem {
//	이름           널?       유형           
//	------------ -------- ------------ 
//	MEMBER_ID    NOT NULL  VARCHAR2(20)    
//	MEMBER_PW    NOT NULL  VARCHAR2(20)       
//	MEMBER_NAME  NOT NULL VARCHAR2(15) 
//	MEMBER_TEL            VARCHAR2(20) 
//	MEMBER_ADDR          VARCHAR2(20) 
//	CLASS_ID              NUMBER       
//	MEMBER_SAL            NUMBER       
//	ROLE         NOT NULL CHAR(1)      

	
private String memberId;
private String memberPw;
private String memberName;
private String memberTel;
private String memberAddr;
private int classId;
private int memberSal;
private String role;	// 권한 0.관리자 1.선생님 2.학생

private String className;
private int classSal;
private String memberSal1;











public String getMemberSal1() {
	return memberSal1;
}
public void setMemberSal1(String memberSal1) {
	this.memberSal1 = memberSal1;
}


public int getClassSal() {
	return classSal;
}
public void setClassSal(int classSal) {
	this.classSal = classSal;
}

public String getClassName() {
	return className;
}
public void setClassName(String className) {
	this.className = className;
	
	
}
public String getMemberId() {
return memberId;
}
public String getMemberPw() {
return memberPw;
}
public String getMemberName() {
return memberName;
}
public String getMemberTel() {
return memberTel;
}
public String getMemberAddr() {
return memberAddr;
}
public int getClassId() {
return classId;
}
public int getMemberSal() {
return memberSal;
}
public String getRole() {
return role;
}




public void setMemberId(String memberId) {
this.memberId = memberId;
}
public void setMemberPw(String memberPw) {
this.memberPw = memberPw;
}
public void setMemberName(String memberName) {
this.memberName = memberName;
}
public void setMemberTel(String memberTel) {
this.memberTel = memberTel;
}
public void setMemberAddr(String memberAddr) {
this.memberAddr = memberAddr;
}
public void setClassId(int classId) {
this.classId = classId;
}
public void setMemberSal(int memberSal) {
this.memberSal = memberSal;
}
public void setRole(String role) {
this.role = role;
}






}
