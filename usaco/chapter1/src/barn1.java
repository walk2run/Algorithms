/*
ID: iamyfy1
PROG: barn1
LANG: JAVA
 */

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yfy on 16-11-18.
 * Barn Repair
 */
public class barn1 {
  public static void main(String[] args) throws Exception {
    int m, s, c, i, no, lastNo;
    Scanner scan = new Scanner(new BufferedInputStream(new FileInputStream("barn1.in")));
    m = scan.nextInt();
    s = scan.nextInt();
    c = scan.nextInt();
    List<Integer> list = new ArrayList<>();
    lastNo = scan.nextInt();
    for (i = 0; i < c; i++) {
      no = scan.nextInt();
      list.add(no - lastNo - 1);
      lastNo = no;
    }
    list.sort(null);
    for (i = 0; i < )
  }
}
