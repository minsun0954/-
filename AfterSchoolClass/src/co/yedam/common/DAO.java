package co.yedam.common;
//1 db랑 연결하는 문
// build path 설정해줘야함 모듈패스(add extrna 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO {

	//DAO(Data Access Object) : 

	//java <-> DB 연결할때 쓰는 객체
	protected Connection conn= null;
	//Select(조회) 결과 값 반환 받는 객체
	protected ResultSet rs = null;
	//쿼리문을 담고 쿼리문을 실행하는 객체 (dml)
	protected PreparedStatement pstmt= null;
	//쿼리문을 담고 쿼리문을 실행하는 객체 (select문)
	protected Statement stmt = null;
	
	String driver =  "oracle.jdbc.driver.OracleDriver";
	 String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
     String id = "test";
     String pw = "1234";

     public void conn() {
    	 try {
    		 //드라이버 로딩
			Class.forName(driver);
			//DB연결
			conn = DriverManager.getConnection(url,id,pw);
    	 } catch (Exception e) {
			e.printStackTrace();
		}
     }
     
     // 연결끊기(거꾸로)
	public void disconnect() {
		try {
			if(rs != null) {
				rs.close();
			
			}if(stmt != null) {
				stmt.close();
			
			}if(pstmt != null) {
				pstmt.close();
				
			}if(conn != null) {
				conn.close();
			
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
