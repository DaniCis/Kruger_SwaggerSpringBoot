
  package com.kruger.microservice.test;
  
 /**
	 * Code example from "Foundational Java: Key Elements and Practical
	 * Programming", London: Springer 2012
	 * 
	 * @author David Parsons
	 * 
	 *         ISO216Document class - example unit under test
	 */
		  
		  public class ISO216Document { 
			  private int width; 
			  private int height;
		  
		  public ISO216Document(int width, int height) { 
			  setWidth(width);
		  setHeight(height); }
		  
		  public ISO216Document(String size) { 
			  if(size.equalsIgnoreCase("A4")) {
		  setWidth(210); setHeight(297); } 
			  if(size.equalsIgnoreCase("A3")) {
		  setWidth(297); setHeight(420); } }
		  
		  public int getWidth() { return width; }
		  
		  public void setWidth(int width) { this.width = width; }
		  
		  public int getHeight() { return height; }
		  
		  public void setHeight(int height) { this.height = height; } }
		 