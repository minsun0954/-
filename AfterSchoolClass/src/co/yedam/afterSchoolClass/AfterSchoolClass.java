package co.yedam.afterSchoolClass;

public class AfterSchoolClass {

//이름          널?       유형            
//----------- -------- ------------- 
//CLASS_ID    NOT NULL NUMBER        
//CLASS_NAME  NOT NULL VARCHAR2(100) 
//CLASS_PLACE          VARCHAR2(20)  
//CLASS_WEEK           VARCHAR2(20)  
//CLASS_TIME           VARCHAR2(20)  
//class_sal 			number
	
	
	private int classId;
	private String className;
	private String classPlace;
	private String classWeek;
	private String classTime;
	private int classSal;
	private int memberSal;
	
	private String memberName;

	
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public int getMemberSal() {
		return memberSal;
	}
	public void setMemberSal(int memberSal) {
		this.memberSal = memberSal;
	}
	
	
	
	public int getClassSal() {
		return classSal;
	}
	public int getClassId() {
		return classId;
	}
	public String getClassName() {
		return className;
	}
	public String getClassPlace() {
		return classPlace;
	}
	public String getClassWeek() {
		return classWeek;
	}
	public String getClassTime() {
		return classTime;
	}
	
	
	public void setClassSal(int classSal) {
		this.classSal = classSal;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public void setClassPlace(String classPlace) {
		this.classPlace = classPlace;
	}
	public void setClassWeek(String classWeek) {
		this.classWeek = classWeek;
	}
	public void setClassTime(String classTime) {
		this.classTime = classTime;
	}
	
	
	
	
}
