package com.example.huynhanhtien;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Question {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String questionText;
    @ColumnInfo
    private boolean correctAnswer;

    public Question(String questionText, boolean correctAnswer) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setCorrectAnswer(boolean correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public boolean isCorrectAnswer() {
        return correctAnswer;
    }
}
