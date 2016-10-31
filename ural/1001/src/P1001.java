import java.io.*;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.StringTokenizer;
import java.util.Scanner;

/**
 * Created by yfy on 11/12/15.
 * 1001. Reverse Root
 Time limit: 2.0 second
 Memory limit: 64 MB
 The problem is so easy, that the authors were lazy to write a statement for it!
 Input
 The input stream contains a set of integer numbers Ai (0 ≤ Ai ≤ 1018). The numbers are separated by any number of spaces and line breaks. A size of the input stream does not exceed 256 KB.
 Output
 For each number Ai from the last one till the first one you should output its square root. Each square root should be printed in a separate line with at least four digits after decimal point.
 Sample
 input	output

 1427  0

 876652098643267843
 5276538





 2297.0716
 936297014.1164
 0.0000
 37.7757

 */

public class P1001 {
	public static void main(String[] args) throws Exception {
		ArrayList<Long> list = new ArrayList<>();

//		Scanner scan = new Scanner(new BufferedInputStream(System.in));
//		while (scan.hasNext())
//			list.add(scan.nextLong());

		StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		while (st.nextToken() != StreamTokenizer.TT_EOF) {
//			if (st.ttype == StreamTokenizer.TT_NUMBER)
				list.add((long) st.nval);
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line);
			while (st.hasMoreTokens())
			  list.add(Long.parseLong(st.nextToken()));
		}

		PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		ListIterator<Long> it = list.listIterator(list.size());
		while (it.hasPrevious())
			pw.println(Math.sqrt(it.previous()));
		pw.flush();
	}
}
