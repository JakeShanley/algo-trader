package com.algoTrader.service;

import java.util.List;

import com.algoTrader.entity.Position;
import com.algoTrader.entity.Strategy;
import com.algoTrader.entity.Transaction;
import com.algoTrader.entity.marketData.Tick;
import com.algoTrader.entity.security.Security;
import com.algoTrader.entity.security.SecurityFamily;
import com.algoTrader.util.DateUtil;
import com.algoTrader.vo.PortfolioValueVO;

public class LookupServiceImpl extends LookupServiceBase {

	protected Security handleGetSecurity(int id) throws java.lang.Exception {

		return getSecurityDao().load(id);
	}

	protected Security handleGetSecurityByIsin(String isin) throws Exception {

		return getSecurityDao().findByIsin(isin);
	}

	protected Security handleGetSecurityBySymbol(String symbol) throws Exception {

		return getSecurityDao().findBySymbol(symbol);
	}

	protected Security handleGetSecurityFetched(int securityId) throws Exception {

		return getSecurityDao().findByIdFetched(securityId);
	}

	protected Strategy handleGetStrategy(int id) throws java.lang.Exception {

		return getStrategyDao().load(id);
	}

	protected Strategy handleGetStrategyByName(String name) throws Exception {

		return getStrategyDao().findByName(name);
	}

	protected Strategy handleGetStrategyByNameFetched(String name) throws Exception {

		return getStrategyDao().findByNameFetched(name);
	}

	protected SecurityFamily handleGetSecurityFamily(int id) throws Exception {

		return getSecurityFamilyDao().load(id);
	}

	protected Position handleGetPosition(int id) throws java.lang.Exception {

		return getPositionDao().load(id);
	}

	protected Position handleGetPositionFetched(int id) throws Exception {

		return getPositionDao().findByIdFetched(id);
	}

	protected Position handleGetPositionBySecurityAndStrategy(int securityId, String strategyName) throws Exception {

		return getPositionDao().findBySecurityAndStrategy(securityId, strategyName);
	}

	protected Transaction handleGetTransaction(int id) throws java.lang.Exception {

		return getTransactionDao().load(id);
	}

	protected Security[] handleGetAllSecurities() throws Exception {

		return getSecurityDao().loadAll().toArray(new Security[0]);
	}

	protected Strategy[] handleGetAllStrategies() throws Exception {

		return getStrategyDao().loadAll().toArray(new Strategy[0]);
	}

	protected Position[] handleGetAllPositions() throws Exception {

		return getPositionDao().loadAll().toArray(new Position[0]);
	}

	protected Transaction[] handleGetAllTransactions() throws Exception {

		return getTransactionDao().loadAll().toArray(new Transaction[0]);
	}

	protected Transaction[] handleGetAllTrades() throws Exception {

		return getTransactionDao().findAllTrades().toArray(new Transaction[0]);
	}

	protected Transaction[] handleGetAllCashFlows() throws Exception {

		return getTransactionDao().findAllCashflows().toArray(new Transaction[0]);
	}

	protected Security[] handleGetAllSecuritiesInPortfolio() throws Exception {

		return getSecurityDao().findSecuritiesInPortfolio().toArray(new Security[0]);
	}

	protected Security[] handleGetSecuritiesOnWatchlist() throws Exception {

		return getSecurityDao().findSecuritiesOnWatchlist().toArray(new Security[0]);
	}

	protected Position[] handleGetOpenPositions() throws Exception {

		return getPositionDao().findOpenPositions().toArray(new Position[0]);
	}

	protected Position[] handleGetOpenPositionsByStrategy(String strategyName) throws Exception {

		return getPositionDao().findOpenPositionsByStrategy(strategyName).toArray(new Position[0]);
	}

	protected PortfolioValueVO handleGetPortfolioValue() throws Exception {

		PortfolioValueVO portfolioValueVO = new PortfolioValueVO();
		portfolioValueVO.setSecuritiesCurrentValue(getStrategyDao().getPortfolioSecuritiesCurrentValueDouble());
		portfolioValueVO.setCashBalance(getStrategyDao().getPortfolioCashBalanceDouble());
		portfolioValueVO.setMaintenanceMargin(getStrategyDao().getPortfolioMaintenanceMarginDouble());
		portfolioValueVO.setNetLiqValue(getStrategyDao().getPortfolioNetLiqValueDouble());

		return portfolioValueVO;
	}

	protected Tick handleGetLastTick(int securityId) throws Exception {

		return getTickDao().findLastTickForSecurityAndMaxDate(securityId, DateUtil.getCurrentEPTime());
	}

	protected List<Strategy> handleGetAutoActivateStrategies() throws Exception {

		return getStrategyDao().findAutoActivateStrategies();
	}
}
