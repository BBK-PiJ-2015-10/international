package com.check.trader.source;

import com.check.trader.entity.ImportedStrategy;

import java.util.List;

public interface StrategyRepo {

    List<ImportedStrategy> getStrategies();
}
