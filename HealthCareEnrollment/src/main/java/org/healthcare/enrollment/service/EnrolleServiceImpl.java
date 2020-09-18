package org.healthcare.enrollment.service;

import org.healthcare.enrollment.exception.ResourceNotFoundException;
import org.healthcare.enrollment.entity.Enrolle;
import org.healthcare.enrollment.repository.DependentRepo;
import org.healthcare.enrollment.repository.EnrolleRepo;
import org.healthcare.enrollment.request.RegisterEnrolleRequest;
import org.healthcare.enrollment.request.UpdateEnrolleRequest;
import org.healthcare.enrollment.response.DeleteEnrolleResponse;
import org.healthcare.enrollment.response.GetEnrolleDetailsResponse;
import org.healthcare.enrollment.response.RegisterEnrolleResponse;
import org.healthcare.enrollment.response.UpdateEnrolleResponse;
import org.healthcare.enrollment.utility.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public class EnrolleServiceImpl implements EnrolleService {

    private final Logger log = LoggerFactory.getLogger(EnrolleServiceImpl.class);
    @Autowired
    private EnrolleRepo enrolleRepo;
    @Autowired
    private EnrolleDependentService enrolleDependentService;

    @Override
    public RegisterEnrolleResponse saveEnrolle(RegisterEnrolleRequest request) {
        ValidateResponse validity = validEnrolleDetails(request.getEnrolle());
        RegisterEnrolleResponse response = new RegisterEnrolleResponse("Registration Successful");
        if(validity.isValid()) {
            Enrolle enrolle = enrolleRepo.save(request.getEnrolle());
            //If no error is thrown
            response.setEnrolle(enrolle);
            log.info("Registration successful for user: " + enrolle.getName());
        } else {
            response.setResultMessage(validity.getMessage());
        }

        return response;
    }

    private ValidateResponse validEnrolleDetails(Enrolle enrolle) {
        ValidateResponse response = new ValidateResponse(false, null);
        if(Util.isEmpty(enrolle.getName()))
            response.setMessage("Name cannot be Empty");

        if(enrolle.getBirthDate() == null)
            response.setMessage("Date of Birth cannot be Empty");

        //Set the variable to true only if the message is null
        if(Util.isEmpty(response.getMessage()))
            response.setValid(true);

        return response;
    }

    public UpdateEnrolleResponse updateEnrolle(UpdateEnrolleRequest updatedEnrolle) throws ResourceNotFoundException {

        Enrolle dbEnrolleDetails = enrolleRepo.findById(updatedEnrolle.getEnrolle().getId())
                .orElseThrow(() -> new ResourceNotFoundException("No user found with id: " + updatedEnrolle.getEnrolle().getId()));

        updateEnrolleDetails(updatedEnrolle.getEnrolle(), dbEnrolleDetails);
        //updated dbEnrolleDetails with the updated info
        Enrolle enrolle = enrolleRepo.save(dbEnrolleDetails);
        //If no error is thrown
        log.info("Updated user details with id: " + enrolle.getId());
        UpdateEnrolleResponse response = new UpdateEnrolleResponse("Update Successful");
        response.setEnrolle(enrolle);
        return response;

    }

    private void updateEnrolleDetails(Enrolle updatedEnrolle, Enrolle dbEnrolleDetails) {
        if (Util.isNotEmpty(updatedEnrolle.getName()))
            dbEnrolleDetails.setName(updatedEnrolle.getName());

        if (updatedEnrolle.getActivationStatus())
            dbEnrolleDetails.setActivationStatus(updatedEnrolle.getActivationStatus());

        if (Util.isNotEmpty(updatedEnrolle.getPhoneNumber()))
            dbEnrolleDetails.setPhoneNumber(updatedEnrolle.getPhoneNumber());

        if (updatedEnrolle.getBirthDate() != null)
            dbEnrolleDetails.setBirthDate(updatedEnrolle.getBirthDate());
    }

    public DeleteEnrolleResponse deleteEnrolle(long enrolleId) throws ResourceNotFoundException {
        Enrolle dbEnrolleDetails = enrolleRepo.findById(enrolleId)
                .orElseThrow(() -> new ResourceNotFoundException("No user found with id: " + enrolleId));
        enrolleRepo.delete(dbEnrolleDetails);
        //If error is not thrown
        log.info("Deleted user with id: " + enrolleId);
        DeleteEnrolleResponse response = new DeleteEnrolleResponse("Deleted user with id: " + enrolleId);
        return response;
    }

    public GetEnrolleDetailsResponse getEnrolle(long enrolleId) throws ResourceNotFoundException {
        Enrolle dbEnrolleDetails = enrolleRepo.findById(enrolleId)
                .orElseThrow(() -> new ResourceNotFoundException("No user found with id: " + enrolleId));
        log.debug("Succesfully fetched user details.");
        GetEnrolleDetailsResponse response = new GetEnrolleDetailsResponse("Fetched user details Successfully");
        response.setEnrolle(dbEnrolleDetails);
        return  response;
    }

    class ValidateResponse {
        private boolean valid;
        private String message;

        public ValidateResponse(boolean valid, String message) {
            this.valid = valid;
            this.message = message;
        }

        public boolean isValid() {
            return valid;
        }

        public String getMessage() {
            return message;
        }

        public void setValid(boolean valid) {
            this.valid = valid;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
