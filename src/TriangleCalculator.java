import java.util.Scanner;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class TriangleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入两个小数（作为直角三角形的邻边）：");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();

        double c = calculateHypotenuse(a, b);
        System.out.println("斜边长 c = " + c);
        double r = 23.0 / c;
        System.out.println("r = " + r);

        System.out.println("请输入下一个三角形的两个小数（作为邻边）：");
        double a1 = scanner.nextDouble();
        double b1 = scanner.nextDouble();
        double l1 = calculateHypotenuse(a1, b1);
        System.out.println("l1 = " + l1);
        System.out.println("l1 * r = " + l1 * r);

        System.out.println("请输入另一个三角形的两个小数（作为邻边）：");
        double a2 = scanner.nextDouble();
        double b2 = scanner.nextDouble();
        double l2 = calculateHypotenuse(a2, b2);
        System.out.println("l2 = " + l2);
        System.out.println("l2 * r = " + l2 * r);

        System.out.println("请输入第三个三角形的两个小数（作为邻边）：");
        double a3 = scanner.nextDouble();
        double b3 = scanner.nextDouble();
        double l3 = calculateHypotenuse(a3, b3);
        System.out.println("l3 = " + l3);
        System.out.println("l3 * r = " + l3 * r);

        double height = 23 + l1 * r + l2 * r + l3 * r;
        System.out.println("最终的 height 值 = " + height);
    }

    private static double calculateHypotenuse(double a, double b) {
        double c = Math.sqrt(a * a + b * b);
        BigDecimal bd = new BigDecimal(c).setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
