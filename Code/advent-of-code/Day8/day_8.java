import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

//   0:      1:      2:      3:      4:
//  aaaa    ....    aaaa    aaaa    ....
// b    c  .    c  .    c  .    c  b    c
// b    c  .    c  .    c  .    c  b    c
//  ....    ....    dddd    dddd    dddd
// e    f  .    f  e    .  .    f  .    f
// e    f  .    f  e    .  .    f  .    f
//  gggg    ....    gggg    gggg    ....
//
//   5:      6:      7:      8:      9:
//  aaaa    aaaa    aaaa    aaaa    aaaa
// b    .  b    .  .    c  b    c  b    c
// b    .  b    .  .    c  b    c  b    c
//  dddd    dddd    ....    dddd    dddd
// .    f  e    f  .    f  e    f  .    f
// .    f  e    f  .    f  e    f  .    f
//  gggg    gggg    ....    gggg    gggg
//
// 0: abcefg
// 1: cf      *    2 digits
// 2: acdeg
// 3: acdfg
// 4: bcdf    *    4 digits
// 5: abdfg
// 6: abdefg
// 7: acf     *    3 digits
// 8: abcdefg *    7 digits
// 9: abcdfg

public class day_8
{
	public static void main(String[] args)
	{
		try
		{
			File in_file = new File("day_8_input.txt");
			Scanner scanner = new Scanner(in_file);
			int total = 0;

			while(scanner.hasNextLine())
			{
				String line = scanner.nextLine();
				String[] timeLine = line.split("\\| ");
				String[] outputLine = timeLine[1].split(" ");

				for(int i = 0; i < 4; i++)
				{
					int len = outputLine[i].length();
					if(len == 2 || len == 3 || len == 4 || len == 7)
						total++;
				}
			}
			System.out.println("How many total? " + total);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found!");
		}

	}
}
