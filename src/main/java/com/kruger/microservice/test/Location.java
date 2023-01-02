package com.kruger.microservice.test;

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming", London: Springer 2012
 * 
 * @author David Parsons
 * 
 * Location class
 */

public class Location
{
	private String address;
	private int capacity;
	private double pricePerDay;

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public int getCapacity()
	{
		return capacity;
	}

	public void setCapacity(int capacity)
	{
		this.capacity = capacity;
	}

	public double getPricePerDay()
	{
		return pricePerDay;
	}

	public void setPricePerDay(double pricePerDay)
	{
		this.pricePerDay = pricePerDay;
	}

	@Override
	public String toString()
	{
		return this.getClass().getSimpleName() + " " + getAddress() + " holds "
				+ getCapacity() + " and costs " + getPricePerDay() + " per day";
	}

	@Override
	public boolean equals(Object object)
	{
		if (object == null || !(object.getClass().equals(this.getClass())))
		{
			return false;
		}
		Location other = (Location) object;
		if (getAddress() == other.getAddress()
				&& getCapacity() == other.getCapacity()
				&& getPricePerDay() == other.getPricePerDay())
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public int hashCode()
	{
		return getAddress().hashCode() + getCapacity() + (int) getPricePerDay();
	}
}
