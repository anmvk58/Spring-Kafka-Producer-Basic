package com.anmv.kafka.scheduler;

import com.anmv.kafka.entity.Commodity;
import com.anmv.kafka.producer.CommodityProducer;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CommodityScheduler {
    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private CommodityProducer producer;

    @Scheduled(fixedRate = 3000)
    public void fetchCommodities() {
        var commodities = restTemplate.exchange("http://localhost:8090/api/commodity/v1/all", HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Commodity>>() {
                }).getBody();

        assert commodities != null : "Commodities should not be null.";
        commodities.forEach(t -> {
            try {
                producer.sendMessage(t);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
