package org.healthcare.enrollment.response;

import org.healthcare.enrollment.entity.Enrolle;

public class UpdateEnrolleResponse extends BaseResponse{

    private Enrolle enrolle;

    public Enrolle getEnrolle() {
        return enrolle;
    }

    public void setEnrolle(Enrolle enrolle) {
        this.enrolle = enrolle;
    }

    public UpdateEnrolleResponse(String resultMessage) {
        super(resultMessage);
    }
}
