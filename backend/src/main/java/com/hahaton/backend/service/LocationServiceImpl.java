package com.hahaton.backend.service;


import com.hahaton.backend.model.Location;
import com.hahaton.backend.repository.LocationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class LocationServiceImpl implements LocationService{
    private final LocationRepository locationRepository;


    @Override
    public Location saveLocation(Location location) {
        Location savedLocation = locationRepository.save(location);
        log.info("saved location: {}", savedLocation);
        return savedLocation;
    }
}
