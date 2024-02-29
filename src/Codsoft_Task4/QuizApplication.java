package Codsoft_Task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    class Question {
        private String question;
        private List<String> options;
        private int correctOptionIndex;

        public Question(String question, List<String> options, int correctOptionIndex) {
            this.question = question;
            this.options = options;
            this.correctOptionIndex = correctOptionIndex;
        }

        public String getQuestion() {
            return question;
        }

        public List<String> getOptions() {
            return options;
        }

        public boolean isCorrectAnswer(int selectedOptionIndex) {
            return selectedOptionIndex == correctOptionIndex;
        }
    }

    class Quiz {
        private List<Question> questions;
        private int score;

        public Quiz(List<Question> questions) {
            this.questions = questions;
            this.score = 0;
        }

        public void displayQuestion(int questionIndex) {
            Question question = questions.get(questionIndex);
            System.out.println(question.getQuestion());
            List<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }
        }

        public void submitAnswer(int questionIndex, int selectedOptionIndex) {
            Question question = questions.get(questionIndex);
            if (question.isCorrectAnswer(selectedOptionIndex)) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect!");
            }
        }

        public int getScore() {
            return score;
        }
    }

    public class QuizApplication {
        public static void main(String[] args) {
            // Sample quiz questions
            List<Question> questions = new ArrayList<>();
            questions.add(new Question("What is the capital of Japan?",
                    List.of( "Tokyo", "Beijing", "Seoul", "Bangkok"), 0));
            questions.add(new Question("Who is the author of the Harry Potter book series?",
                    List.of("J.K. Rowling", "Stephen King", "George R.R. Martin", "Dan Brown"), 0));
            questions.add(new Question("Which planet is known as the \"Morning Star\" and \"Evening Star\"?",
                    List.of("Venus","Mars","Jupiter","Saturn"), 0));

            // Create a quiz object
            Quiz quiz = new Quiz(questions);

            // Start quiz
            Scanner scanner = new Scanner(System.in);
            for (int i = 0; i < questions.size(); i++) {
                System.out.println("Question " + (i + 1));
                quiz.displayQuestion(i);
                System.out.print("Enter your answer (1-" + questions.get(i).getOptions().size() + "): ");
                int selectedOptionIndex = scanner.nextInt() - 1;
                quiz.submitAnswer(i, selectedOptionIndex);
            }

            // Display final score
            System.out.println("Your score: " + quiz.getScore() + " out of " + questions.size());
        }
    }

