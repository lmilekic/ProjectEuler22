import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;


public class main {

	public static void main(String[] args) {
		Scanner names = null;
		try {
			names = new Scanner(new File("names.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] namesArray = cleanUpNames(names.nextLine());
		TreeSet<String> namesSet = makeTreeSet(namesArray);
		int sum = getSum(namesSet);
		System.out.println(sum);
	}

	private static int getSum(TreeSet<String> namesSet) {
		int sum = 0;
		int count = 1;
		for(String name:namesSet)
		{
			sum += count * nameScore(name);
			count++;
		}
		return sum;
	}

	private static int nameScore(String name) {
		int sum = 0;
		for(int i = 0; i < name.length(); i++)
		{
			sum += name.charAt(i) - 'A' + 1;
		}
		return sum;
	}

	private static TreeSet<String> makeTreeSet(String[] namesArray) {
		TreeSet<String> result = new TreeSet<String>();
		for(String name:namesArray)
		{
			result.add(name);
		}
		return result;
	}

	private static String[] cleanUpNames(String line) {
		line = line.substring(1, line.length()-1); //get rid of starting and trailing "
		return line.split("\",\"");
	}

}
