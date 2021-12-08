import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Vector;

public class day_6
{
	public static void main(String[] args)
	{
		try
		{
			File in_file = new File("day_6_input.txt");
			//File in_file = new File("day_6_test_input.txt");
			Scanner scanner = new Scanner(in_file);
			Vector<Integer> fish = new Vector<Integer>();
			int fishToAdd = 0;

			while(scanner.hasNextLine())
			{
				String line = scanner.nextLine();
				String[] fishLine = line.split(",");
				for(int i = 0; i < fishLine.length; i++)
					fish.add(Integer.valueOf(fishLine[i]));
			}

			scanner.close();

			System.out.println("Running for 80 days...");
			//for 80 days
			for(int i=0; i < 80; i++)
			{
				System.out.println("Day " + i);
				fishToAdd = 0;
				//loop through our fishes
				for(int j = 0; j < fish.size(); j++)
				{
					if(fish.get(j) == 0)  //fish is ready to create new baby fish
					{
						fish.set(j, 6); //reset this fish to 6
						fishToAdd++; //mark that we need to add a new baby fish
					}
					else //subtract 1 from the fish
					{
						int currNum = fish.get(j);
						fish.set(j, currNum - 1);
					}
				}
				for(int k = 0; k < fishToAdd; k++)
					fish.add(8); //add baby fish with 8
			}

			System.out.println("80 days done!");


			System.out.println("How many lantern fish? " + fish.size());

		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found!");
		}

	}
}
