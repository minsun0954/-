package co.yedam.ClassMem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.common.DAO;

public class ClassMemDAO extends DAO {	
	
	private static ClassMemDAO classMemDao = new ClassMemDAO();
	
	private ClassMemDAO() {
		
	}
	
	public static ClassMemDAO getInstance() {
		return classMemDao;
	}
	
	
	//로그인 메서드
	public ClassMem doLogin(String id) {
		ClassMem classMem = null;
		
		try {
			conn();
			String sql = "select * from ClassMem where member_id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				classMem = new ClassMem();
				
				classMem.setMemberId(rs.getString("member_id"));
				classMem.setMemberPw(rs.getString("member_pw"));
				classMem.setMemberName(rs.getString("member_name"));
				classMem.setRole(rs.getString("role"));
			}
			
			}catch(Exception e){
				e.printStackTrace();
			
			}finally {
				disconnect();
			
			}return classMem;	
		
	}//로그인 메소드 끝
	
	//로그아웃 메서드
	
	
	//학생등록 (아이디, 비번, 이름, 전화번호,주소)
	public int insertSt(ClassMem csMem) {
		int result = 0;
		try {
			conn();
			String sql = "insert into classMem (member_id,member_pw,member_name,member_tel,member_addr,role) values(?,?,?,?,?,2)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, csMem.getMemberId());
			pstmt.setString(2, csMem.getMemberPw());
			pstmt.setString(3, csMem.getMemberName());
			pstmt.setString(4, csMem.getMemberTel());
			pstmt.setString(5, csMem.getMemberAddr());
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("--------⚠️ 에러코드표 확인 하세요 ⚠️--------");
			System.out.println("   해당 에러코드 : " + e.getErrorCode());
			System.out.println("   해당 원인 : " + e.getMessage());
			System.out.println("--------------------------------------");
			
			e.getMessage();
			e.getErrorCode();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconnect();
		}return result;
		
	}//학생등록 insertSt 끝
	

	
	//선생님 등록 아이디, 비번, 이름, 방과후교실정보
	public int insertTe(ClassMem csMem) {
		int result = 0;
		try {
			conn();
			String sql = "insert into classMem (member_id,member_pw,member_name,class_id,role) values(?,?,?,?,1)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, csMem.getMemberId());
			pstmt.setString(2, csMem.getMemberPw());
			pstmt.setString(3, csMem.getMemberName());
			pstmt.setInt(4, csMem.getClassId());
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("--------⚠️ 에러코드표 확인 하세요 ⚠️--------");
			System.out.println("   해당 에러코드 : " + e.getErrorCode());
			System.out.println("   해당 원인 : " + e.getMessage());
			System.out.println("--------------------------------------");
			
			e.getMessage();
			e.getErrorCode();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconnect();
		}return result;
	
	}//선생님 등록 insertTe 끝
	
	
	
	//학생정보수정 id입력하면 이름 전화번호 주소 선택후 변경
	public int updateNa(ClassMem csMem) {
		int result = 0;
		
		try {
			conn();
			String sql = "update classmem set member_name =?  where member_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, csMem.getMemberName());
			pstmt.setString(2, csMem.getMemberId());
			
			result = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconnect();
		}return result;
		
	}// 학생정보수정 id입력하면 이름 수정 updateNa
	
	
	
	//학생정보수정 id입력하면 전화번호
	public int updateTel(ClassMem csMem) {
		int result = 0;
			
		try {
			conn();
			String sql = "update classmem set member_tel =?  where member_id = ?";
				
			pstmt = conn.prepareStatement(sql);
				
			pstmt.setString(1, csMem.getMemberTel());
			pstmt.setString(2, csMem.getMemberId());
				
			result = pstmt.executeUpdate();
				
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconnect();
		}return result;
			
	}// 학생정보수정 id입력하면 전화번호 수정 updateTel
	
		
		

	//학생정보수정 id입력하면 주소 선택후 변경
	public int updateAd(ClassMem csMem) {
		int result = 0;
			
		try {
			conn();
			String sql = "update classmem set member_addr =?  where member_id = ?";
				
			pstmt = conn.prepareStatement(sql);
				
			pstmt.setString(1, csMem.getMemberAddr());
			pstmt.setString(2, csMem.getMemberId());
				
			result = pstmt.executeUpdate();
				
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconnect();
		}return result;
			
	}// 학생정보수정 id입력하면 주소 수정 updateAd


		
		// 학생 정보 조회 id 입력하면 이름,전화번호,주소,방과후교실 조회
