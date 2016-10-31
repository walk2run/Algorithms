/*
ID: iamyfy1
PROG: ride
LANG: JAVA
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

/**
 * Created by yfy on 2016/10/30.
 * It seems that * and mod can swap the order
 */
public class ride {
  public static void main(String[] args) throws Exception {
    BufferedReader reader = new BufferedReader(new FileReader("ride.in"));
    PrintWriter writer = new PrintWriter("ride.out");
    if (mod(reader.readLine()) == mod(reader.readLine()))
      writer.println("GO");
    else
      writer.println("STAY");
    writer.close();
  }

  public static int mod(String str) {
    int sum = 1;
    for (int i = 0; i < str.length(); i++)
      sum = sum * (str.charAt(i) - 'A' + 1) % 47;
    return sum;
  }
}