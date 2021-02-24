package com.example.dcmatch_ssm_springboot.model;

public class Contest {
    int id;
    private ContestDetail contestDetail;
    private Student student;
    String state;
    String ticketNumber;
    int score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ContestDetail getContestDetail() {
        return contestDetail;
    }

    public void setContestDetail(ContestDetail contestDetail) {
        this.contestDetail = contestDetail;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
