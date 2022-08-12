package co.yedam.afterSchoolClass;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

import co.yedam.ClassMem.ClassMemDAO;
import co.yedam.ClassMem.ClassMemService;

public class AfterSchoolClassService {

	//public static AfterSchoolClass afClassInfo = null;
	Scanner sc = new Scanner(System.in);
	
	
	//방과후교실 등록 (수업번호, 수업이름, 강사이름, 수업요일, 수업시간,시간당수당)
	public void insertClass() {
		AfterSchoolClass af = new AfterSchoolClass();
		
		System.out.print("방과후교실 번호를 입력하세요ᐵ ");
		int classId = Integer.parseInt(sc.nextLine());
		
		System.out.print("방과후교실 이름을 입력하세요ᐵ ");
		String className = sc.nextLine();
		
		System.out.print("방과후교실 장소를 입력하세요ᐵ ");
		String classPlace = sc.nextLine();
		
		System.out.print("방과후교실 요일을 입력하세요ᐵ ");
		String classWeek = sc.nextLine();
		
		System.out.print("방과후교실 수업시간을 입력하세요ᐵ ");
		String classTime = sc.nextLine();
		
		System.out.print("방과후교실 시간당수당을 입력하세요ᐵ");
		int classSal = Integer.parseInt(sc.nextLine());
		
		af.setClassId(classId);
		af.setClassName(className);
		af.setClassPlace(classPlace);
		af.setClassWeek(classWeek);
		af.setClassTime(classTime);
		af.setClassSal(classSal);
		
		int result = AfterSchoolClassDAO.getInstance().insertClass(af);
		
		if(result == 1) {
			System.out.println("【 방과후교실 등록 완료 】");
		}else {
			System.out.println("【 방과후교실 등록 실패 】");
		}
		
	} //방과후교실 등록 insertClass 끝
	
	
	
	//선생님 방과후교실정보 조회 선생님id 입력하면 맡은 수업이름, 수업장소, 수업요일, 수업시간, 추가수당(시간당)
	public void getClassTe() {
		
		List<AfterSchoolClass>list = AfterSchoolClassDAO.getInstance().getClassTe(ClassMemService.classMemInfo.getMemberId());
		
		for(AfterSchoolClass af : list) {
			DecimalFormat df = new DecimalFormat("###,###");
			System.out.println("┌-------------------------------------┐");
			System.out.println("  방과후교실 번호 : " + af.getClassId());
			System.out.println("  방과후교실 이름 : " + af.getClassName());
			System.out.println("  방과후교실 장소 : " + af.getClassPlace());
			System.out.println("  방과후교실 요일 : " + af.getClassWeek());
			System.out.println("  방과후교실 수업시간 : " + af.getClassTime());
			System.out.println("  방과후교실 수당(시간당) : " + df.format(af.getClassSal()) + "원 입니다.");
			System.out.println("┕-------------------------------------┘");
		}
	}//선생님 방과후교실정보 조회 getClassTe
	

	// 학생 방과후 교실 정보 조회 (id , 이름 장소 요일 시간) 
	public void getClassSt() {
	
		List<AfterSchoolClass>list = AfterSchoolClassDAO.getInstance().getClassSt();
		
		
		for(AfterSchoolClass af : list) {
			System.out.println("┌----------------------------------┐");
			System.out.println("  방과후교실 ID : " + af.getClassId() );
			System.out.println("  방과후교실 이름 : " + af.getClassName());
			System.out.println("  방과후교실 장소 : " + af.getClassPlace());
			System.out.println("  방과후교실 요일 : " + af.getClassWeek());
			System.out.println("  방과후교실 수업시간 : " + af.getClassTime());
			System.out.println("┕----------------------------------┘");
			
		}
	}
	
	//선생님용 자기수업 듣는 학생 이름 조회
	public void getClass1() {

		System.out.print("방과후교실 ID를 입력하세요ᐵ ");
		int id = Integer.parseInt(sc.nextLine()); 
		
		
		List<AfterSchoolClass>list = AfterSchoolClassDAO.getInstance().getClass1(id);
		List<AfterSchoolClass>list1 = AfterSchoolClassDAO.getInstance().getClass11(id);
		
		for(AfterSchoolClass af1 : list1) {
		System.out.print(af1.getClassName() + " 수업을 듣는 학생은 ");
		}
		
		for(AfterSchoolClass af : list) {
			System.out.print(af.getMemberName() + " ");			
		}System.out.println("입니다. ");
	
	
	}
	

}
