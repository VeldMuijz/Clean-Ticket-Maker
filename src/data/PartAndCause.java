package data;

import java.util.ArrayList;

/**
 * In this class there will be a set of arraylists which will fill the comboBoxes. 
 * The comboBoxes will be filled with a condition. The comboBoxPart determines
 * which options you have in the comboBoxCause. This way you can only get the right
 * cause for you part.
 * @author vm
 */
public class PartAndCause {
	
	
	String mtcCode;
	String munt;
	//Initialize the ArrayLists
	public ArrayList causeRpnt = new ArrayList();
	public ArrayList causeCash = new ArrayList();
	public ArrayList causeCoin = new ArrayList();
	public ArrayList causeG4S = new ArrayList();
	public ArrayList causeConnection = new ArrayList();
	public ArrayList causeFinance = new ArrayList();
	public ArrayList<String> part = new ArrayList<String>();
	
	
	
	/**
	 * This method fills the arrayLists
	 */
	public void arrayListFill(){
		
		//fill the arrayList part
		part.add("CASH");
		part.add("COIN");
		part.add("CONNECTION");
		part.add("FINANCE");
		part.add("G4S");
		part.add("RPNT");

	
				
		//fill the arrayListRPNT
		causeRpnt.add("Bonrol op");
		causeRpnt.add("Vastgelopen");
		causeRpnt.add("PrintCassCounter");
		
		//fill the arrayListCash
		causeCash.add("2xRetract");
		causeCash.add("Vastloper MTC " + mtcCode);
		causeCash.add("Dispenser");
		causeCash.add("BIM");
		causeCash.add("ESCROW");
		causeCash.add("I/O Module");
		causeCash.add("MetalSensor");
		
		//fill the arrayListCoin
		causeCoin.add("Vastloper");
		causeCoin.add("Afkeur munten: " + munt);
		
		//fill the arrayListG4S
		causeG4S.add("StandardExchange");
		causeG4S.add("CardCounter");
		causeG4S.add("SealBags");
		causeG4S.add("Retracts");
		causeG4S.add("ServicingTotaal");
		
		//fill the arrayListConnection
		causeConnection.add("TELE2");
		causeConnection.add("Router");
		causeConnection.add("StroomStoring");
		
		//fill the arrayList
		causeFinance.add("BalanceLedger");
		causeFinance.add("Promis");
	
			
	}
	
	
}
