/*importing csv, creating people, adding to array*/
//rpints the location which is not good  

import java.io.*;  
import java.util.Scanner;
import java.util.ArrayList;   

public class SrSeminar {
	 
	//tutorial for importaing csv from https://www.javatpoint.com/how-to-convert-string-to-json-object-in-java*
	public static void main(String[] args) throws Exception  
	{  
		//array list to add every element into
		ArrayList<String> x = new ArrayList<String>();
		
		//parsing a CSV file into Scanner class constructor  
		Scanner sc = new Scanner(new File("SrSeminar_RawData - SrSeminar_RawData.csv"));  
		sc.useDelimiter(",");   //sets the delimiter pattern  
		
		while (sc.hasNext())  //returns a boolean value  
			{  
			//System.out.print(sc.next());  //find and returns the next complete token from this scanner  
			x.add(sc.next()); //adding tokens into arraylist
			} 
		  
		sc.close();  //closes the scanner  
		
		//removing empty elements 
		while (x.contains("")) {
			int a = x.indexOf(""); 
			x.remove(a); 
		}
		//System.out.println(x); //prints ArrayList
		
		
		//assuming the first appearance of the seminar is at index 3, given format of csvs is the same *
		String firstSeminar = x.get(3); 
		
		//making arrayList to be put in SrStudent class 
		ArrayList<String> y = new ArrayList<String>(x.subList(0, x.lastIndexOf(firstSeminar))); //lastIndexOf(first seminar) is the first time it is tied toa presenter instead of a student 
		ArrayList srSt = new ArrayList<>(); //arrayList of Student objects
		
		//for loop of making student objects and adding them to list srSt
		int stInd = 0; //student index for adding objects
			for (int i = 0; i < y.size()/13; i++){ //13 is the number of elements per student
				SrStudent st = new SrStudent(y.get(stInd), y.get(stInd + 1), y.get(stInd + 2), y.get(stInd + 3), y.get(stInd + 4), y.get(stInd + 5), y.get(stInd + 6), y.get(stInd + 7), y.get(stInd + 8), y.get(stInd + 9), y.get(stInd + 10), y.get(stInd + 11), y.get(stInd + 12)); 
				stInd = stInd + 13; //increase by 13, going to the next student
				srSt.add(st); //add to the student array  
			}
		System.out.println(srSt); 
		
		//making arrayList to be put in SrPresenter class
		ArrayList<String> z = new ArrayList<String>(x.subList(x.lastIndexOf(firstSeminar), x.size())); 
		ArrayList srPr = new ArrayList<>(); //arrayList of presenter objects
		//for loop of making presenter objects and addinf them to list srPr
		int prInd = 0; //presenter index for adding objects
			for (int i = 0; i < z.size()/4; i++) {
				SrPresenter pr = new SrPresenter(z.get(prInd), z.get(prInd + 1), z.get(prInd + 2), z.get(prInd + 3)); 
				prInd = prInd + 4; 
				srPr.add(pr); 
			}
		System.out.println(srPr); 
		
	}//close main 
	  
}//close class
