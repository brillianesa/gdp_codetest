package com.gdp.codetest.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_tr_question")
public class Question {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer question_id;
    private String correctanswer;
    private String questiondetail;

    public String getCorrectanswer() {
        return correctanswer;
    }

    public void setCorrectanswer(String correctanswer) {
        this.correctanswer = correctanswer;
    }

    public String getQuestiondetail() {
        return questiondetail;
    }

    public void setQuestiondetail(String questiondetail) {
        this.questiondetail = questiondetail;
    }

    private String image;

    @OneToMany(mappedBy = "question")
    @JsonIgnore
    private List<Score> score;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;

    public Integer getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Integer question_id) {
        this.question_id = question_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
