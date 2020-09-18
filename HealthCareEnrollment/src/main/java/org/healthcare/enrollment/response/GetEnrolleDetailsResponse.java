package org.healthcare.enrollment.response;

import org.healthcare.enrollment.entity.Enrolle;

public class GetEnrolleDetailsResponse extends BaseResponse {

    private Enrolle enrolle;

    public Enrolle getEnrolle() {
        return enrolle;
    }

    public void setEnrolle(Enrolle enrolle) {
        this.enrolle = enrolle;
    }

    public GetEnrolleDetailsResponse(String resultMessage) {
        super(resultMessage);
    }
}
