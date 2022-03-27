// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;


import java.util.*;


public class TrainingRecord {
    private List<Entry> tr;
    
    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor
    
    // add a record to the list
   public void addEntry(Entry e){
       tr.add(e);    
   } // addClass
   
   // look up the entry of a given day and month
   public String lookupEntry (int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "No Entries Found";
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
             result = current.getEntry();
            }
       return result;
   } // lookupEntry
   
   // find all the entries of a given day and month
   public String findallEntry (int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "";
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
             result += current.getEntry();
            }
       
       if (result == "") result = "No Entries Found";
       return result;
   } // findallEntry
   
   
   // Count the number of entries
   public int getNumberOfEntries(){
       return tr.size();
   }
   // Clear all entries
   public void clearAllEntries(){
       tr.clear();
   }

   public String uniqueValidate(String n, int m, int d, int y) {
	   String message = "";
	   ListIterator<Entry> iter = tr.listIterator();
	   
	   while (iter.hasNext()) {
		   Entry current = iter.next();
		   if (current.getName().equalsIgnoreCase(n) && current.getDay()==d && current.getMonth()==m && current.getYear()==y)
			   message = "Error, This Entry already exists";
		   }
	   
	   return message;
}

   public String removeEntry(String n, int d, int m, int y) {
	   ListIterator<Entry> iter = tr.listIterator();
       String result = "Specified Entry not found.";
       int indexRemove = -1;
       while (iter.hasNext()) {
    	   Entry current = iter.next();
    	   if (current.getName().equalsIgnoreCase(n) && current.getDay()==d && current.getMonth()==m && current.getYear()==y)
    		   
    		   indexRemove = tr.indexOf(current);
            }
       if(indexRemove != -1) {
    	   tr.remove(indexRemove);
    	   result = "Entry Removed.";
       }
	   return result;
}
   
} // TrainingRecord