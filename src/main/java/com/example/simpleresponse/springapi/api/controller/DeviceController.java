package com.example.simpleresponse.springapi.api.controller;

import com.example.simpleresponse.springapi.api.model.Device;
import com.example.simpleresponse.springapi.api.repo.DeviceRepo;
import com.example.simpleresponse.springapi.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/device")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @PostMapping("/device")
    public Device addDevice(@RequestParam Integer id, @RequestBody Device device) {
        deviceService.createDevice(device, id);
        return device;
    }
    @GetMapping("/devices")
    public List<Device> getAllDevices() {
        return deviceService.findAll();
    }
    @GetMapping("/device/id")
    public Optional<Device> findDeviceByID(@RequestParam Integer id) {
        return deviceService.findDeviceByID(id);
    }

    @GetMapping("/device/name")
    public List<Device> findByName(@RequestParam String name) {
        return deviceService.findByName(name);
    }


    @GetMapping("/device/email")
    public List<Device> findByEmail(@RequestParam String email) {
        return deviceService.findByType(email);
    }

    @DeleteMapping("/device")
    public void deleteDevice(@RequestParam Integer id) {
        deviceService.deleteDeviceById(id);
    }

    @PutMapping("/device")
    public void updateDevice(@RequestParam int id,@RequestBody Device device, @RequestParam int userId) {
        deviceService.updateDevice(id ,device, userId);
    }

    @PatchMapping("/device/email")
    public Optional<Device> updateDeviceType(@RequestParam int id, @RequestParam String type) {
        deviceService.updateDeviceType(id, type);
        return deviceService.findDeviceByID(id);
    }
    @PatchMapping("/device/name")
    public Optional<Device> updateDeviceName(@RequestParam int id, @RequestParam String name) {
        deviceService.updateDeviceName(id, name);
        return deviceService.findDeviceByID(id);
    }
}
