package co.yedam.ClassMem;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

import co.yedam.app.Application;
import co.yedam.app.management;

public class ClassMemService {
	
	public static ClassMem classMemInfo = null;
	Scanner sc = new Scanner(System.in);
	
	
	//로그인
	public void doLogin() {
		
		try{
		ClassMem cs = new ClassMem();
		
		
		System.out.print("IDᐵ ");
		String id = sc.nextLine();
		
		System.out.print("PWᐵ ");
		String pw = sc.nextLine();
		
		
		cs = ClassMemDAO.getInstance().doLogin(id);
		
		if(cs.getMemberPw().equals(pw)) {
			classMemInfo = cs;
			System.out.println(" ");
			 System.out.println("  【 로그인 성공 】");
		
		}else {
			System.out.println(" ");
			System.out.println("  【 로그인 실패! 비밀번호를 확인해주세요. 】");
			classMemInfo = null;
			doLogin();
		}

		
		}catch(Exception e) {
			System.out.println("  【 로그인 실패! 아이디를 확인해주세요. 】");
			doLogin();
			
		}
	} //로그인 doLogin 끝
	
	//로그아웃
	public void doLogout() {
	
		boolean run1 = true;
		while(run1) {
			
		
			
		Scanner sc = new Scanner(System.in);
		ClassMemService cm = new ClassMemService();
		System.out.println(" ");
		System.out.println("  【 로그아웃되었습니다 】  ");
		System.out.println(" ");
		System.out.println(" ");
		classMemInfo = null;
		
		
	//	Application ap = new Application();
	//	ap.Application();
	try {
	
		System.out.println(" ❊ 1.로그인  2.종료 ❊ ");
		int menuNo = 0;
		System.out.print("  메뉴선택▶ ");
		try {
		menuNo = Integer.parseInt(sc.nextLine());
		
		try {
		switch(menuNo) {
		case 1:
			cm.doLogin();
			if(ClassMemService.classMemInfo != null) {
				new management(); 
			}else {
					//classMemInfo = null;
				
			}
			break;
			
		case 2:
			System.out.println("=======================");
			System.out.println("   ❊ 종료되었습니다!! ❊ ");
			System.out.println("=======================");
			run1 = false;
			break;
		}
		}catch(NullPointerException e){
			System.out.println("--------⚠️ 에러코드표 확인 하세요 ⚠️--------");
			System.out.println("  해당 원인 : " + e.getMessage());
			System.out.println("--------------------------------------");
		}
		
		
		
		
		
		
		}catch(NumberFormatException e) {
			System.out.println("--------⚠️ 에러코드표 확인 하세요 ⚠️--------");
			System.out.println("  올바른 형식으로 입력해주세요");
			System.out.println("  해당 원인 : " + e.getMessage());
			System.out.println("--------------------------------------");
		}
		}catch(Exception e){
			System.out.println("--------⚠️ 에러코드표 확인 하세요 ⚠️--------");
			System.out.println("  해당 원인 : " + e.getMessage());
			System.out.println("--------------------------------------");
		
	
	//while
		
	}
		
	}
		} //doLogin

	//학생등록 (아이디, 비번, 이름, 전화번호,주소)
	public void insertSt() {
		ClassMem cs = new ClassMem();
		
		System.out.print("학생 아이디를 입력하세요ᐵ ");
		String memberId = sc.nextLine();
		
		System.out.print("학생 비밀번호를 입력하세요ᐵ ");
		String memberPw = sc.nextLine();
		
		System.out.print("학생 이름을 입력하세요ᐵ ");
		String memberName = sc.nextLine();
		
		System.out.print("학생 전화번호를 입력하세요ᐵ ");
		String memberTel = sc.nextLine();
		
		System.out.print("학생 주소를 입력하세요ᐵ ");
		String memberAddr = sc.nextLine();
		
		cs.setMemberId(memberId);
		cs.setMemberPw(memberPw);
		cs.setMemberName(memberName);
		cs.setMemberTel(memberTel);
		cs.setMemberAddr(memberAddr);
		
		int result = ClassMemDAO.getInstance().insertSt(cs);
		
		if(result == 1) {
			System.out.println(" 【 학생 등록 완료 】");
		}else {
			System.out.println(" 【 학생 등록 실패 】");
		}
		
	}
	//학생등록 insertSt 끝
	
	
	
	//선생님 등록 아이디, 비번, 이름, 방과후교실정보
	public void insertTe() {
		ClassMem cs = new ClassMem();
		
		System.out.print("선생님 아이디를 입력하세요ᐵ ");
		String memberId = sc.nextLine();
		
		System.out.print("선생님 비밀번호를 입력하세요ᐵ ");
		String memberPw = sc.nextLine();
		
		System.out.print("선생님 이름을 입력하세요ᐵ ");
		String memberName = sc.nextLine();
		
		System.out.print("담당한 방과후교실 정보를 입력하세요\n방과후 id> ");
		int classId = Integer.parseInt(sc.nextLine());
		
		cs.setMemberId(memberId);
		cs.setMemberPw(memberPw);
		cs.setMemberName(memberName);
		cs.setClassId(classId);
		
		int result = ClassMemDAO.getInstance().insertTe(cs);
		
		if(result == 1) {
			System.out.println(" 【 선생님 등록 완료 】");
		}else {
			System.out.println(" 【 선생님 등록 실패 】");
		}
	
	}
	//선생님 등록 insertTe 끝
	
	

