package com.example.zsgc.controller;

import com.example.zsgc.entity.MerchandiseImg;
import com.example.zsgc.mapper.MerchandiseImgMapper;
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
@RequestMapping("/merchandiseimg")
public class MerchandiseImgController {
    @Autowired
    private MerchandiseImgMapper merchandiseImgMapper;

    @Value("${web.upload-path}")
    private String localPath;

    @RequestMapping(value = {"/selectAll"}, method = RequestMethod.GET)
    public List<MerchandiseImg> selectAll() {
        return merchandiseImgMapper.selectAll();
    }

    @RequestMapping(value = {"/selectByMerchandiseId"}, method = RequestMethod.GET)
    public List<MerchandiseImg> selectByMerchandiseId(int merchandiseId) {
        return merchandiseImgMapper.selectByMerchandiseId(merchandiseId);
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertMerchandiseImg(MerchandiseImg merchandiseImg, @RequestParam("fileName") MultipartFile imgfile) {
        merchandiseImg.setImgpath(imgfile.getOriginalFilename());
        FileUtils.upload(imgfile, localPath, imgfile.getOriginalFilename());
        merchandiseImgMapper.insertMerchandiseImg(merchandiseImg);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateMerchandiseImg(MerchandiseImg merchandiseImg, @RequestParam("fileName") MultipartFile imgfile) {
        merchandiseImg.setImgpath(imgfile.getOriginalFilename());
        FileUtils.upload(imgfile, localPath, imgfile.getOriginalFilename());
        merchandiseImgMapper.updateMerchandiseImg(merchandiseImg);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE)
    public void deleteMerchandiseImg(int merchandiseImgId) {
        merchandiseImgMapper.deleteMerchandiseImg(merchandiseImgId);
    }
}
