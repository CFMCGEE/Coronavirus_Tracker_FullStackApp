package com.coronavirustracker.services;

import com.coronavirustracker.exceptions.GlobalException;
import com.coronavirustracker.exceptions.details.success.Success;
import com.coronavirustracker.models.PAAPICoronavirusTracker;
import com.coronavirustracker.repositories.PAAPICoronavirusTrackerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PAAPICoronavirusTrackerService {

    @Value("${covidAPIKey}")
    private String covidAPIKey;

    private static final Logger logger = LoggerFactory.getLogger(DEAPICoronavirusTrackerService.class);

    @Autowired
    private PAAPICoronavirusTrackerRepository pAAPICoronavirusTrackerRepository;

    @Autowired
    RestTemplate restTemplate;

    public Success getPATrackerInformation() {

        try {

            PAAPICoronavirusTracker dataFromTracker = restTemplate.getForObject("https://api.covidactnow.org/v2/state/PA.json?apiKey=" + covidAPIKey, PAAPICoronavirusTracker.class);

            logger.info("Pennsylvania data successfully grabbed!");
            return new Success(HttpStatus.OK.value() + " OK", "Pennsylvania data successfully grabbed!", dataFromTracker);

        } catch (GlobalException e) {
            throw new GlobalException();
        }

    }

    public Success getSinglePATracker(Long id) {

        PAAPICoronavirusTracker dataFromTracker = pAAPICoronavirusTrackerRepository.findById(id).orElseThrow(GlobalException::new);

        logger.info("Single bit of Pennsylvania data successfully grabbed!");
        return new Success(HttpStatus.OK.value() + " OK", "Single bit of Pennsylvania data successfully grabbed!", dataFromTracker);

    }

    public Success getAllPATrackerInformation() {

            List<PAAPICoronavirusTracker> dataFromTracker = pAAPICoronavirusTrackerRepository.findAll();

            if (dataFromTracker.isEmpty()) {
                throw new GlobalException();
            }

            logger.info("All Pennsylvania data successfully grabbed!");
            return new Success(HttpStatus.OK.value() + " OK", "All Pennsylvania data successfully grabbed!", dataFromTracker);

    }

    public Success savePATrackerInformation() {

        try {

            PAAPICoronavirusTracker dataFromTracker = restTemplate.getForObject("https://api.covidactnow.org/v2/state/PA.json?apiKey=" + covidAPIKey, PAAPICoronavirusTracker.class);

            PAAPICoronavirusTracker dataTracker = pAAPICoronavirusTrackerRepository.save(dataFromTracker);

            logger.info("Pennsylvania data successfully posted in database!");
            return new Success(HttpStatus.CREATED.value() + " CREATED", "Pennsylvania data successfully posted in database!", dataTracker);

        } catch (GlobalException e) {
            throw new GlobalException();
        }

    }

    public Success updatePATrackerData(Long id, PAAPICoronavirusTracker tracker) {

        try {

            PAAPICoronavirusTracker updateTracker = pAAPICoronavirusTrackerRepository.findById(id).get();

            updateTracker.setState(tracker.getState());
            updateTracker.setPopulation(tracker.getPopulation());
            updateTracker.setActuals(tracker.getActuals());

            logger.info("The Pennsylvania data has been successfully corrected!");
            pAAPICoronavirusTrackerRepository.save(updateTracker);

            return new Success(HttpStatus.OK.value() + " OK", "The Pennsylvania data has been successfully corrected!", updateTracker);

        } catch (NoSuchElementException e) {
            throw new GlobalException();
        }

    }

}
