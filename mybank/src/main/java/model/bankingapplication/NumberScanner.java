package model.bankingapplication;

import java.util.Scanner;
import java.util.logging.Logger;

public class NumberScanner
{
	Logger logger = Logger.getLogger("input logger");
	public int intInput(Scanner sc)
	{
		int choice = 0;
		boolean ex = true;
		do
		{
			try
			{
				choice = sc.nextInt();
				ex = false;
			}
			catch(Exception e)
			{
				logger.info("the entered value is not an integer, please input correct value");
				sc.nextLine();
				ex = true;
			}
		}while(ex);
		return choice;
	}
	public float floatInput(Scanner sc)
	{
		float choice = 0;
		boolean ex = true;
		do
		{
			try
			{
				choice = sc.nextFloat();
				ex = false;
			}
			catch(Exception e)
			{
				logger.info("the entered value is not an floating value, please input correct value");
				sc.nextLine();
				ex = true;
			}
		}while(ex);
		return choice;
	}
}
