package com.kruger.microservice.test;

// import java.util.Random; // only needed for alternative code (below)

/**
 * Code example from "Foundational Java: Key Elements and Practical Programming", London: Springer 2012
 * 
 * @author David Parsons
 *
 * A class that simulates a die that can be rolled
 */

public class Die
{
	public int getRoll()
	{
		// generate a random number in the range 0.0 to 1.0
		double randomNumber = Math.random();
		// to get a number in the range 1 to 6, we need to multiply the
		// random number by 6 and add 1
		randomNumber *= 6;
		randomNumber++;
		// to convert this value into an integer we cast it
		return (int) randomNumber;
		
		// Alternative code using the Random class
		// Random randomNumberGenerator = new Random();
		// int randomNumber = randomNumberGenerator.nextInt(6) + 1;
		// return randomNumber;
	}
}
