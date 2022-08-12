package co.yedam.app;

import java.util.Scanner;

import co.yedam.ClassMem.ClassMem;
import co.yedam.ClassMem.ClassMemService;



public class Application {
	
	Scanner sc = new Scanner(System.in);
	ClassMemService cm = new ClassMemService();
	
	int menuNo = 0;
	
	public Application() {
		run();
	}
	
	private void run() {
		boolean run = true;
		while(run ) {
		try {
		System.out.println(" ❊ 1.로그인  2.종료 ❊ ");
		System.out.print(" 메뉴선택▶ ");
		
		menuNo = Integer.parseInt(sc.nextLine());
		switch(menuNo) {
		
		case 1:
			cm.doLogin();
			if(ClassMemService.classMemInfo != null) {
				new management(); 
			}
			break;
			
		case 2:
			System.out.println("========================");
			System.out.println("   ❊ 종료되었습니다 ❊ ");
			System.out.println("=======================");
			run = false;
			break;
			
		}
	
		}catch(NumberFormatException e) {
			System.out.println("--------⚠️ 에러코드표 확인 하세요 ⚠️--------");
			System.out.println("  올바른 형식으로 입력해주세요");
			System.out.println("  해당 원인 : " + e.getMessage());
			System.out.println("--------------------------------------");
			System.out.println(" ");
			
		}
			
		
		}
		
	
	}




}
