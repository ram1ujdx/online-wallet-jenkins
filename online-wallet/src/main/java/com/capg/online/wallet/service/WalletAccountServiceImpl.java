package com.capg.online.wallet.service;

import com.capg.online.wallet.dao.WalletAccountDao;
import com.capg.online.wallet.dao.WalletAccountDaoImpl;
import com.capg.online.wallet.model.WalletAccount;
import com.capg.online.wallet.util.InvaildAmountException;

public class WalletAccountServiceImpl implements WalletAccountService {

	
	WalletAccountDao walletDao=new WalletAccountDaoImpl();
	@Override
	public WalletAccount getAccountInfo(long id) {
		return walletDao.getWalletAccountById(id);
	}

	@Override
	public boolean addAmount(long id, float amount) {
		if(amount<50) {
			throw new InvaildAmountException("Amount should be gtreater than 50");
		}
		return walletDao.addAmount(id, amount);
	}

}
