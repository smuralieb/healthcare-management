package org.healthcare.enrollment.service;


import org.healthcare.enrollment.exception.ResourceNotFoundException;
import org.healthcare.enrollment.entity.Dependent;
import org.healthcare.enrollment.response.DeleteDependentResponse;
import org.healthcare.enrollment.response.RegisterDependentResponse;
import org.healthcare.enrollment.response.UpdateDependentResponse;

public interface EnrolleDependentService {

    public RegisterDependentResponse saveDependent(Dependent dependent, long enrolleId) throws ResourceNotFoundException;

    public UpdateDependentResponse updateDependent(Dependent dependent, long enrolleId) throws ResourceNotFoundException;

    public DeleteDependentResponse deleteDependent(long enrolleId, long dependentId) throws ResourceNotFoundException;

}
