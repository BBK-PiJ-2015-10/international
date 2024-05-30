package com.check.trader.mapper;

import com.check.trader.entity.ImportedStrategy;

public interface StrategyMapper {

    ImportedStrategy toStrategy(String strategy);

}
