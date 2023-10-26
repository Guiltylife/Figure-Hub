package com.example.zsgc.controller;

import com.example.zsgc.entity.RoleImg;
import com.example.zsgc.mapper.RoleImgMapper;
import com.example.zsgc.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/roleimg")
public class RoleImgController {
    @Autowired
    private RoleImgMapper roleImgMapper;

    @Value("${web.upload-path}")
    private String localPath;

    @RequestMapping(value = {"/selectAll"}, method = RequestMethod.GET)
    public List<RoleImg> selectAll() {
        return roleImgMapper.selectAll();
    }

    @RequestMapping(value = {"/selectByRoleId"}, method = RequestMethod.GET)
    public List<RoleImg> selectByRoleId(int roleId) {
        return roleImgMapper.selectByRoleId(roleId);
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertRoleImg(RoleImg roleImg, @RequestParam("fileName") MultipartFile imgfile) {
        roleImg.setImgpath(imgfile.getOriginalFilename());
        FileUtils.upload(imgfile, localPath, imgfile.getOriginalFilename());
        roleImgMapper.insertRoleImg(roleImg);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateRoleImg(RoleImg roleImg, @RequestParam("fileName") MultipartFile imgfile) {
        roleImg.setImgpath(imgfile.getOriginalFilename());
        FileUtils.upload(imgfile, localPath, imgfile.getOriginalFilename());
        roleImgMapper.updateRoleImg(roleImg);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE)
    public void deleteRoleImg(int roleImgId) {
        roleImgMapper.deleteRoleImg(roleImgId);
    }
}
