package com.kruger.microservice.test;

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming", London: Springer 2012
 * 
 * @author David Parsons
 * 
 * Course class with IllegalArgumentException thrown in the 'setNumberOfDays' method
 */

public class Course
{
	private static int numberOfCoursesCreated = 0;
	private String name;
	private int numberOfDays;
	private double price;
	// an array of modules
	private Module[] modules = new Module[20];
	private int moduleCount = 0;

	/**
	 * zero arguments constructor
	 * @throws NullParameterException
	 */
	public Course() 
	{
		this("Unnamed Course", 3, 1000.0);
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            The name of the course
	 * @param days
	 *            The length of the course in days
	 * @param price
	 *            The price of the course per person
	 */
	public Course(String name, int days, double price) throws IllegalArgumentException
	{
		setName(name);
		setNumberOfDays(days);
		setPrice(price);
		numberOfCoursesCreated++;
	}

	/**
	 * @return How many Course objects have been created
	 */
	public static int getNumberOfCoursesCreated()
	{
		return numberOfCoursesCreated;
	}

	/**
	 * @return The name of the course
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name
	 *            The name of the course
	 */
	public void setName(String name) throws NullPointerException
	{
		if(name == null)
		{
			throw new NullPointerException("Course name is null");
		}
		this.name = name;
	}

	/**
	 * @return The length of the course
	 */
	public int getNumberOfDays()
	{
		return numberOfDays;
	}

	/**
	 * @param numberOfDays
	 * @throws IllegalArgumentException
	 */
	public void setNumberOfDays(int numberOfDays) throws IllegalArgumentException
	{
		if (numberOfDays < 1 || numberOfDays > 10)
		{
			throw new IllegalArgumentException(numberOfDays + " is outside the valid range of 1 - 10");
		}
		else
		{	
			this.numberOfDays = numberOfDays;
		}
	}

	/**
	 * @return The price of the course per person
	 */
	public double getPrice()
	{
		return price;
	}

	/**
	 * @param price
	 *            The price of the course per person
	 */
	public void setPrice(double price)
	{
		this.price = price;
	}

	// 'addModule' adds a parameter module to the array.
	public void addModule(Module new_module)
	{
		if (moduleCount < modules.length)
		{
			modules[moduleCount] = new_module;
			moduleCount++;
		}
		else
		{
			System.out.println("Cannot add more modules");
		}
	}

	public int getTotalCredits()
	{
		int total = 0;
		for (int i = 0; i < getModuleCount(); i++)
		{
			total += getModules()[i].getCreditPoints();
		}
		return total;
	}

	public final Module[] getModules()
	{
		return modules;
	}

	public final int getModuleCount()
	{
		return moduleCount;
	}

}
