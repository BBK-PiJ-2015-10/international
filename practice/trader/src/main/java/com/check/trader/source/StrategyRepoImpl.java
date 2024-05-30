package com.check.trader.source;

import com.check.trader.entity.ImportedStrategy;
import com.check.trader.mapper.StrategyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.file.Paths;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StrategyRepoImpl implements StrategyRepo {

    private Logger logger = LoggerFactory.getLogger(StrategyRepoImpl.class);

    private String fileName;

    private StrategyMapper strategyMapper;

    public StrategyRepoImpl(@Value("${strategies.file.name}") String fileName, StrategyMapper strategyMapper) {
        this.fileName = fileName;
        this.strategyMapper = strategyMapper;
    }

    @Override
    public List<ImportedStrategy> getStrategies() {
        var strategiesFilePath = Paths.get(fileName);
        String data = "";

        try {
            data = Files.readString(strategiesFilePath);
        } catch (IOException e) {
            logger.error("Unable to read strategies due to", e);
        }
        var strategiesList = new ArrayList<>(Arrays.asList(data.split("\\R")));
        strategiesList.remove(0);
        var strategies = strategiesList.stream().map(ss -> strategyMapper.toStrategy(ss)).collect(Collectors.toList());
        logger.info("Returning {} strategies", strategies.size());
        return strategies;
    }
}
