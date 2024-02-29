
package tasks.task4_Online_Examination.bean;

import java.util.List;

public class Questions {
    private String questions;
    private List<String> options;
    private int correctAnswer;

    public Questions() {
    }

    public Questions(String questions, List<String> options, int correctAnswer) {
        this.questions = questions;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
