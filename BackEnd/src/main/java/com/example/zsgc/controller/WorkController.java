package com.example.zsgc.controller;

import com.example.zsgc.entity.Work;
import com.example.zsgc.mapper.WorkMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/work")
public class WorkController {
    @Autowired
    private WorkMapper workMapper;

    @RequestMapping(value = {"/selectAll"}, method = RequestMethod.GET)
    public List<Work> selectAll() {
        return workMapper.selectAll();
    }

    @RequestMapping(value = {"/selectByName"}, method = RequestMethod.GET)
    public List<Work> selectByName(String workName) {
        return workMapper.selectByName(workName);
    }

    @RequestMapping(value = {"/selectByKind"}, method = RequestMethod.GET)
    public List<Work> selectByKind(int kind) {
        return workMapper.selectByKind(kind);
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertWork(Work work) {
        workMapper.insertWork(work);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateWork(Work work) {
        workMapper.updateWork(work);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE)
    public void deleteWork(String workName) {
        workMapper.deleteWork(workName);
    }
}
