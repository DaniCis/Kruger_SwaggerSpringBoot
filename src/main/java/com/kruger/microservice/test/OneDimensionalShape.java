package com.kruger.microservice.test;

import java.awt.Point;

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming", London: Springer 2012
 * 
 * @author David Parsons
 * 
 * OneDimensionalShape class - abstract subclass with polymorphic method
 */

public abstract class OneDimensionalShape extends Shape
{
	public OneDimensionalShape(Point location, int dimension)
	{
		super(location);
		int[] tempArray = { dimension };
		setDimensions(tempArray);
	}

	public int getDimension()
	{
		return dimensions[0];
	}

	@Override
	public void setDimensions(int[] dim)
	{
		if (dim.length == 1)
		{
			super.setDimensions(dim);
		}
	}
}
