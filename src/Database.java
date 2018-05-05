import java.sql.*;
import java.util.ArrayList;


public class Database {
	
	public static final String PORT_NUMBER = "8889";
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
			stmt.execute("CREATE DATABASE IF NOT EXISTS Apartments;");
			stmt.execute("USE Apartments;");

		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void createBuildingTable() {
		try {
			connectServer();
			stmt.execute("USE Apartments;");
			stmt.execute("create table if not exists Buildings("
					+ "name varchar(20),"
					+ "id int AUTO_INCREMENT,"
					+ "primary key(id));");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static int convertBuildingToInt(String buildingname) {
		try {
			connectServer();
			stmt.execute("USE Apartments;");
			ResultSet rset = stmt.executeQuery("Select * from Buildings Where name = '" + buildingname +"';");
			if(!rset.next()){
				addBuilding(buildingname);
				rset = stmt.executeQuery("Select * from Buildings Where name = '" + buildingname +"';");
				rset.next();
			}
			return rset.getInt("id");
		}catch(SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * aptid would be 3 digits for building and 3 digits for the room number
	 */
	public static void createRoomTable() {
		try {
			connectServer();
			stmt.execute("USE Apartments;");
			stmt.execute("create table if not exists Rooms("
					+ "aptid int,"
					+ "lofted bit,"
					+ "goldcard bit,"
					+ "bathroomshower bit,"
					+ "bathroomNumber int,"
					+ "residentNumber int,"
					+ "doubleRoom int,"
					+ "primary key(aptid));");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void addBuilding(String name) {
		try {
			connectServer();
			stmt.execute("USE Apartments;");
			stmt.execute("Insert into Buildings(name) values('" + name + "');");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void addApartment(int aptid, boolean lofted, boolean goldcard, boolean bathroomShower, int bathroomNumber, int residentNumber, int doubleRoom){
		try {
			connectServer();
			stmt.execute("USE Apartments;");
			stmt.execute("insert into Rooms values (" + aptid + ", " + lofted + ", "+ goldcard + ", " + bathroomShower + ", "
					 + bathroomNumber + ", " + residentNumber + ", " + doubleRoom + ");");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public static void addExamples() {
		try {
			connectServer();
			stmt.execute("USE Apartments;");
			stmt.execute("insert into Buildings values('JLK', 001);");
			stmt.execute("insert into Buildings values('Blanca', 002);");
			stmt.execute("insert into Buildings values('Antero', 003);");

		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<String> getBuildings(){
		ArrayList<String> buildings = new ArrayList<String>();

		try {
			connectServer();
			stmt.execute("USE Apartments;");
			ResultSet rset = stmt.executeQuery("Select * from buildings where id > 0;");
			while(rset.next()) {
				buildings.add(rset.getString("name"));
			}
			return buildings;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void getIds(ArrayList<Integer> apartment_ids){
		try {
			connectServer();
			stmt.execute("USE Apartments;");

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
	
	public static void initialize() {
		createAndUseDatabase();
		createBuildingTable();
		createRoomTable();
		addExamples();
	}
	
	public static ArrayList<Integer> findApartment(boolean lofted, boolean goldcard, boolean bathroomShower, int bathRoom, int residentNumber, int doubleRoom) {
		try {
			connectServer();
			stmt.execute("USE Apartments;");
			ResultSet result = stmt.executeQuery("select * from rooms where lofted = " + lofted + " and goldcard = " + goldcard + " and bathroomshower = " + bathroomShower + "and bathroomNumber = " + bathRoom + " and residentNumber = " + residentNumber + " and doulbeRoom = " + doubleRoom + ";");
			ArrayList<Integer> result_arraylist = new ArrayList<Integer>();
			while(result.next()) {
				result_arraylist.add(result.getInt("aptid")); 
			}
			return result_arraylist;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
