package com.coronavirustracker.repositories;

import com.coronavirustracker.models.PAAPICoronavirusTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PAAPICoronavirusTrackerRepository extends JpaRepository<PAAPICoronavirusTracker, Long> {

}
