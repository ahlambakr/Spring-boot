package org.example.rest;

public class StudentErrorResponse {
    int status ;
    private String message ;
    private long timeStamp;

    public StudentErrorResponse() {
    }

    public StudentErrorResponse(int status , String meaasge, long timeStamp) {
        this.message = meaasge;
        this.status=status;
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
