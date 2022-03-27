//This class holds information about a single Sprinting session
package com.stir.cscu9t4practical1;

public class SprintEntry extends Entry {

	private int quantity;
	private int recovery;
	
	public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist, int quant, int recov) {
		super(n, d, m, y, h, min, s, dist);
		this.quantity = quant;
		this.recovery = recov;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public int getRecovery() {
		return recovery;
	}
	
	public String getEntry () {
		   String result = getName()+" ran " + getQuantity() + " set(s) of "+ getDistance() + "m with " + getRecovery() + " minute rests in "
		             +getHour()+":"+getMin()+":"+ getSec() + " on "
		             +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
		   return result;
		  }

}
