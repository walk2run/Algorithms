import java.util.Scanner;

public class P1 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    for (int i = 0; i < t; i++)
      solve(scan);
  }

  static void solve(Scanner scan) {
    int n = scan.nextInt();
    int u = scan.nextInt();
    Point[] points = new Point[n];
    for (int i = 0; i < n; i++)
      points[i] = new Point(scan.nextInt(), scan.nextInt());
    double max = 0, min = Double.MAX_VALUE;
    Point maxC = null, minC = null;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (i == j) continue;
        for (int k = 0; k < n; k++) {
          if (k == i || k == j) continue;
          Point a = points[i];
          Point b = points[j];
          Point c = points[k];
          double area = area(a, b, c);
          if (area == 0) continue;
          if (area > max) {
            max = area;
            maxC = centre(a, b, c);
          } else if (area == max) {
            Point p = centre(a, b, c);
            if (p.x > maxC.x || p.x == maxC.x && p.y > maxC.y)
              maxC = p;
          }
          if (area < min) {
            min = area;
            minC = centre(a, b, c);
          } else if (area == min) {
            Point p = centre(a, b, c);
            if (p.x < minC.x || p.x == minC.x && p.y < minC.y)
              minC = p;
          }
        }
      }
    }
    System.out.printf("%.2f\n", dis(maxC, minC) / (u * 2));
  }

  static double area(Point a, Point b, Point c) {
    Point e1 = new Point(b.x - a.x, b.y - a.y);
    Point e2 = new Point(c.x - a.x, c.y - a.y);
    return Math.abs(e1.x * e2.y - e1.y * e2.x);
  }

  static Point centre(Point a, Point b, Point c) {
    return new Point((a.x + b.x + c.x) / 3, (a.y + b.y + c.y) / 3);
  }

  static double dis(Point a, Point b) {
    return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
  }
}

class Point {
  double x, y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }
}
