package com.kruger.microservice.test;

import java.awt.Point;

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming", London: Springer 2012
 * 
 * @author David Parsons
 * 
 * TwoDimensionalShape class - abstract subclass with polymorphic method
 */

public abstract class TwoDimensionalShape extends Shape implements Transformable
{
	public TwoDimensionalShape(Point location, int dimension1, int dimension2)
	{
		super(location);
		int[] tempArray = {dimension1,dimension2};
		setDimensions(tempArray);
	}
	
	public int getHeight()
	{
		return dimensions[0];
	}
	
	public int getWidth()
	{
		return dimensions[1];
	}
	
	@Override
	public void setDimensions(int[] dim)
	{
		if (dim.length == 2)
		{
			super.setDimensions(dim);
		}
	}
	
	public void switchDimensions()
	{
		int temp = dimensions[0];
		dimensions[0] = dimensions[1];
		dimensions[1] = temp;
	}
}
