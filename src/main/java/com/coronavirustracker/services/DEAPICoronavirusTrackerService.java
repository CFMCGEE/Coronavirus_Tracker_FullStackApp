package com.coronavirustracker.services;

import com.coronavirustracker.exceptions.GlobalException;
import com.coronavirustracker.exceptions.details.success.Success;
import com.coronavirustracker.models.DEAPIArrayCoronavirusTracker;
import com.coronavirustracker.models.DEAPICoronavirusTracker;
import com.coronavirustracker.repositories.DEAPIArrayCoronavirusTrackerRepository;
import com.coronavirustracker.repositories.DEAPICoronavirusTrackerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;
import java.lang.System;

@Service
public class DEAPICoronavirusTrackerService {

    @Value("${covidAPIKey}")
    private String covidAPIKey;

    private static final Logger logger = LoggerFactory.getLogger(DEAPICoronavirusTrackerService.class);

    @Autowired
    private DEAPICoronavirusTrackerRepository dEAPICoronavirusTrackerRepository;

    @Autowired
    private DEAPIArrayCoronavirusTrackerRepository dEAPIArrayCoronavirusTrackerRepository;

    @Autowired
    RestTemplate restTemplate;

    public Success getDETrackerInformation() {

        try {

            DEAPICoronavirusTracker dataFromTracker = restTemplate.getForObject("https://api.covidactnow.org/v2/state/DE.json?apiKey=" + covidAPIKey, DEAPICoronavirusTracker.class);

            logger.info("Delaware data successfully grabbed!");
            return new Success(HttpStatus.OK.value() + " OK", "Delaware data successfully grabbed!", dataFromTracker);

        } catch (GlobalException e) {
            throw new GlobalException();
        }

    }

    public Success getSingleDETracker(Long id) {

        DEAPICoronavirusTracker dataFromTracker = dEAPICoronavirusTrackerRepository.findById(id).orElseThrow(GlobalException::new);

        logger.info("Single bit of Delaware data successfully grabbed!");
        return new Success(HttpStatus.OK.value() + " OK", "Single bit of Delaware data successfully grabbed!", dataFromTracker);

    }

    public Success getAllDETrackerInformation() {

            List<DEAPICoronavirusTracker> dataFromTracker = dEAPICoronavirusTrackerRepository.findAll();

            if (dataFromTracker.isEmpty()) {
                throw new GlobalException();
            }

            logger.info("All Delaware data successfully grabbed!");
            return new Success(HttpStatus.OK.value() + " OK", "All Delaware data successfully grabbed!", dataFromTracker);

    }

    public Success getHistoricalDETrackerInformation() {

        try {

            DEAPIArrayCoronavirusTracker dataFromTracker = restTemplate.getForObject("https://api.covidactnow.org/v2/state/DE.timeseries.json?apiKey=" + covidAPIKey, DEAPIArrayCoronavirusTracker.class);

            logger.info("Delaware's historical data has been successfully grabbed!");
            return new Success(HttpStatus.OK.value() + " OK", "Delaware's historical data has been successfully grabbed!", dataFromTracker);

        } catch (GlobalException e) {
            throw new GlobalException();
        }

    }

    public Success getHistoricalDEAPIByIDTrackerInformation(Integer idPosition) throws IOException {

        try {

            DEAPIArrayCoronavirusTracker dataFromTracker = restTemplate.getForObject("https://api.covidactnow.org/v2/state/DE.timeseries.json?apiKey=" + covidAPIKey, DEAPIArrayCoronavirusTracker.class);

            logger.info("Delaware's historical data has been successfully grabbed!");
            return new Success(HttpStatus.OK.value() + " OK", "Delaware's historical data has been successfully grabbed!", dataFromTracker.getActualsTimeseries()[idPosition]); //648

        } catch (GlobalException e) {
            throw new GlobalException();
        }

    }

    public Success saveHistoricalDEAPIByIDTrackerInformation(Integer idPosition) throws IOException {

        try {

            DEAPIArrayCoronavirusTracker dataFromTracker = restTemplate.getForObject("https://api.covidactnow.org/v2/state/DE.timeseries.json?apiKey=" + covidAPIKey, DEAPIArrayCoronavirusTracker.class);

            dEAPIArrayCoronavirusTrackerRepository.save(dataFromTracker);

            logger.info("Delaware's historical data has been successfully grabbed!");
            return new Success(HttpStatus.OK.value() + " OK", "Delaware's historical data has been successfully grabbed!", dataFromTracker.getActualsTimeseries()[idPosition]); //648

        } catch (GlobalException e) {
            throw new GlobalException();
        }

    }

    public Success saveDETrackerInformation() {

        try {

            DEAPICoronavirusTracker dataFromTracker = restTemplate.getForObject("https://api.covidactnow.org/v2/state/DE.timeseries.json?apiKey=" + covidAPIKey, DEAPICoronavirusTracker.class);

            DEAPICoronavirusTracker dataTracker = dEAPICoronavirusTrackerRepository.save(dataFromTracker);

            logger.info("Delaware data successfully posted in database!");
            return new Success(HttpStatus.CREATED.value() + " CREATED", "Delaware data successfully posted in database!", dataTracker);

        } catch (GlobalException e) {
            throw new GlobalException();
        }
    }

    public Success saveHistoricalDETrackerInformation() {

        try {

            DEAPIArrayCoronavirusTracker dataFromTracker = restTemplate.getForObject("https://api.covidactnow.org/v2/state/DE.timeseries.json?apiKey=" + covidAPIKey, DEAPIArrayCoronavirusTracker.class);

            DEAPIArrayCoronavirusTracker dataTracker = dEAPIArrayCoronavirusTrackerRepository.save(dataFromTracker);

            logger.info("Delaware data successfully posted in database!");
            return new Success(HttpStatus.CREATED.value() + " CREATED", "Delaware data successfully posted in database!", dataTracker);

        } catch (GlobalException e) {
            throw new GlobalException();
        }

    }

    public Success updateDETrackerData(Long id, DEAPICoronavirusTracker tracker) {

        try {

            DEAPICoronavirusTracker updateTracker = dEAPICoronavirusTrackerRepository.findById(id).get();

            updateTracker.setState(tracker.getState());
            updateTracker.setPopulation(tracker.getPopulation());
            updateTracker.setActuals(tracker.getActuals());

            logger.info("The Delaware data has been successfully corrected!");
            dEAPICoronavirusTrackerRepository.save(updateTracker);

            return new Success(HttpStatus.OK.value() + " OK", "The Delaware data has been successfully corrected!", updateTracker);

        } catch (NoSuchElementException e) {
            throw new GlobalException();
        }

    }



}
