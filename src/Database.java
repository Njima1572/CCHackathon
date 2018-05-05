import java.sql.*;
import java.util.ArrayList;


public class Database {
	
	public static final String PORT_NUMBER = "3306";
	public static Statement stmt;
	
	
	
	public static void executeSQL(String query, Statement statement) throws SQLException{
		statement.execute(query);
	}
	
	public static void connectServer() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:" + PORT_NUMBER + "/", "root", "root");
			System.out.println("Connection made");

			stmt = connection.createStatement();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public static void createAndUseDatabase() {
		try {
			connectServer();	
			executeSQL("CREATE DATABASE IF NOT EXISTS Apartments;" + "USE Apartments;", stmt);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void createBuildingTable() {
		try {
			connectServer();
			stmt.execute("create table if not exists Apartments("
					+ "name varchar(20),"
					+ "id int,"
					+ "primary key(id);");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * aptid would be 3 digits for building and 3 digits for the room number
	 */
	public static void createRoomTable() {
		try {
			connectServer();
			stmt.execute("create table if not exists Rooms("
					+ "aptid int,"
					+ "lofted bit,"
					+ "goldcard bit,"
					+ "bathroomshower bit,"
					+ "bathroomNumber int,"
					+ "residentNumber int,"
					+ "doubleRoom int,"
					+ "primary key(aptid);");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void addApartment(int aptid, boolean lofted, boolean goldcard, boolean bathroomShower, int bathroomNumber, int residentNumber, int doubleRoom){
		try {
			connectServer();
			stmt.execute("insert into Rooms values(" + aptid + "," + goldcard + "," + bathroomShower + "," + bathroomNumber + "," + residentNumber + "," + doubleRoom);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
		
	
	public static void getIds(ArrayList<Integer> apartment_ids){
		try {
			connectServer();
			ResultSet rs = stmt.executeQuery("select aptid from rooms;");
			apartment_ids.add(rs.getInt(0));
			int idx = 1;
			while(rs.getInt(idx) != 0) {
				apartment_ids.add(rs.getInt(idx));
				idx++;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void findApartment(boolean lofted, boolean goldcard, boolean bathroomShower, int bathRoom, int residentNumber, int doubleRoom) {
//		try {
//			connectServer();
//			int result = stmt.executeQuery("select * from rooms where lofted = " + lofted + " and goldcard = " + goldcard + " and bathroomshower = " + bathroomShower + "and bathroomNumber = " + bathRoom + " and residentNumber = " + residentNumber + " and doulbeRoom = " + doubleRoom + ";").getInt("aptid");
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
	}
}
