package org.healthcare.enrollment.controller;


import org.healthcare.enrollment.exception.ResourceNotFoundException;
import org.healthcare.enrollment.request.RegisterDependentRequest;
import org.healthcare.enrollment.request.UpdateDependentRequest;
import org.healthcare.enrollment.response.DeleteDependentResponse;
import org.healthcare.enrollment.response.RegisterDependentResponse;
import org.healthcare.enrollment.response.UpdateDependentResponse;
import org.healthcare.enrollment.service.EnrolleDependentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/healthcare/api/v1")
public class EnrolleDependentController {

    @Autowired
    private EnrolleDependentService enrolleDependentService;


    @PostMapping("/enrolle/{id}/dependent")
    public ResponseEntity<RegisterDependentResponse> registerDependent(@Valid @RequestBody RegisterDependentRequest request) throws ResourceNotFoundException {
        return ResponseEntity.ok(enrolleDependentService.saveDependent(request.getDependentDetails(),request.getEnrolleId()));
    }

    @PutMapping("/enrolle/{id}/dependent")
    public ResponseEntity<UpdateDependentResponse> updateDependent(@Valid @RequestBody UpdateDependentRequest request) throws ResourceNotFoundException {
        return ResponseEntity.ok(enrolleDependentService.updateDependent(request.getDependentDetails(), request.getEnrolleId()));
    }

    @DeleteMapping("/enrolle/{id}/dependent/{dependentId}")
    public ResponseEntity<DeleteDependentResponse> deleteDependent(@PathVariable(value = "id") Long enrolleId, @PathVariable(value = "dependentId") Long dependentId) throws ResourceNotFoundException {
        return ResponseEntity.ok(enrolleDependentService.deleteDependent(enrolleId, dependentId));
    }

}
