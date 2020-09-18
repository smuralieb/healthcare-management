package org.healthcare.enrollment.response;

import org.healthcare.enrollment.entity.Enrolle;

public class RegisterEnrolleResponse extends BaseResponse {

    private Enrolle enrolle;

    public Enrolle getEnrolle() {
        return enrolle;
    }

    public void setEnrolle(Enrolle enrolle) {
        this.enrolle = enrolle;
    }

    public RegisterEnrolleResponse(String resultMessage) {
        super(resultMessage);
    }
}
