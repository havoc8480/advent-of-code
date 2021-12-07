import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Vector;
import java.util.Arrays;

public class day_3
{
	public static void main(String[] args)
	{
		try
		{
			File in_file = new File("day_3_input.txt");
			Scanner scanner = new Scanner(in_file);
			Vector<String> allTheBinaries = new Vector<String>();

			String gammaRateBits = "";
			String epsilonRateBits = "";

			while(scanner.hasNextLine())
			{
				String line = scanner.nextLine();
				allTheBinaries.add(line);
			}

			//find how many digits are in each
			int howManyDigits = allTheBinaries.get(0).length();
			//System.out.println("how long is each binary?  " + howManyDigits);
			//find out how long the list is
			int lengthOfBinariesList = allTheBinaries.size();
			//System.out.println("How many binaries do we have?  " + lengthOfBinariesList);


			//Create 2d Array of digits
			String[][] digits = new String[lengthOfBinariesList][howManyDigits];

			for(int i = 0; i < lengthOfBinariesList; i++)
			{
			//	System.out.println("iterate through allTheBinaries:  i = " + i);
				for(int j = 0; j < howManyDigits; j++)
				{
				//	System.out.println("iterate through howMany:  j = " + j);
					digits[i][j] = Character.toString(allTheBinaries.get(i).charAt(j));
				//	System.out.println("What is our digit?  " + digits[i][j]);
				}
			}

			// System.out.println(Arrays.deepToString(digits).replace("],","\n").replace(",","\t| ").replaceAll("[\\[\\]]", " "));

			for(int col = 0; col < howManyDigits; col++)
			{
				int onesCount = 0;
				int zerosCount = 0;

				for(int row = 0; row < lengthOfBinariesList; row++)
				{
					if(digits[row][col].equals("0"))
						zerosCount++;
					else
						onesCount++;
				}
				//System.out.println("Column  #" + col + " 's most common number is 0");
				if(zerosCount > onesCount)
				{

					gammaRateBits += '0';
					epsilonRateBits += '1';
				}

				else
				{
				//	System.out.println("Column  #" + col + " 's most common number is 1");
					gammaRateBits += '1';
					epsilonRateBits += '0';
				}

			}

			System.out.println("Gamma Rate Bits: " + gammaRateBits);
			System.out.println("epsilonRateBits: " + epsilonRateBits);

			int gamma = Integer.parseInt(gammaRateBits,2);
			int epsilon = Integer.parseInt(epsilonRateBits,2);
			int powerConsumption = gamma * epsilon;
			System.out.println("gamma : " + gamma);
			System.out.println("epsilon : " + epsilon);
			System.out.println("Power comsumption: " + powerConsumption);


			}
			catch(FileNotFoundException e)
			{
				System.out.println("File not found!");
			}

	}
}
