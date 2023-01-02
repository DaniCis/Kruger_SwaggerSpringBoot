package com.kruger.microservice.test;

import java.awt.Graphics;
import java.awt.Point;

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming", London: Springer 2012
 * 
 * @author David Parsons
 * 
 * Shape class - abstract superclass with abstract methods
 */

public abstract class Shape
{
	protected Point location;
	protected int[] dimensions;
		
	public Shape(Point location)
	{
		setLocation(location);
	}
	
	public int[] getDimensions()
	{
		return dimensions;
	}

	public void setDimensions(int[] dim)
	{
		this.dimensions = dim;
	}

	public Point getLocation()
	{
		return location;
	}

	public void setLocation(Point location)
	{
		this.location = location;
	}
	
	public abstract double getArea();
	
	public abstract void draw(Graphics g);
	
}
