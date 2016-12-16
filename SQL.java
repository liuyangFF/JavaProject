import java.sql.*;


public class SQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url="jdbc:sqlserver://localhost:1433; DatabaseName=Admin";
		String dbname="sa";
		String dbpwd="sa";                 //sa对应的密码
		 
		@SuppressWarnings("unused")
		String str = new String("UTF-8");
				
				@SuppressWarnings("unused")
				Connection con=null;
		
		
			try{
				Class.forName(driver);
				System.out.println("数据库驱动加载成功");
			}catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				 System.out.println("数据库驱动加载失败");
			}
		
			try {
				con=DriverManager.getConnection(url,dbname,dbpwd);
			    System.out.println("数据库连接成功");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("数据库连接失败");
			}		
		}
		
		//根据其他类得来的sql语句，执行数据库的查询操作，返回一个ResultSet对象
		@SuppressWarnings("null")
		public static ResultSet executeQuery(String sql){
			try{
				Object con = null;
				if(con==null)
					new SQL();
				return ((Connection) con).createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery(sql);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}		
		}
		
		//根据其他类得来的SQL语句，执行数据库的添加、删除和更新操作,返回一个int对象
		@SuppressWarnings("null")
		public static int executeUpdate(String sql){
			try{
				Object con = null;
				if(con==null)
					new SQL();
				return ((Connection) con).createStatement().executeUpdate(sql);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				return -1;
			}finally{   }		
		}


		//关闭连接对象
		public static void close(){
			@SuppressWarnings("unused")
			SQL con;
			try{
				SQL.close();
			}finally{
				con=null;
			}		


	}

}
