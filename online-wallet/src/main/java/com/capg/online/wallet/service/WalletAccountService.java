package com.capg.online.wallet.service;

import com.capg.online.wallet.model.WalletAccount;
import com.capg.online.wallet.util.InvaildAmountException;

public interface WalletAccountService {

	public WalletAccount getAccountInfo(long id);
	
	public boolean addAmount(long id, float amount)throws InvaildAmountException;
}
