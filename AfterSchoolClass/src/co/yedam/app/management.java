package co.yedam.app;

import java.util.Scanner;

import co.yedam.ClassMem.ClassMemService;
import co.yedam.afterSchoolClass.AfterSchoolClassService;


public class management {
	
	Scanner sc = new Scanner(System.in);

	
	ClassMemService cm = new ClassMemService();
	AfterSchoolClassService af = new AfterSchoolClassService();
	
	
	public management() {
		start();
	}
	
	private void start() {
		
		while(true) {
		
//		System.out.println("로그인 종류를 선택하시오. ");
//		System.out.println("0.관리자 1.선생님 2.학생");
//		int menuNo = Integer.parseInt(sc.nextLine());
		
		if(ClassMemService.classMemInfo.getRole().equals("0")) {
			System.out.println(" ");
			System.out.println("===========================================================================================================");
			System.out.println("                                              ❊ 관리자 로그인 ❊                                            ");
			System.out.println("===========================================================================================================");
			System.out.println(" ");
			
			System.out.println("  1.방과후교실 등록 2.학생 등록 3.선생님 등록 4.학생 정보 수정 5.학생정보 조회 6.학생정보삭제 7.로그아웃");
			System.out.print("  메뉴선택▶ ");
		try {
			int menu = Integer.parseInt(sc.nextLine());
			
			
			
			if(menu == 1) {
				af.insertClass();
			}else if(menu == 2) {
				cm.insertSt();
			}else if(menu == 3) {
				cm.insertTe();
			}else if(menu == 4) {
				System.out.println(" 1.이름수정 2.전화번호수정 3.주소수정");
				System.out.print("  메뉴선택▶ ");
				int menu1 = Integer.parseInt(sc.nextLine());
				
				if(menu1 == 1) {
					cm.updateNa();
				}else if(menu1 == 2) {
					cm.updateTel();
				}else if(menu1 == 3) {
					cm.updateAd();
				}
			}else if(menu == 5) {
				cm.getClassMem();
			}else if(menu == 6) {
				cm.deleteSt();
			}else if(menu == 7) {
				cm.doLogout();
			break;

			}
			
			}catch(NumberFormatException e) {
				System.out.println(" ");
				System.out.println("--------⚠️ 에러코드표 확인 하세요 ⚠️--------");
				System.out.println("  올바른 형식으로 입력해주세요");
				System.out.println("  해당 원인 : " + e.getMessage());
				System.out.println("--------------------------------------");
				System.out.println(" ");
			}
	
		
		
		
			}else if(ClassMemService.classMemInfo.getRole().equals("1")) {
			System.out.println(" ");
			System.out.println("==================================================");
			System.out.println("                    ❊ 선생님 로그인 ❊              ");
			System.out.println("==================================================");
			System.out.println(" ");

			System.out.println("  1.방과후교실 정보 2.학생조회 3.추가수당확인 4.로그아웃 ");
			System.out.print("  메뉴선택▶");
			 
		try {	
			int menu = Integer.parseInt(sc.nextLine());
			if(menu == 1) {
				af.getClassTe();
			}else if(menu == 2) {
				af.getClass1();
			}else if(menu == 3) {
				cm.plusSal();
			}else if(menu == 4) {
				cm.doLogout();
			}
			
		}catch(NumberFormatException e) {
			System.out.println(" ");
			System.out.println("--------⚠️ 에러코드표 확인 하세요 ⚠️--------");
			System.out.println("  올바른 형식으로 입력해주세요");
			System.out.println("  해당 원인 : " + e.getMessage());
			System.out.println("--------------------------------------");
		
		}	
		
		
		
		
		
		}else if(ClassMemService.classMemInfo.getRole().equals("2")) {
			System.out.println(" ");
			System.out.println("======================================================");
			System.out.println("                   ❊ 학생 로그인 ❊               ");
			System.out.println("======================================================");
			System.out.println(" ");
			
			System.out.println("  1.학생정보조회 2.방과후교실 선택 3.로그아웃 ");
			System.out.print("  메뉴선택▶ ");
			
		try {
			int menu = Integer.parseInt(sc.nextLine());
			if(menu == 1) {
				cm.getClassSt();
			}else if(menu == 2) {
				af.getClassSt();
				
				cm.insertAfClass();

			}else if(menu == 3) {
				cm.doLogout();
			}
		}catch(NumberFormatException e) {
			System.out.println(" ");
			System.out.println("--------⚠️ 에러코드표 확인 하세요 ⚠️--------");
			System.out.println("  올바른 형식으로 입력해주세요");
			System.out.println("  해당 원인 : " + e.getMessage());
			System.out.println("--------------------------------------");
			System.out.println(" ");
		}
	
		} 
		
		} //while문
		}
	}
