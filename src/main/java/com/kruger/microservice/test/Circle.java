package com.kruger.microservice.test;

import java.awt.Graphics;
import java.awt.Point;

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming", London: Springer 2012
 * 
 * @author David Parsons
 * 
 * Circle class - concrete subclass with polymorphic methods
 */

public class Circle extends OneDimensionalShape
{
	public Circle(Point location, int radius)
	{
		super(location, radius);
	}

	@Override
	public double getArea()
	{
		return (Math.PI * (Math.pow(this.getDimension(), 2.0)));
	}

	@Override
	public void draw(Graphics g)
	{
		g.fillOval(getLocation().x, getLocation().y, getDimension(), getDimension());
	}
}
