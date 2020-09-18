package org.healthcare.enrollment.service;

import org.healthcare.enrollment.exception.ResourceNotFoundException;
import org.healthcare.enrollment.entity.Dependent;
import org.healthcare.enrollment.repository.DependentRepo;
import org.healthcare.enrollment.repository.EnrolleRepo;
import org.healthcare.enrollment.response.DeleteDependentResponse;
import org.healthcare.enrollment.response.RegisterDependentResponse;
import org.healthcare.enrollment.response.UpdateDependentResponse;
import org.healthcare.enrollment.utility.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.MessageFormat;

public class EnrolleDependentServiceImpl implements EnrolleDependentService {

    private final Logger log = LoggerFactory.getLogger(EnrolleDependentServiceImpl.class);
    @Autowired
    private EnrolleRepo enrolleRepo;

    @Autowired
    private DependentRepo dependentRepo;


    public RegisterDependentResponse saveDependent(Dependent dependent, long enrolleId) throws ResourceNotFoundException {
        Dependent dependentDetails = enrolleRepo.findById(enrolleId).map(enrolle -> {
            dependent.setEnrolle(enrolle);
            return dependentRepo.save(dependent);
        }).orElseThrow(() -> new ResourceNotFoundException("No user found with id: " + enrolleId));
        //If no error is thrown
        log.info("Added dependent details for user with id: " + enrolleId);
        RegisterDependentResponse response = new RegisterDependentResponse("Dependent details saved successfully!");
        response.setDependentDetails(dependentDetails);
        response.setEnrolleId(enrolleId);
        return response;
    }

    public UpdateDependentResponse updateDependent(Dependent dependent, long enrolleId) throws ResourceNotFoundException {
        if (!enrolleRepo.existsById(enrolleId))
            throw new ResourceNotFoundException("No user found with id: " + enrolleId);

        log.debug("Found user with id : " + enrolleId);

        Dependent dependentDetails = dependentRepo.findById(dependent.getId()).map(dbDependentDetails -> {
            updateDependentDetails(dependent, dbDependentDetails);
            //updated dbDependentDetails with the updated info
            return dependentRepo.save(dbDependentDetails);
        }).orElseThrow(() -> new ResourceNotFoundException(
                MessageFormat.format("No dependent found with dependent id {0} corresponding to user {1} ", dependent.getId(), enrolleId)));

        //If no error is thrown
        UpdateDependentResponse response = new UpdateDependentResponse("Updated Dependent details");
        response.setDependentDetails(dependentDetails);
        response.setEnrolleId(enrolleId);
        return response;
    }

    private void updateDependentDetails(Dependent dependent, Dependent dbDependentDetails) {
        if (Util.isNotEmpty(dependent.getName()))
            dbDependentDetails.setName(dependent.getName());
        if (dependent.getBirthDate() != null)
            dbDependentDetails.setBirthDate(dependent.getBirthDate());

    }

    public DeleteDependentResponse deleteDependent(long enrolleId, long dependentId) throws ResourceNotFoundException {
        if (!enrolleRepo.existsById(enrolleId))
            throw new ResourceNotFoundException("No user found with id: " + enrolleId);
        log.debug("Found user with id : " + enrolleId);

        if (!dependentRepo.existsById(dependentId))
            throw new ResourceNotFoundException("No dependent found with id: " + dependentId);

        dependentRepo.deleteById(dependentId);
        DeleteDependentResponse response = new DeleteDependentResponse("Dependent details deleted successfully");
        return response;
    }
}
