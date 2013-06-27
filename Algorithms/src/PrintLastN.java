import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class PrintLastN {
	public void PrintLastNLinesOfFile(String fileName, int numberOfLines) {
		BufferedReader pointer1 = null;
		BufferedReader pointer2 = null;
		try {
			if (numberOfLines <= 0)
				throw new Exception(
						"Invalid Number of Lines: Number of lines have to be greater than 0");
			int i = 0;
			pointer1 = new BufferedReader(new FileReader(fileName));
			while (pointer1.readLine() != null) {
				i++;
				if (i == numberOfLines) {
					pointer2 = new  BufferedReader(new FileReader(fileName));
				} else if (i > numberOfLines) {
					pointer2.readLine();
				}
			}

			if (pointer2 != null) {
				String line = "";
				while ((line = pointer2.readLine()) != null) {
					System.out.println(line);
				}
			} else {
				System.out
						.println("Invalid Number of Lines: Number of lines are less than expected");
			}
		} catch (Exception ex) {
			System.out.println(ex.toString());
		} finally {
			try {
				pointer1.close();
				pointer2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}