//		public List<ClassMem> getClassMem(){
//			List<ClassMem>list = new ArrayList<>();
//			ClassMem classMem = null;
	
			
	//관리자용 학생 정보 전체 조회 이름,전화번호,주소,방과후교실 조회
	public List<ClassMem> getClassMem(String memberId) {
		List<ClassMem> list = new ArrayList<ClassMem>();
		ClassMem classMem = null;	
		
		try {
			conn();
			String sql ="select c.member_id member_id, c.member_name, c.member_tel, c.member_addr, a.class_name"
					+ " from classmem c left outer join afterschoolclass a"
					+ " on c.class_id = a.class_id"
					+ " where role = '2'"
					+ " order by member_id";
	
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
				
			while(rs.next()) {
				classMem = new ClassMem();
					
				classMem.setMemberId(rs.getString("member_id"));
				classMem.setMemberName(rs.getString("member_name"));
				classMem.setMemberTel(rs.getString("member_tel"));
				classMem.setMemberAddr(rs.getString("member_addr"));
				classMem.setClassName(rs.getString("class_name"));			// 다른 테이블에 있는 필드값 사용하고 싶으면 본인 필드에 필드값 추가해주면 사용가능 //private String className;
				
				list.add(classMem);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconnect();
		}return list;
		
	}// 학생 정보 조회 getClassMem 끝
		
	
	//학생용 학생 정보 조회
	public List<ClassMem> getClassSt(String memberId) {
		List<ClassMem> list = new ArrayList<ClassMem>();
		ClassMem classMem = null;	
		
		try {
			conn();
			String sql ="select c.member_name, c.member_tel, c.member_addr, a.class_name"
					+ " from classmem c left outer join afterschoolclass a"
					+ " on c.class_id = a.class_id"
					+ " where member_id = ?";
	
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				classMem = new ClassMem();
					
				classMem.setMemberName(rs.getString("member_name"));
				classMem.setMemberTel(rs.getString("member_tel"));
				classMem.setMemberAddr(rs.getString("member_addr"));
				classMem.setClassName(rs.getString("class_name"));			// 다른 테이블에 있는 필드값 사용하고 싶으면 본인 필드에 필드값 추가해주면 사용가능 //private String className;
				
				list.add(classMem);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconnect();
		}return list;
		
	}// 학생 정보 조회 getClassMem 끝
	
	
	
		
	//학생 삭제 id 입력하면 삭제
	public int deleteSt(String id) {
		int result = 0;
		try {
			conn();
			String sql = "delete from classmem where member_id = ?";
				
			pstmt = conn.prepareStatement(sql);
				
			pstmt.setString(1, id);
				
			result = pstmt.executeUpdate();
				
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconnect();
		}return result;
			
	}//학생 삭제 deleteSt 끝
		
		
		
		
		
	//학생 방과후 교실 선택
	public int insertAfClass(ClassMem csMem) {
		int result = 0;
		try {
			conn();
			String spl = "update classmem set class_id = ? where member_pw = ?";
			
			pstmt = conn.prepareStatement(spl);
				
			pstmt.setInt(1, csMem.getClassId() );
			pstmt.setString(2, csMem.getMemberPw());
				
			result = pstmt.executeUpdate();
				
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconnect();
		}return result;
		
	}// 학생 방과후 교실 선택  insertAfClass		
		
		
	//추가수당 등록
	public int updatePSal(String memberId) {
		int result = 0;
		try {
			conn();
			String spl = "update classmem c"
					+ " set c.member_sal  = ( select a.class_sal * 4 *1.5 "
					+ "  					  from afterschoolclass a"
					+ "		  				  where c.class_id = a.class_id)"
					+ " where member_id = ? ";
			
			pstmt = conn.prepareStatement(spl);
			
			pstmt.setString(1, memberId);
			
			result = pstmt.executeUpdate();
					
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconnect();
		}return result;
		
	}	//추가수당 등록 updatePSal 끝
	
	
	
	
	
	
	//추가수당 확인
	public List<ClassMem> plusSal(String memberId) {
		List<ClassMem> list = new ArrayList<>();
		ClassMem cs = null;

		try {
			conn();
			String sql = "select member_name, member_sal"
					+ "  from classmem"
					+ "  where member_id =  ? ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				cs = new ClassMem();
				
				cs.setMemberName(rs.getString("member_name"));
				cs.setMemberSal(rs.getInt("member_sal"));
				
				list.add(cs);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconnect();
		}return list;
	
	}//추가수당 확인 plusSal
		

	
	
	
	
	
}
