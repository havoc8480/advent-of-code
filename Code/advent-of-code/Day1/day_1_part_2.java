import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Vector;

public class day_1_part_2
{
	public static void main(String[] args)
	{
		try
		{
			File in_file = new File("day_1_input.txt");
			Scanner scanner = new Scanner(in_file);
			Vector<Integer> nums = new Vector<Integer>();
			int countOfSums = 0;
			int prevTotal = -1;

			//Read each from file, then place into an array
			while(scanner.hasNextInt())
			{
				int num = scanner.nextInt();
				nums.add(num);
			}

			scanner.close();

			// stop 2 from the end so that we get full sets of 3
			for(int i = 0; i < nums.size() - 2; i++)
			{
				int first  = nums.get(i);
				int second = nums.get(i+1);
				int third  = nums.get(i+2);

				int total = first + second + third;

				if((total > prevTotal) && prevTotal != -1)
					countOfSums++;

				// System.out.println("DEBUG:  " + first + " + " + second + " + " + third + " = " + total);
				// System.out.println("DEBUG:  prev: " + prevTotal + "  curr: " + total + "  count : " + countOfSums);

				prevTotal = total;
			}

			System.out.println("How many sums are larger than the previous sum?  " + countOfSums);

		}
		catch (FileNotFoundException e)
		{
			System.out.println("File not found!");
		}
	}
}
