import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class day_2
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

			// Forward    + horizontal
			// Down       + depth
			// Up         - depth

			while(scanner.hasNextLine())
			{
				String line = scanner.nextLine();
				//System.out.println("line: " + line);
				String[] result = line.split("\\s+");
				// System.out.println("result[0]: " + result[0]);
				// System.out.println("result[1]: " + result[1]);
				// System.out.println("Integer.parseInt(result[1]): " + result[1]);

				direction = result[0];
				amount = Integer.parseInt(result[1]);

				if(direction.equals("forward"))
					horizontal += amount;
				if(direction.equals("down"))
					depth += amount;
				if(direction.equals("up"))
					depth -= amount;
			}

			int num = horizontal * depth;
			System.out.println("Horizontal: " + horizontal);
			System.out.println("Depth:      " + depth);
			System.out.println("What do you get if you multiply your final horizontal position by your final depth?  " + num);


		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found!");
		}
	}
}
