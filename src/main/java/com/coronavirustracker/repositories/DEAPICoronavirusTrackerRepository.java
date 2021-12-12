package com.coronavirustracker.repositories;

import com.coronavirustracker.models.DEAPICoronavirusTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DEAPICoronavirusTrackerRepository extends JpaRepository<DEAPICoronavirusTracker, Long> {

}
