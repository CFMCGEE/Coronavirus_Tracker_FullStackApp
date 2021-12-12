package com.coronavirustracker.exceptions.details.success;

public class Success {

    private String httpStatusCode;
    private String successMessage;
    private Object data;

    public Success(String httpStatusCode, String successMessage, Object data) {

        this.httpStatusCode = httpStatusCode;
        this.successMessage = successMessage;
        this.data = data;
    }

    public String getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(String httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
