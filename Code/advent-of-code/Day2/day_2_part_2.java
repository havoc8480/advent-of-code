import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class day_2_part_2
{
	public static void main(String args[])
	{
		try
		{
			File in_file = new File("day_2_input.txt");
			Scanner scanner = new Scanner(in_file);

			String direction = "";
			Integer amount = 0;

			int horizontal = 0;
			int depth = 0;
			int aim = 0;

			// Down      + aim
			// Up        - aim
			// Forward   + horizontal
			//   AND     depth = forward * aim

			while(scanner.hasNextLine())
			{
				String line = scanner.nextLine();
				String[] result = line.split("\\s+");

				direction = result[0];
				amount = Integer.parseInt(result[1]);

				if(direction.equals("down"))
					aim += amount;
				if(direction.equals("up"))
					aim -= amount;
				if(direction.equals("forward"))
				{
					horizontal += amount;
					depth += (amount * aim);
				}

			}

			int num = horizontal * depth;
			System.out.println("Horizontal: " + horizontal);
			System.out.println("Depth:      " + depth);
			System.out.println("Aim:        " + aim);
			System.out.println("What do you get if you multiply your final horizontal position by your final depth?  " + num);


		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found!");
		}
	}
}
