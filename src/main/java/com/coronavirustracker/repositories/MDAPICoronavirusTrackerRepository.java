package com.coronavirustracker.repositories;

import com.coronavirustracker.models.MDAPICoronavirusTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MDAPICoronavirusTrackerRepository extends JpaRepository<MDAPICoronavirusTracker, Long> {

}
