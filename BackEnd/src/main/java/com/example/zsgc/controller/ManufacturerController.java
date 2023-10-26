package com.example.zsgc.controller;

import com.example.zsgc.entity.Manufacturer;
import com.example.zsgc.mapper.ManufacturerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manufacturer")
public class ManufacturerController {
    @Autowired
    private ManufacturerMapper manufacturerMapper;

    @RequestMapping(value = {"/selectAll"}, method = RequestMethod.GET)
    public List<Manufacturer> selectAll() {
        return manufacturerMapper.selectAll();
    }

    @RequestMapping(value = {"/selectByName"}, method = RequestMethod.GET)
    public List<Manufacturer> selectByName(String manuName) {
        return manufacturerMapper.selectByName(manuName);
    }

    @RequestMapping(value = {"/selectByLink"}, method = RequestMethod.GET)
    public List<Manufacturer> selectByLink(String manuLink) {
        return manufacturerMapper.selectByLink(manuLink);
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertManufacturer(Manufacturer manufacturer) {
        manufacturerMapper.insertManufacturer(manufacturer);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateManufacturer(Manufacturer manufacturer) {
        manufacturerMapper.updateManufacturer(manufacturer);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE)
    public void deleteManufacturer(String manuName) {
        manufacturerMapper.deleteManufacturer(manuName);
    }

}
