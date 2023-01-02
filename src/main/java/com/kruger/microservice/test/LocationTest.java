package com.kruger.microservice.test;

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming", London: Springer 2012
 * 
 * @author David Parsons
 * 
 * LocationTest class
 */

public class LocationTest
{
	public static void main(String[] args)
	{
		
		  Location classroom1 = new Location();
		  classroom1.setAddress("4th Floor, New Bank Building");
		  classroom1.setCapacity(20); classroom1.setPricePerDay(300.0);
		  
		  Location classroom2 = new Location();
		  classroom2.setAddress("Seminar room 5, Central University Computing Lab");
		  classroom2.setCapacity(40); classroom2.setPricePerDay(450.0);
		  
		  Location classroom3 = new Location();
		  classroom3.setAddress("Seminar room 5, Central University Computing Lab");
		  classroom3.setCapacity(40); classroom3.setPricePerDay(450.0);
		  
		  System.out.println("Classroom one: " + classroom1);
		  System.out.println("Classroom two: " + classroom2);
		  System.out.println("Classroom three: " + classroom3);
		  
		  boolean isEqual = classroom2.equals(classroom3); if (isEqual) {
		  System.out.println(classroom2 + " is equal to " + classroom3); } else {
		  System.out.println(classroom2 + " is not equal to " + classroom3); }
		  System.out.println("Classroom one hashcode: " + classroom1.hashCode());
		  System.out.println("Classroom two hashcode: " + classroom2.hashCode());
		  System.out.println("Classroom three hashcode: " + classroom3.hashCode());
		 
	}
}
