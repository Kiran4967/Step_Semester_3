import java.util.*;

interface Question {
    double evaluate();
    String getType();
}

class MCQQuestion implements Question {
    private String questionText;
    private String correctAnswer;
    private String studentAnswer;
    private double points;

    public MCQQuestion(
            String questionText,
            String correctAnswer,
            String studentAnswer,
            double points) {

        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public double evaluate() {
        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }

        return 0;
    }

    public String getType() {
        return "MCQ";
    }
}

class TFQuestion implements Question {
    private String questionText;
    private String correctAnswer;
    private String studentAnswer;
    private double points;

    public TFQuestion(
            String questionText,
            String correctAnswer,
            String studentAnswer,
            double points) {

        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public double evaluate() {
        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }

        return 0;
    }

    public String getType() {
        return "TF";
    }
}

class EssayQuestion implements Question {
    private String questionText;
    private String correctAnswer;
    private String studentAnswer;
    private double points;

    public EssayQuestion(
            String questionText,
            String correctAnswer,
            String studentAnswer,
            double points) {

        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public double evaluate() {

        String[] keywords = correctAnswer.split(",");
        String answer = studentAnswer.toLowerCase();

        int matchedKeywords = 0;

        for (String keyword : keywords) {
            if (answer.contains(keyword.trim().toLowerCase())) {
                matchedKeywords++;
            }
        }

        if (matchedKeywords >= 2) {
            return points * 0.75;
        } else if (matchedKeywords == 1) {
            return points * 0.50;
        }

        return 0;
    }

    public String getType() {
        return "ESSAY";
    }
}

public class ExaminationGrader {

    public static String[] parseQuotedFields(String line) {
        List<String> fields = new ArrayList<>();

        boolean insideQuotes = false;
        StringBuilder current = new StringBuilder();

        for (char c : line.toCharArray()) {

            if (c == '"') {
                insideQuotes = !insideQuotes;
            } else if (c == ' ' && !insideQuotes) {

                if (current.length() > 0) {
                    fields.add(current.toString());
                    current.setLength(0);
                }

            } else {
                current.append(c);
            }
        }

        if (current.length() > 0) {
            fields.add(current.toString());
        }

        return fields.toArray(new String[0]);
    }

    public static Question createQuestion(String[] data) {

        String type = data[0];
        String questionText = data[1];
        String correctAnswer = data[2];
        String studentAnswer = data[3];
        double points = Double.parseDouble(data[4]);

        switch (type) {

            case "MCQ":
                return new MCQQuestion(
                        questionText,
                        correctAnswer,
                        studentAnswer,
                        points
                );

            case "TF":
                return new TFQuestion(
                        questionText,
                        correctAnswer,
                        studentAnswer,
                        points
                );

            case "ESSAY":
                return new EssayQuestion(
                        questionText,
                        correctAnswer,
                        studentAnswer,
                        points
                );

            default:
                throw new IllegalArgumentException("Invalid question type");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        double totalScore = 0;

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            String[] data = parseQuotedFields(line);

            Question question = createQuestion(data);

            double score = question.evaluate();

            totalScore += score;

            System.out.printf(
                    "%s: %.2f%n",
                    question.getType(),
                    score
            );
        }

        System.out.printf(
                "Total Score: %.2f%n",
                totalScore
        );

        sc.close();
    }
}
