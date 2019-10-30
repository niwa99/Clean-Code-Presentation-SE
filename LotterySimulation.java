import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//This program generates every run six lottery numbers out of 49 as well as a bonus number from zero to nine.
//After generating the numbers, those are printed on the console and the user is asked for another lottery-number-round.
public class LotterySimulation {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n= 0;
		Random r = new Random();
		List<Integer> numbers = new ArrayList<Integer>();
		while  (true) { //in this loop, a round gets generated
			n++;
			for (int i=0;i<6;i++) { //generate 6 numbers
				while(true) { //loop for duplication-check
					int num = r.nextInt(49)+1;
					if(!numbers.contains(num))   {
						numbers.add(num);
						break;
					}
				}
			}
			Collections.sort(numbers);
			//print the data
			System.out.println(n+". Round: ");
			System.out.println(numbers.get(0)+", "+numbers.get(1)+", "+numbers.get(2)+", "+numbers.get(3)+", "+numbers.get(4)+", "+numbers.get(5));
			System.out.println("Bonus number: "+r.nextInt(10));
			//ask for another round
			System.out.print("Start another round? (y for yes) ");
			if(!s.next().equalsIgnoreCase("y")) break;
			else numbers.clear();
			System.out.println();
		}
	System.out.println("Thanks for using the program!");
	s.close();
	}
}