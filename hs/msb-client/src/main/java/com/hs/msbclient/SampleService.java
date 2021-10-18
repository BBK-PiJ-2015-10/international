package com.hs.msbclient;


import com.hs.msbclient.source.SourceClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SampleService {

    private SourceClient sourceClient;

    public SampleService(SourceClient sourceClient) {
        this.sourceClient = sourceClient;
    }

    public void wakeUp(){
        log.info("I am waking up");
        sourceClient.getRecommendations(5);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("Done");
    }

}
