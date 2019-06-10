package com.jimmy.dao.entity;

public class CoursewareStudentAnswerWithBLOBs extends CoursewareStudentAnswer {
    private String result;

    private String tearchResult;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public String getTearchResult() {
        return tearchResult;
    }

    public void setTearchResult(String tearchResult) {
        this.tearchResult = tearchResult == null ? null : tearchResult.trim();
    }
}