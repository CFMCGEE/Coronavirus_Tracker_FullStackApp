package com.coronavirustracker.controllers;

import com.coronavirustracker.models.MDAPICoronavirusTracker;
import com.coronavirustracker.services.MDAPICoronavirusTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/md/api/tracker")
public class MDAPICoronavirusTrackerController {

    @Autowired
    private MDAPICoronavirusTrackerService mDAPICoronavirusTrackerService;

    @GetMapping
    public ResponseEntity<Object> getMarylandData() {
        return ResponseEntity.ok(mDAPICoronavirusTrackerService.getMDTrackerInformation());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getSingleMarylandData(@PathVariable Long id) {
        return ResponseEntity.ok(mDAPICoronavirusTrackerService.getSingleMDTracker(id));
    }

    @GetMapping("/creation")
    public ResponseEntity<Object> saveMarylandData() {
        return ResponseEntity.created(null).body(mDAPICoronavirusTrackerService.saveMDTrackerInformation());
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllMarylandData() {
        return ResponseEntity.ok(mDAPICoronavirusTrackerService.getAllMDTrackerInformation());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateMarylandaData(@PathVariable Long id, @Valid @RequestBody MDAPICoronavirusTracker tracker) {
        return ResponseEntity.ok(mDAPICoronavirusTrackerService.updateMDTrackerData(id, tracker));
    }

}
