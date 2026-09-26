public class HackathonSeatingGridOptimizer {

    static double rowAverage(int[] row) {
        if (row.length == 0) {
            return 0;
        }

        double sum = 0;

        for (int value : row) {
            sum += value;
        }

        return sum / row.length;
    }

    static String classifyRows(int[][] seatGrid, int threshold) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < seatGrid.length; i++) {
            double average = rowAverage(seatGrid[i]);

            if (average >= threshold) {
                result.append("Row ").append(i + 1).append(": Quiet Zone");
            } else {
                result.append("Row ").append(i + 1).append(": Buzzing Zone");
            }

            if (i < seatGrid.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[][] seatGrid = {
                {40, 50, 45},
                {80, 90, 95},
                {30, 20, 25}
        };

        System.out.println(classifyRows(seatGrid, 60));
    }
}