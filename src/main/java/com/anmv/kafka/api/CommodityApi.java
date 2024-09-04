package com.anmv.kafka.api;

import com.anmv.kafka.entity.Commodity;
import com.anmv.kafka.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/commodity/v1")
public class CommodityApi {

    @Autowired
    private CommodityService commodityService;

    @GetMapping(value = "/all")
    public List<Commodity> getCommodities() {
        return commodityService.createDummyCommodities();
    }

}
