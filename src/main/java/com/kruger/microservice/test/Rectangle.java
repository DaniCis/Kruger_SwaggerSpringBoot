package com.kruger.microservice.test;

import java.awt.Graphics;
import java.awt.Point;

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming", London: Springer 2012
 * 
 * @author David Parsons
 * 
 * Rectangle class - concrete subclass with polymorphic methods
 */

public class Rectangle extends TwoDimensionalShape
{
	public Rectangle(Point location, int height, int width)
	{
		super(location, height, width);
	}

	@Override
	public double getArea()
	{
		return (this.getHeight() * this.getWidth());
	}

	@Override
	public void draw(Graphics g)
	{
		g.fillRect(getLocation().x, getLocation().y, getHeight(), getWidth());
	}

}
