package database;

import java.sql.Connection;

public class Demo {

	public static void main(String[] args) {
		
		Connection conn = DBUtil.getConnection();
		
		System.out.println(conn);

	}

}
