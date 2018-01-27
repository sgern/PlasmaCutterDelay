import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PlasmaCutterDelay {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.print("File: ");
		String file = in.nextLine();
		System.out.print("Lines: ");
		int lines = in.nextInt();
		System.out.print("Delay: ");
		int delay = in.nextInt();
		in.close();
		BufferedReader inputStream = null;
		BufferedWriter outputStream = null;

		try {
			inputStream = new BufferedReader(new FileReader(file));
			outputStream = new BufferedWriter(new FileWriter(file + "Delay"));

			String l;
			int count = 0;
			while ((l = inputStream.readLine()) != null) {
				outputStream.write(l);
				if (count == lines) {
					outputStream.write("\nGo4 " + delay);
					count = 0;
				} else
					count++;
			}
			if (inputStream != null)
				inputStream.close();
			if (outputStream != null)
				outputStream.close();
			System.out.print("Done.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}
	}
}