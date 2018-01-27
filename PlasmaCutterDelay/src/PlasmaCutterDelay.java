import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PlasmaCutterDelay {
	public static void main(String[] args) throws IOException {

		Scanner in = new Scanner(System.in);
		System.out.print("File: ");
		String file = in.nextLine();
		System.out.print("Lines: ");
		int lines = in.nextInt();
		System.out.print("Delay: ");
		int delay = in.nextInt();
		in.close();
		BufferedReader inputStream = null;
		PrintWriter outputStream = null;

		try {
			inputStream = new BufferedReader(new FileReader(file));
			StringBuilder sb = new StringBuilder(file);
			sb.delete(file.length()-4, file.length());
			file = sb.toString();
			outputStream = new PrintWriter(new FileWriter(file + "Delay.tap"));

			String l;
			int count = 0;
			while ((l = inputStream.readLine()) != null) {
				outputStream.println(l);
				if (count == lines) {
					outputStream.println("G04 " + delay);
					count = 0;
				} else
					count++;
			}
		} finally {
			if (inputStream != null)
				inputStream.close();
			if (outputStream != null)
				outputStream.close();
			System.out.print("Done.");
		}
	}
}