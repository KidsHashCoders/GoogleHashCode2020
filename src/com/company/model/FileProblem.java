package com.company.model;

public class FileProblem {

    public FileProblem(String input, String output) {
        this.input = input;
        this.output = output;
    }

    private String input;
    private String output;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
