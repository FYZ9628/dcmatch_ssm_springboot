package com.example.dcmatch_ssm_springboot.model;

public class ContestDetail {
    int id;
    String contestTitle;
    private Organizer organizer;
    String contestContent;
    String signUpStartTime;
    String signUpEndTime;
    String publishTime;
    String place;
    String holdDate;
    String holdStartTime;
    String holdEndTime;
    String type;
    int upperLimit;
    String state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContestTitle() {
        return contestTitle;
    }

    public void setContestTitle(String contestTitle) {
        this.contestTitle = contestTitle;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public String getContestContent() {
        return contestContent;
    }

    public void setContestContent(String contestContent) {
        this.contestContent = contestContent;
    }

    public String getSignUpStartTime() {
        return signUpStartTime;
    }

    public void setSignUpStartTime(String signUpStartTime) {
        this.signUpStartTime = signUpStartTime;
    }

    public String getSignUpEndTime() {
        return signUpEndTime;
    }

    public void setSignUpEndTime(String signUpEndTime) {
        this.signUpEndTime = signUpEndTime;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getHoldDate() {
        return holdDate;
    }

    public void setHoldDate(String holdDate) {
        this.holdDate = holdDate;
    }

    public String getHoldStartTime() {
        return holdStartTime;
    }

    public void setHoldStartTime(String holdStartTime) {
        this.holdStartTime = holdStartTime;
    }

    public String getHoldEndTime() {
        return holdEndTime;
    }

    public void setHoldEndTime(String holdEndTime) {
        this.holdEndTime = holdEndTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
