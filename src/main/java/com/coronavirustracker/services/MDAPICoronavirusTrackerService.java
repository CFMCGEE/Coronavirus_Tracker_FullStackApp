package com.coronavirustracker.services;

import com.coronavirustracker.exceptions.GlobalException;
import com.coronavirustracker.exceptions.details.success.Success;
import com.coronavirustracker.models.MDAPICoronavirusTracker;
import com.coronavirustracker.repositories.MDAPICoronavirusTrackerRepository;
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
public class MDAPICoronavirusTrackerService {

    @Value("${covidAPIKey}")
    private String covidAPIKey;

    private static final Logger logger = LoggerFactory.getLogger(DEAPICoronavirusTrackerService.class);

    @Autowired
    private MDAPICoronavirusTrackerRepository mDAPICoronavirusTrackerRepository;

    @Autowired
    RestTemplate restTemplate;

    public Success getMDTrackerInformation() {

        try {

            MDAPICoronavirusTracker dataFromTracker = restTemplate.getForObject("https://api.covidactnow.org/v2/state/MD.json?apiKey=" + covidAPIKey, MDAPICoronavirusTracker.class);

            logger.info("Maryland data successfully grabbed!");
            return new Success(HttpStatus.OK.value() + " OK", "Maryland data successfully grabbed!", dataFromTracker);

        } catch (GlobalException e) {
            throw new GlobalException();
        }

    }

    public Success getSingleMDTracker(Long id) {

        MDAPICoronavirusTracker dataFromTracker = mDAPICoronavirusTrackerRepository.findById(id).orElseThrow(GlobalException::new);

        logger.info("Single bit of Maryland data successfully grabbed!");
        return new Success(HttpStatus.OK.value() + " OK", "Single bit of Maryland data successfully grabbed!", dataFromTracker);

    }

    public Success getAllMDTrackerInformation() {

            List<MDAPICoronavirusTracker> dataFromTracker = mDAPICoronavirusTrackerRepository.findAll();

            if (dataFromTracker.isEmpty()) {
                throw new GlobalException();
            }

            logger.info("All Maryland data successfully grabbed!");
            return new Success(HttpStatus.OK.value() + " OK", "All Maryland data successfully grabbed!", dataFromTracker);

    }

    public Success saveMDTrackerInformation() {

        try {

            MDAPICoronavirusTracker dataFromTracker = restTemplate.getForObject("https://api.covidactnow.org/v2/state/MD.json?apiKey=" + covidAPIKey, MDAPICoronavirusTracker.class);

            MDAPICoronavirusTracker dataTracker = mDAPICoronavirusTrackerRepository.save(dataFromTracker);

            logger.info("Maryland data successfully posted in database!");
            return new Success(HttpStatus.CREATED.value() + " CREATED", "Maryland data successfully posted in database!", dataTracker);

        } catch (GlobalException e) {
            throw new GlobalException();
        }

    }

    public Success updateMDTrackerData(Long id, MDAPICoronavirusTracker tracker) {

        try {

            MDAPICoronavirusTracker updateTracker = mDAPICoronavirusTrackerRepository.findById(id).get();

            updateTracker.setState(tracker.getState());
            updateTracker.setPopulation(tracker.getPopulation());
            updateTracker.setActuals(tracker.getActuals());

            logger.info("The Maryland data has been successfully corrected!");
            mDAPICoronavirusTrackerRepository.save(updateTracker);

            return new Success(HttpStatus.OK.value() + " OK", "The Maryland data has been successfully corrected!", updateTracker);

        } catch (NoSuchElementException e) {
            throw new GlobalException();
        }

    }

}
