import java.util.Scanner;
abstract class GardenPlot {
    protected String owner;
    public GardenPlot(String owner) {
        this.owner = owner;
    }
    public String getOwner() {
        return owner;
    }
    public abstract double calculateArea();
}
class CirclePlot extends GardenPlot {
    private double radius;
    public CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}
class RectanglePlot extends GardenPlot {
    private double length;
    private double width;
    public RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }
    @Override
    public double calculateArea() {
        return length * width;
    }
}
class TrianglePlot extends GardenPlot {
    private double base;
    private double height;
    public TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }
    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}
public class GardenAreaReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        double totalArea = 0.0;
        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();
            GardenPlot plot = null;
            if (shape.equals("CIRCLE")) {
                double radius = sc.nextDouble();
                plot = new CirclePlot(owner, radius);
            } else if (shape.equals("RECTANGLE")) {
                double length = sc.nextDouble();
                double width = sc.nextDouble();
                plot = new RectanglePlot(owner, length, width);
            } else if (shape.equals("TRIANGLE")) {
                double base = sc.nextDouble();
                double height = sc.nextDouble();
                plot = new TrianglePlot(owner, base, height);
            }
            if (plot != null) {
                double area = plot.calculateArea();
                totalArea += area;
                System.out.printf("%s (%s): %.2f\n", plot.getOwner(), shape, area);
            }
        }
        System.out.printf("Total Area: %.2f\n", totalArea);
        sc.close();
    }
}
