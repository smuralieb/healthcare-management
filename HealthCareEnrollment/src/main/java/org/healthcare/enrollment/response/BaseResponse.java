package org.healthcare.enrollment.response;

public class BaseResponse {
    private int resultCode;
    private String resultMessage;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public BaseResponse() {
    }

    public BaseResponse(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public BaseResponse(int resultCode, String resultMessage) {
        this.resultCode = resultCode;
        this.resultMessage = resultMessage;
    }
}
