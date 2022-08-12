package co.yedam.afterSchoolClass;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.yedam.common.DAO;

public class AfterSchoolClassDAO extends DAO {
	
	private static AfterSchoolClassDAO afterSchoolDao = null;
	
	private AfterSchoolClassDAO() {
		
	}
	
	public static AfterSchoolClassDAO getInstance() {
		return afterSchoolDao == null? afterSchoolDao = new AfterSchoolClassDAO() : afterSchoolDao;
		
	}


//방과후교실 등록 (수업번호, 수업이름, 강사이름, 수업요일, 수업시간)
	public int insertClass(AfterSchoolClass asClass) {
		int result = 0;
		try {
			conn();
			String sql = "insert into afterschoolclass (class_id, class_name, class_place,class_week,class_time,class_sal) values(?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, asClass.getClassId());
			pstmt.setString(2, asClass.getClassName());
			pstmt.setString(3, asClass.getClassPlace());
			pstmt.setString(4, asClass.getClassWeek());
			pstmt.setString(5, asClass.getClassTime());
			pstmt.setInt(6,asClass.getClassSal());
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println("-----------------⚠️ 에러코드표 확인 하세요 ⚠️-----------------");
			System.out.println("   해당 에러코드 : " + e.getErrorCode());
			System.out.println("   해당 원인 : " + e.getMessage());
			System.out.println("--------------------------------------------------------");
			
			e.getMessage();
			e.getErrorCode();
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconnect();
		}return result;
	
	}//방과후등록 insertClass 끝


	//선생님 방과후교실정보 조회 선생님id 입력하면 수업이름, 수업장소, 수업요일, 수업시간, 추가수당(시간당)
	public List<AfterSchoolClass> getClassTe(String memberId) {
		List<AfterSchoolClass> list = new ArrayList<AfterSchoolClass>();
		AfterSchoolClass as = null;
		try {
			conn();
			String sql = "select a.class_id class_id, a.class_name class_name, a.class_place class_place, a.class_week class_week, a.class_time class_time, a.class_sal class_sal "
					+ " from afterschoolclass a join classMem c "
					+ " on a.class_id = c.class_id"
					+ " where c.member_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				as = new AfterSchoolClass();
				
				as.setClassId(rs.getInt("class_id"));
				as.setClassName(rs.getString("class_name"));
				as.setClassPlace(rs.getString("class_place"));
				as.setClassWeek(rs.getString("class_week"));
				as.setClassTime(rs.getString("class_time"));
				as.setClassSal(rs.getInt("class_sal"));
				
				list.add(as);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconnect();
		}return list;
		
	}//선생님 방과후교실 정보조회 getClassTe 끝
	

	
	// 학생 방과후 교실 정보 조회 (id , 이름 장소 요일 시간) 
	public List<AfterSchoolClass> getClassSt() { 
		List<AfterSchoolClass>list = new ArrayList<>();
		AfterSchoolClass as = null;
		try {
			conn();
			String sql = "select class_id, class_name, class_place, class_week, class_time from afterschoolclass order by class_id";
					
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				as = new AfterSchoolClass();
				
				as.setClassId(rs.getInt("class_id"));
				as.setClassName(rs.getString("class_name"));
				as.setClassPlace(rs.getString("class_place"));
				as.setClassWeek(rs.getString("class_week"));
				as.setClassTime(rs.getString("class_time"));
	
				
				list.add(as);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconnect();
		}return list;
			
	}// 방과후교실 조회 
	
	
	
	public List<AfterSchoolClass> getClass11(int id) {
		List<AfterSchoolClass>list = new ArrayList<>();
		AfterSchoolClass as = null;
		
		try {
			conn();
			String sql = "select class_name from afterschoolclass where class_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				as = new AfterSchoolClass();
				
				as.setClassName(rs.getString("class_name"));
				
				list.add(as);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			disconnect();
		}return list;
		
	}
	
	
	
	//선생님용 방과후교실 듣는 리스트 조회 자기수업 듣는 학생 이름 조회
	public List<AfterSchoolClass> getClass1(int classId){
		List<AfterSchoolClass>list = new ArrayList<>();
		AfterSchoolClass as = null;
		
		try{
			conn();
			String sql = "select a.class_id class_id, c.member_name member_name"
					+ " from afterschoolclass a join classmem c"
					+ " on  a.class_id = c.class_id"
					+ " where c.class_id = ? and role = 2";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, classId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				as = new AfterSchoolClass();
				
				as.setClassId(rs.getInt("class_id"));
				as.setMemberName(rs.getString("member_name"));
				
				list.add(as);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			disconnect();
		}return list;
		
	}//방과후 수업 듣는 리스트 조회 getClass 끝











}
