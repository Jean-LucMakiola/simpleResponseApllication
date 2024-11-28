package com.example.simpleresponse.springapi.api.repo;

import com.example.simpleresponse.springapi.api.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface DeviceRepo extends JpaRepository<Device, Integer> {
    List<Device> findByName(String name);
    List<Device> findByType(String type);
}
