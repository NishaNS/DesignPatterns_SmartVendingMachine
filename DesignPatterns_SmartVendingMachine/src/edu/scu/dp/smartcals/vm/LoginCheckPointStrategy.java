package edu.scu.dp.smartcals.vm;

/**
 * @author Nisha Narayanaswamy
 * 
 *         Interface for security check point when user logs in to system
 *
 */

public interface LoginCheckPointStrategy {

	public boolean performSecurityCheck(String username);

}
