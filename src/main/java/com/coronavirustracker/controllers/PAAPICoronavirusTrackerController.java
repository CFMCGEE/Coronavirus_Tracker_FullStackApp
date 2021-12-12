package com.coronavirustracker.controllers;

import com.coronavirustracker.models.PAAPICoronavirusTracker;
import com.coronavirustracker.services.PAAPICoronavirusTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/pa/api/tracker")
public class PAAPICoronavirusTrackerController {

    @Autowired
    private PAAPICoronavirusTrackerService pAAPICoronavirusTrackerService;

    @GetMapping
    public ResponseEntity<Object> getPennsylvaniaData() {
        return ResponseEntity.ok(pAAPICoronavirusTrackerService.getPATrackerInformation());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getSinglePennsylvaniaData(@PathVariable Long id) {
        return ResponseEntity.ok(pAAPICoronavirusTrackerService.getSinglePATracker(id));
    }

    @GetMapping("/creation")
    public ResponseEntity<Object> savePennsylvaniaData() {
        return ResponseEntity.created(null).body(pAAPICoronavirusTrackerService.savePATrackerInformation());
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllPennsylvaniaData() {
        return ResponseEntity.ok(pAAPICoronavirusTrackerService.getAllPATrackerInformation());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePennsylvaniaData(@PathVariable Long id, @Valid @RequestBody PAAPICoronavirusTracker tracker) {
        return ResponseEntity.ok(pAAPICoronavirusTrackerService.updatePATrackerData(id, tracker));
    }

}
