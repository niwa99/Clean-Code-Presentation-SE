import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LotterySimulationClean {
	
	private Scanner scanner;
	private Random random;
	private boolean shouldGenerateAnotherRound;
	private int amountOfRounds;
	private final int amountLotteryNumbers = 6;
	private List<Integer> randomGeneratedNumbers;
	private int bonusNumber;
	
	public static void main(String[] args) {
		LotterySimulationClean lottery = new LotterySimulationClean();
		lottery.startLotteryProgram();
	}
	
	public void startLotteryProgram() {
		initializeLotteryData();
		performLotteryActivities();
	}
	
	private void initializeLotteryData() {
		scanner = new Scanner(System.in);
		random = new Random();
		shouldGenerateAnotherRound = true;
		amountOfRounds = 0;
		randomGeneratedNumbers = new ArrayList<Integer>();
	}
	
	private void performLotteryActivities() {
		while (shouldGenerateAnotherRound) {
			amountOfRounds++;
			randomGeneratedNumbers.clear();
			generateRandomNumbers();
			generateBonusNumber();
			printAllNumbersToConsole();
			askUserForAnotherRound();
		}
		System.out.println("Thanks for using the program!");
		scanner.close();
	}
	
	private void generateRandomNumbers() {
		while (randomGeneratedNumbers.size() < amountLotteryNumbers) {
			boolean isUniqueNumber = false;
			while (!isUniqueNumber) {
				int randomNumber = random.nextInt(49)+1;
				if (!randomGeneratedNumbers.contains(randomNumber)) {
					randomGeneratedNumbers.add(randomNumber);
					isUniqueNumber = true;
				}
			}
		}
		Collections.sort(randomGeneratedNumbers);
	}
	
	private void generateBonusNumber() {
		bonusNumber = random.nextInt(10);
	}
	
	private void printAllNumbersToConsole() {
		System.out.println(amountOfRounds+". Round: ");
		
		System.out.print("Numbers: ");
		for (int elementIndex = 0; elementIndex < amountLotteryNumbers; elementIndex++) {
			System.out.print(randomGeneratedNumbers.get(elementIndex));
			if (elementIndex != amountLotteryNumbers-1) {
				System.out.print(", ");
			}
		}
		System.out.println();
		
		System.out.println("Bonus number: " + bonusNumber);
	}
	
	private void askUserForAnotherRound() {
		System.out.print("Start another round? (y for yes) ");
		if (!scanner.next().equalsIgnoreCase("y")) {
			shouldGenerateAnotherRound = false;
		} else {
			randomGeneratedNumbers.clear();
		}
		System.out.println();
	}
}
