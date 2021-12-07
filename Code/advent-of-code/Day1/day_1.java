import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class day_1
{
	public static void main(String[] args)
	{
		int countOfMeasures = 0;
		try
		{
			File in_file = new File("day_1_input.txt");
			Scanner scanner = new Scanner(in_file);
			int prevNum = -1; //assuming all numbers are positive

			while(scanner.hasNextInt())
			{
				int currNum = scanner.nextInt();

				if((currNum > prevNum) && prevNum != -1)
					countOfMeasures++;

				//System.out.println("DEBUG: " + prevNum + "  " + currNum + "  : " + countOfMeasures);

				prevNum = currNum;  //save previous number for comparison later
			}

			scanner.close();

			System.out.println("How many measurements are larger than the previous measurement?  " + countOfMeasures);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not found!");
		}
	}
}
