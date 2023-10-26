package com.example.zsgc.controller;

import com.example.zsgc.entity.Sale;
import com.example.zsgc.entity.SaleInfo;
import com.example.zsgc.mapper.SaleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    private SaleMapper saleMapper;

    @RequestMapping(value = {"/selectAll"}, method = RequestMethod.GET)
    public List<SaleInfo> selectAll() {
        return saleMapper.selectAll();
    }

    @RequestMapping(value = {"/selectByFigureId"}, method = RequestMethod.GET)
    public List<Sale> selectByFigureId(int figureId) {
        return saleMapper.selectByFigureId(figureId);
    }

    @RequestMapping(value = {"/selectByFigureName"}, method = RequestMethod.GET)
    public List<SaleInfo> selectByFigureName(String figureName) {
        return saleMapper.selectByFigureName(figureName);
    }

    @RequestMapping(value = {"/selectByMerchandiseId"}, method = RequestMethod.GET)
    public List<Sale> selectByMerchandiseId(int merchandiseId) {
        return saleMapper.selectByMerchandiseId(merchandiseId);
    }

    @RequestMapping(value = {"/insert"}, method = RequestMethod.POST)
    public void insertSale(Sale sale) {
        saleMapper.insertSale(sale);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.PUT)
    public void updateSale(Sale sale) {
        saleMapper.updateSale(sale);
    }

    @RequestMapping(value = {"/delete"}, method = RequestMethod.DELETE)
    public void deleteSale(int saleId) {
        saleMapper.deleteSale(saleId);
    }
}
