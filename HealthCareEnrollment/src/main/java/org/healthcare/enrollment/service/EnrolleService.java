package org.healthcare.enrollment.service;

import org.healthcare.enrollment.exception.ResourceNotFoundException;
import org.healthcare.enrollment.request.RegisterEnrolleRequest;
import org.healthcare.enrollment.request.UpdateEnrolleRequest;
import org.healthcare.enrollment.response.DeleteEnrolleResponse;
import org.healthcare.enrollment.response.GetEnrolleDetailsResponse;
import org.healthcare.enrollment.response.RegisterEnrolleResponse;
import org.healthcare.enrollment.response.UpdateEnrolleResponse;
import org.springframework.stereotype.Service;

@Service
public interface EnrolleService {

    public RegisterEnrolleResponse saveEnrolle(RegisterEnrolleRequest enrolle);

    public UpdateEnrolleResponse updateEnrolle(UpdateEnrolleRequest enrolle) throws ResourceNotFoundException;

    public DeleteEnrolleResponse deleteEnrolle(long enrolleId) throws ResourceNotFoundException;

    public GetEnrolleDetailsResponse getEnrolle(long enrolleId) throws ResourceNotFoundException;





}
