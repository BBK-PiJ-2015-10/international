package com.check.trader.mapper;

import com.check.trader.entity.ImportedStrategy;
import org.springframework.stereotype.Component;


@Component
public class StrategyMapperImpl implements StrategyMapper {

    @Override
    public ImportedStrategy toStrategy(String strategyString) {
        var strategyArray = strategyString.split(",");
        var id = Integer.valueOf(strategyArray[0]);
        var minRiskLevel = Integer.valueOf(strategyArray[1]);
        var maxRiskLevel = Integer.valueOf(strategyArray[2]);
        var minYearsToRetirement = Integer.valueOf(strategyArray[3]);
        var maxYearsToRetirement = Integer.valueOf(strategyArray[4]);
        var stockPercentage = Double.valueOf(strategyArray[5]);
        var cashPercentage = Double.valueOf(strategyArray[6]);
        var bondPercentage = Double.valueOf(strategyArray[7]);
        var strategy = new ImportedStrategy(id, minRiskLevel, maxRiskLevel, minYearsToRetirement, maxYearsToRetirement, stockPercentage, cashPercentage, bondPercentage);
        return strategy;
    }
}