	// 학생 정보 수정 이름
	public void updateNa() {
		ClassMem cs = new ClassMem();
				
		System.out.print("변경할 학생Id 입력 하세요ᐵ ");
		String id = sc.nextLine();
		System.out.print("변경할 이름을 입력하세요ᐵ ");
		String na = sc.nextLine();
				
		cs.setMemberId(id);
		cs.setMemberName(na);
				
		int result = ClassMemDAO.getInstance().updateNa(cs);
		
		if(result == 1) {
			System.out.println(" 【 정보 수정 완료 】");
		}else {
			System.out.println(" 【 정보 수정 실패 】");
		}
		
				
	}// 학생 정보 수정 이름 updateNa
		
		
		
	// 학생 정보 수정 전화번호
	public void updateTel() {
		ClassMem cs = new ClassMem();
			
		System.out.print("변경할 학생Id 입력 하세요ᐵ ");
		String id = sc.nextLine();
		System.out.print("변경할 전화번호를 입력하세요ᐵ ");
		String tel = sc.nextLine();
			
		cs.setMemberId(id);
		cs.setMemberTel(tel);
			
		int result = ClassMemDAO.getInstance().updateTel(cs);
			
		if(result == 1) {
			System.out.println(" 【 정보 수정 완료 】");
		}else {
			System.out.println(" 【 정보 수정 실패 】");
		}
		
		
	}// 학생 정보 수정 전화번호 updateTel 끝
		
		
		
		// 학생 정보 수정 주소
	public void updateAd() {
		ClassMem cs = new ClassMem();
			
		System.out.print("변경할 학생Id 입력 하세요ᐵ ");
		String id = sc.nextLine();
		System.out.print("변경할 주소를 입력하세요ᐵ ");
		String ad = sc.nextLine();
			
		cs.setMemberId(id);
		cs.setMemberAddr(ad);
			
		int result = ClassMemDAO.getInstance().updateAd(cs);
		
		if(result == 1) {
			System.out.println(" 【 정보 수정 완료 】");
		}else {
			System.out.println(" 【 정보 수정 실패 】");
		}
		
	}// 학생 정보 수정 주소 updateAd 끝	
	
		
		
	//관리자용 학생 정보 조회 이름,전화번호,주소,방과후교실 조회
	public void getClassMem() {
		List<ClassMem>list = ClassMemDAO.getInstance().getClassMem(ClassMemService.classMemInfo.getMemberId());	
		
		for(ClassMem cs : list) {
			System.out.print("[  학생아이디 : " + cs.getMemberId());
			System.out.print("  학생이름 : " + cs.getMemberName());
			System.out.print("  전화번호 : " + cs.getMemberTel());
			System.out.print("  주소 : " + cs.getMemberAddr());
			System.out.println("  방과후교실 : " + cs.getClassName() + " ] ");
		}
		
		
	} //학생 정보 조회 getClassMem
	
	
	//학생용 학생 정보 조회 이름,전화번호,주소,방과후교실 조회
	public void getClassSt() {
		List<ClassMem>list = ClassMemDAO.getInstance().getClassSt(ClassMemService.classMemInfo.getMemberId());	
			
		for(ClassMem cs : list) {
			System.out.print("[  학생이름 : " + cs.getMemberName());
			System.out.print("  전화번호 : " + cs.getMemberTel());
			System.out.print("  주소 : " + cs.getMemberAddr());
			System.out.println("  방과후교실 : " + cs.getClassName() + " ] ");
		}
			
			
		} //학생 정보 조회 getClassMem
	

	
	
	//학생 정보 삭제
	public void deleteSt() {
		ClassMem cs = new ClassMem();
		
		System.out.print("삭제할 학생Id를 입력 하세요ᐵ ");
		String id = sc.nextLine();
		
		int result = ClassMemDAO.getInstance().deleteSt(id);
		
		if(result == 1) {
			System.out.println(" 【 학생 정보 삭제 완료 】");
		}else {
			System.out.println(" 【 학생 정보 삭제 실패 】");
		}
		
	}//학생 정보 삭제 deleteSt 끝
	
	
	
	//학생 방과후 교실 선택
	public void insertAfClass() {
	
	
		ClassMem cs = new ClassMem();
		
	try{	
		System.out.print("본인 Pw를 입력하세요ᐵ ");
		String pw = sc.nextLine();
		
		System.out.print("듣고 싶은 방과후교실 ID를 입력하세요ᐵ "); 		
		
		int classId = Integer.parseInt(sc.nextLine());
		
		if(classId == 1 || classId ==2 || classId == 3 ) {
			
		
		cs.setMemberPw(pw);
		cs.setClassId(classId);
		
		int result = ClassMemDAO.getInstance().insertAfClass(cs);
		
		if(result == 1) {
			System.out.println(" 【 방과후교실 선택 완료 】");
		}else {
			
			System.out.println(" 【 방과후교실 선택 실패 】");
			
		}
		}else{
			System.out.println("없는 수업입니다.");
		}
	}catch(Exception e){
		System.out.println("없는 수업입니다.");
			
	}
		
	
	}//학생 방과후 교실 선택 insertAfClass 끝
	
		
	
	
	//추가수당 등록하면서  확인
	public void plusSal() {
		ClassMem cs = new ClassMem();

		
		int result = ClassMemDAO.getInstance().updatePSal(ClassMemService.classMemInfo.getMemberId());
		
		
		
		List<ClassMem>list = ClassMemDAO.getInstance().plusSal(ClassMemService.classMemInfo.getMemberId());
		
		for(ClassMem cm : list) {
			DecimalFormat df = new DecimalFormat("###,###");
			System.out.println(cm.getMemberName() + "의 추가 수당은 " + df.format(cm.getMemberSal()) + "원 입니다.");
		}
		
		
		
		
	}
	
	
	
	
}
