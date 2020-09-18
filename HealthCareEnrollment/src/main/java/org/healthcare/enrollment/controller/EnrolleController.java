package org.healthcare.enrollment.controller;

import org.healthcare.enrollment.exception.ResourceNotFoundException;
import org.healthcare.enrollment.request.RegisterEnrolleRequest;
import org.healthcare.enrollment.request.UpdateEnrolleRequest;
import org.healthcare.enrollment.response.DeleteEnrolleResponse;
import org.healthcare.enrollment.response.GetEnrolleDetailsResponse;
import org.healthcare.enrollment.response.RegisterEnrolleResponse;
import org.healthcare.enrollment.response.UpdateEnrolleResponse;
import org.healthcare.enrollment.service.EnrolleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/healthcare/api/v1")
public class EnrolleController {

    @Autowired
    private EnrolleService enrolleService;

    @PostMapping("/enrolle")
    public ResponseEntity<RegisterEnrolleResponse> registerEnrolle(@Valid @RequestBody RegisterEnrolleRequest enrolle) {
        return ResponseEntity.ok(enrolleService.saveEnrolle(enrolle));
    }

    @PutMapping("/enrolle")
    public ResponseEntity<UpdateEnrolleResponse> updateEnrolle(@Valid @RequestBody UpdateEnrolleRequest enrolle) throws ResourceNotFoundException {
        return ResponseEntity.ok(enrolleService.updateEnrolle(enrolle));
    }

    @DeleteMapping("/enrolle/{id}")
    public ResponseEntity<DeleteEnrolleResponse> deleteEnrolle(@PathVariable(value = "id") Long enrolleId) throws ResourceNotFoundException {
        return ResponseEntity.ok(enrolleService.deleteEnrolle(enrolleId));
    }

    @GetMapping("/enrolle/{id}")
    public ResponseEntity<GetEnrolleDetailsResponse> registerEnrolle(@PathVariable(value = "id") Long enrolleId) throws ResourceNotFoundException {
        return ResponseEntity.ok(enrolleService.getEnrolle(enrolleId));
    }

}
