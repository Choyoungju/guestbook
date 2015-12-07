package com.hanains.guestbook.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hanains.guestbook.vo.GuestbookVo;



public class GuestbookDao {

	public List<GuestbookVo> getList(){

		List<GuestbookVo> list = new ArrayList<GuestbookVo>();
		ResultSet rs = null;
		//Connection connection = null;
		Connection connection = null;
		Statement stmt = null;

		//1.,드라이버 로딩(클래스 로딩)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Long no;

			//2. db 욘굘
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			connection =  DriverManager.getConnection(dbUrl, "webdb", "webdb"); 
			//DriverManager.getConnection(dbUrl,"webdb","webdb");


			//3. statement
			stmt=  connection.createStatement();

			//4. sql
			
			String sql = "select * from guestbook order by no desc";
			rs = stmt.executeQuery(sql);
			
			System.out.println("리스트 겟");

			//5 결과 가져오기

			while(rs.next()){
				no = rs.getLong( 1 );
				String name = rs.getString( 2 );
				String message = rs.getString( 3 );
				String regDate = rs.getString( 4 );
				
				GuestbookVo vo  = new GuestbookVo();
				
				vo.setNo( no );
				vo.setName( name );
				// vo.setPassword(password);
				vo.setMessage( message );
				vo.setRegDate( regDate );

				list.add(vo);
			}
						
			rs.close();
			stmt.close();
			connection.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 로딩 실패");
		} catch(SQLException ex){
			System.out.println("에러 - " + ex);
		} 
		

		return list;
	}

	public void insert(GuestbookVo vo){

		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try{
			//1 driver load
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//2. db con
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			connection =  DriverManager.getConnection(dbUrl, "webdb", "webdb"); 
			//DriverManager.getConnection(dbUrl,"webdb","webdb");

			//3. statement ready
			String sql = "insert into guestbook values(guestbook_seq.nextval,?,?,?,SYSDATE)";
			pstmt = connection.prepareStatement(sql);
			
			//4. binding
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getMessage());

			
			//5. sql 
			pstmt.executeUpdate();
			System.out.println("쿼리 insert 됨요");
			
			pstmt.close();
			connection.close();
	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 로딩 실패");
		} catch(SQLException ex){
			System.out.println("에러 - " + ex);
		}
		
	}
	
	
	public void delete(GuestbookVo vo){

		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try{
			//1 driver load
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//2. db con
			String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			connection =  DriverManager.getConnection(dbUrl, "webdb", "webdb"); 
			//DriverManager.getConnection(dbUrl,"webdb","webdb");

			//3. statement ready
			String sql = "delete from guestbook where no=? and password=?";
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setLong( 1, vo.getNo() );
			pstmt.setString( 2, vo.getPassword() );
			
			//5. sql 
			pstmt.executeUpdate();
			System.out.println("쿼리 delete 됨요");
			
			pstmt.close();
			connection.close();
	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 로딩 실패");
		} catch(SQLException ex){
			System.out.println("에러 - " + ex);
		}
		
	}
	
}
