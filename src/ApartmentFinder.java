
public class ApartmentFinder {
	public ApartmentFinder() {
		
		
	}	
	
//	public Apartment[] filter(boolean goldcard, boolean lofted, boolean bathroomShower, int bathroomNumber, int residentNumber, int doubleRoom) {
//		
//		return
//	}
	
	public void addApartment(Apartment apt) {
		Database.addApartment(apt.getAptid(), apt.isLofted(), apt.isGoldCardAccess(), apt.isBathroomShower(), apt.getBathroomNumber(), apt.getResidentNumber(), apt.getDoubleRoomNumber());
	}
	
	
	
	public static void main(String[] args) {
		ApartmentFinder af = new ApartmentFinder();
		Apartment apt = new Apartment(100101, true, true, true, 1, 4, 1);
		Database.createAndUseDatabase();
		Database.createRoomTable();
		af.addApartment(apt);
	}
}
