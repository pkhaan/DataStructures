import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;

public class TagMatching {

	public static void main(String[] args) {
		try {
			String pathToHTmlFile = args[0];
			
			try {
				BufferedReader in = new BufferedReader(new FileReader(pathToHTmlFile));
				// main operation
				IntStackImpl<String> stack = new IntStackImpl<String>();
				// parsing begins
				int currentCharAsInt = in.read(); // reading the current character as an integer
				boolean readingATag = false; // a flag that indicates if the parser is reading an html tag
				String currentTag = ""; // a String that stores the current html tag name
				boolean fileHasATag = false; // a flag that indicates if the are any tags in the file
				if (currentCharAsInt != -1) {
					while (currentCharAsInt != -1) {
						char currentChar = (char) currentCharAsInt;
						if (currentChar == '<') {
							readingATag = true;
							fileHasATag = true;
						} else if (currentChar == '>') {
							readingATag = false;
							if (!currentTag.startsWith("/")) {
								stack.push(currentTag);
								// System.out.println(currentTag + " tag added to the stack"); // debug
							} else if (currentTag.substring(1).equals(stack.peek())) {
								// System.out.println(stack.peek() + " tag removed from the stack"); // debug
								stack.pop();
							}
							currentTag = "";
						} else if (readingATag)
							currentTag = currentTag + currentChar;

						currentCharAsInt = in.read();
					}
					// stack.printStack(System.out); // debug
					if (stack.isEmpty()) {
						if (fileHasATag)
							System.out.println("The file has got matching tags");
						else
							System.out.println("There are no tags in the file");
					} else
						System.out.println("The file does not have matching tags");
				} else
					System.out.println("The file is empty");
				in.close();
			} catch (FileNotFoundException e) {
				System.out.println("File not found");
			} catch (NoSuchElementException e) {
				System.out.println("No such element was found in the stack");
			} catch (IOException e) {
				System.out.println("An I/O operation was interrupted");
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("No argument was given");
		}
	}

}
