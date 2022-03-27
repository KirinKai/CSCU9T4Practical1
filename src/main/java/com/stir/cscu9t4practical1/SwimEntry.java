package com.stir.cscu9t4practical1;

public class SwimEntry extends Entry{

	
	private String locale;
	
	public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String locale) {
		super(n, d, m, y, h, min, s, dist);
		this.locale = locale;
	}
	
	public String getLocale() {
		if(locale.equalsIgnoreCase("outside")) {
			return locale;
		}
		
		if(locale.equalsIgnoreCase("pool")) {
			return "in a pool";
		}
		return locale;
	}
	
	public String getEntry () {
		   String result = getName()+" swam " + getDistance() + " km " + getLocale() + " in "
		             +getHour()+":"+getMin()+":"+ getSec() + " on "
		             +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
		   return result;
		  }


}
