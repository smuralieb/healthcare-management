package org.healthcare.enrollment.response;

import org.healthcare.enrollment.entity.Dependent;

public class RegisterDependentResponse extends BaseResponse {

    private long enrolleId;

    private Dependent dependentDetails;

    public long getEnrolleId() {
        return enrolleId;
    }

    public void setEnrolleId(long enrolleId) {
        this.enrolleId = enrolleId;
    }

    public Dependent getDependentDetails() {
        return dependentDetails;
    }

    public void setDependentDetails(Dependent dependentDetails) {
        this.dependentDetails = dependentDetails;
    }

    public RegisterDependentResponse(String resultMessage) {
        super(resultMessage);
    }
}
