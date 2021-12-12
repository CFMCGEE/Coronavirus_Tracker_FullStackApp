package com.coronavirustracker.exceptions.details.error;

public class ErrorFound {

    private String httpStatusCode;
    private String errorMessage;

    public ErrorFound(String httpStatusCode, String errorMessage) {

        this.httpStatusCode = httpStatusCode;
        this.errorMessage = errorMessage;

    }

    public String getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(String httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
