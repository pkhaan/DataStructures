import java.io.*;
import java.util.NoSuchElementException;

public class NetBenefit {

	public static void main(String[] args) {

		try {

			BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));

			IntQueueImpl<Integer> pricesQueue = new IntQueueImpl<Integer>(); // a queue that contains one price element
																				// for each stock entry

			int k;
			int pureBenefit = 0;

			String currLine;
			while ((currLine = bufferedReader.readLine()) != null) { // parsing begins
				if (currLine.startsWith("buy")) { // add quantity and price to their respective queues

					k = 4; // starting point of first integer in line
					int stocksBuyed = getNextInt(currLine, k, ' '); // quantity of stocks buyed

					k = currLine.indexOf("price") + 6; // starting point of price integer in line
					int priceOfPurchase = getNextInt(currLine, k, '\n'); // price of the stock purchase

					// fill pricesQueue with as many price entries as stocks purchased
					for (int i = 0; i < stocksBuyed; i++)
						pricesQueue.put(priceOfPurchase);

				} else if (currLine.startsWith("sell")) { // calculate the profit at the moment and update queue

					k = 5; // starting point of first integer in line
					int quantityToSell = getNextInt(currLine, k, ' '); // quantity of stocks for sale

					k = currLine.indexOf("price") + 6; // starting point of price integer in line
					int priceOfSale = getNextInt(currLine, k, '\n'); // price of sale

					// update queue
					for (int i = 0; i < quantityToSell; i++) {
						// pricesQueue.printQueue(System.out); // debug
						pureBenefit += priceOfSale - pricesQueue.get();
					}
				}
			}

			System.out.println("The pure benefit is: " + pureBenefit);
			// pricesQueue.printQueue(System.out); // debug
			bufferedReader.close();

		} catch (IOException e) {
			System.out.println("An I/O error occured.");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("No file was given as a parameter.");
		} catch (NoSuchElementException e) {
			System.out.println("Not enough stocks for sale.");
		}

	}

	// takes as parameters a string, a starting point in the string and the expected
	// character following the integer and returns the next integer found in the
	// string
	static int getNextInt(String str, int startIndex, char endChar) {
		String currNumberAsString = "";
		if (endChar == ' ') {
			int i = startIndex;
			while (str.charAt(i) != endChar) {
				currNumberAsString += str.charAt(i);
				i++;
			}
		} else if (endChar == '\n') { // search until end of line
			for (int i = startIndex; i < str.length(); i++)
				currNumberAsString += str.charAt(i);
		}
		return Integer.parseInt(currNumberAsString);
	}

}
