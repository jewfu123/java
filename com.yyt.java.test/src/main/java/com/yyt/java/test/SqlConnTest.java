package com.yyt.java.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SqlConnTest {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        final String jdbcId = "root";
        final String jdbcPass = "123456";
        final String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/jsh_erp";
        
        Connection cn = DriverManager.getConnection(jdbcUrl, jdbcId, jdbcPass);
        PreparedStatement st = cn.prepareStatement("show databases");
        
        try {
        	//throw new Exception("sql error.");
        	//SQLException xx = new SQLException("SQL Exception has been happened!!");
        	//System.out.println(xx.getMessage());
        	//ThrowSqlExceptionFun();
        	ResultSet rs = st.executeQuery();
        	if (gobackTest()==true) {
        		System.out.println("You called back boolean function");
        		return;
        	};
	        while( rs.next() )
	        {
	            System.out.println( rs.getString(1));
	        }
	        rs.close();
        }
        catch (SQLException ex) {
        	System.out.println(ex.getMessage());
        } finally {
        	
            st.close();
            cn.close();
        }
    }
    
    public static void ThrowSqlExceptionFun() throws SQLException {
    	throw new SQLException("Sql Exception Happenped!!");
    }
    
    public static boolean gobackTest() {
    	return true;
    }
}

