package com.coronavirustracker.controllers;

import com.coronavirustracker.models.DEAPICoronavirusTracker;
import com.coronavirustracker.services.DEAPICoronavirusTrackerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@CrossOrigin("*")
@RestController
@RequestMapping("/de/api/tracker")
public class DEAPICoronavirusTrackerController {

    @Autowired
    private DEAPICoronavirusTrackerService dEAPICoronavirusTrackerService;

    @GetMapping
    public ResponseEntity<Object> getDelawareData() {
        return ResponseEntity.ok(dEAPICoronavirusTrackerService.getDETrackerInformation());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getSingleDelawareData(@PathVariable Long id) {
        return ResponseEntity.ok(dEAPICoronavirusTrackerService.getSingleDETracker(id));
    }

    @GetMapping("/creation")
    public ResponseEntity<Object> saveDelawareData() {
        return ResponseEntity.created(null).body(dEAPICoronavirusTrackerService.saveDETrackerInformation());
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllDelawareData() {
        return ResponseEntity.ok(dEAPICoronavirusTrackerService.getAllDETrackerInformation());
    }

    @GetMapping("/history")
    public ResponseEntity<Object> getHistoricalDelawareData() {
        return ResponseEntity.ok(dEAPICoronavirusTrackerService.getHistoricalDETrackerInformation());
    }

    @GetMapping("/history/{idPosition}")
    public ResponseEntity<Object> getHistoricalDEAPITrackerInformation(@PathVariable Integer idPosition) throws IOException {
        return ResponseEntity.ok(dEAPICoronavirusTrackerService.getHistoricalDEAPIByIDTrackerInformation(idPosition));
    }

    @GetMapping("/history/{idPosition}/creation")
    public ResponseEntity<Object> saveHistoricalDEAPITrackerInformation(@PathVariable Integer idPosition) throws IOException {
        return ResponseEntity.created(null).body(dEAPICoronavirusTrackerService.saveHistoricalDEAPIByIDTrackerInformation(idPosition));
    }

    @GetMapping("/history/creation")
    public ResponseEntity<Object> saveHistoricalDelawareData() {
        return ResponseEntity.created(null).body(dEAPICoronavirusTrackerService.saveHistoricalDETrackerInformation());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePennsylvaniaData(@PathVariable Long id, @Valid @RequestBody DEAPICoronavirusTracker tracker) {
        return ResponseEntity.ok(dEAPICoronavirusTrackerService.updateDETrackerData(id, tracker));
    }

}
