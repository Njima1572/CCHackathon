
public class Apartment {
	
	private int aptid;
	private boolean goldCardAccess;
	private boolean lofted;
	private boolean bathroomShower;
	private int bathroomNumber;
	private int residentNumber;
	private int doubleRoomNumber;
	public Apartment(int _aptid, boolean _goldCardAccess, boolean _lofted, boolean _bathroomShower, int _bathroomNumber, int _residentNumber, int _doubleRoomNumber) {
		aptid = _aptid;
		goldCardAccess = _goldCardAccess;
		lofted = _lofted;
		bathroomShower = _bathroomShower;
		bathroomNumber = _bathroomNumber;
		residentNumber = _residentNumber;
		doubleRoomNumber = _doubleRoomNumber;
	}
	
	public int getAptid() {
		return aptid;
	}
	public void setAptid(int aptid) {
		this.aptid = aptid;
	}
	public boolean isGoldCardAccess() {
		return goldCardAccess;
	}
	public void setGoldCardAccess(boolean goldCardAccess) {
		this.goldCardAccess = goldCardAccess;
	}
	public boolean isLofted() {
		return lofted;
	}
	public void setLofted(boolean lofted) {
		this.lofted = lofted;
	}
	public boolean isBathroomShower() {
		return bathroomShower;
	}
	public void setBathroomShower(boolean bathroomShower) {
		this.bathroomShower = bathroomShower;
	}
	public int getBathroomNumber() {
		return bathroomNumber;
	}
	public void setBathroomNumber(int bathroomNumber) {
		this.bathroomNumber = bathroomNumber;
	}
	public int getResidentNumber() {
		return residentNumber;
	}
	public void setResidentNumber(int residentNumber) {
		this.residentNumber = residentNumber;
	}
	public int getDoubleRoomNumber() {
		return doubleRoomNumber;
	}
	public void setDoubleRoomNumber(int doubleRoomNumber) {
		this.doubleRoomNumber = doubleRoomNumber;
	}
	

}
