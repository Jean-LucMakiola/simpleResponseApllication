package com.example.simpleresponse.springapi.service;

import com.example.simpleresponse.springapi.api.model.Device;
import com.example.simpleresponse.springapi.api.model.User;
import com.example.simpleresponse.springapi.api.repo.DeviceRepo;
import com.example.simpleresponse.springapi.api.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeviceService {

    @Autowired
    private DeviceRepo deviceRepo;

    @Autowired
    private UserRepo userRepo; // Injecting User repository


    public Device createDevice(Device device, Integer userId) {
        // Find the user by ID and associate it with the device
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found")); // Handle case where user is not found

        device.setUser(user); // Set the associated user to the device
        return deviceRepo.save(device); // Save the device
    }

    public List<Device> findAll() {
        return deviceRepo.findAll();
    }

    public Optional<Device> findDeviceByID(Integer id) {
        return deviceRepo.findById(id);
    }

    public List<Device> findByName(String name) {
        return deviceRepo.findByName(name);
    }

    public List<Device> findByType(String type) {
        return deviceRepo.findByType(type);
    }


    public void deleteDeviceById(Integer id) {
        // Find the user to delete
        Device deviceToDelete = deviceRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        // Delete the user
        deviceRepo.delete(deviceToDelete);
    }

    public void updateDevice(int id, Device device, int userId) {
        Optional<Device> deviceToUpdate = findDeviceByID(id);
        System.out.println("Hallo"+deviceToUpdate.isPresent());
            if (deviceToUpdate.isPresent()) {
            Device updatedDevice = deviceToUpdate.orElseThrow(() -> new RuntimeException("Something went wrong"));
                updatedDevice.setName(device.getName());
                updatedDevice.setType(device.getType());
                updatedDevice.setMacaddress(device.getMacaddress());
            deviceRepo.save(updatedDevice);
        }
        else {
            createDevice(device, userId);
        }
    }

    public void updateDeviceType(int id, String type) {
        Optional<Device> deviceToUpdate = findDeviceByID(id);
        Device updatedDevice = deviceToUpdate.orElseThrow(() -> new RuntimeException("User not found"));
        updatedDevice.setType(type);
        deviceRepo.save(updatedDevice);
    }

    public void updateDeviceName(int id, String name) {
        Optional<Device> deviceToUpdate = findDeviceByID(id);
        Device updatedDevice = deviceToUpdate.orElseThrow(() -> new RuntimeException("User not found"));
        updatedDevice.setType(name);
        deviceRepo.save(updatedDevice);
    }
}
