package com.capg.online.wallet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import com.capg.online.wallet.dao.WalletAccountDao;
import com.capg.online.wallet.dao.WalletAccountDaoImpl;
import com.capg.online.wallet.model.WalletAccount;
import com.capg.online.wallet.model.WalletTransaction;
import com.capg.online.wallet.service.WalletAccountService;
import com.capg.online.wallet.service.WalletAccountServiceImpl;
import com.capg.online.wallet.util.InvaildAmountException;

public class AppTest 
{
	WalletAccountService service=new WalletAccountServiceImpl();
	static WalletAccountDaoImpl dao=new WalletAccountDaoImpl();
	static Map<Long, WalletAccount> walletAccounts;
	static WalletAccount ac1;
	@BeforeAll
	public static void addSomeWalletAccount() {
		walletAccounts=dao.getWalletAccounts();
		 ac1=new WalletAccount(1001125256L,5000.0F,95646485L,"Pritam",
					Arrays.asList(new WalletTransaction(1594646L,LocalDate.now()),
							new WalletTransaction(106564L,LocalDate.now().minusDays(10)),
							new WalletTransaction(1054625L,LocalDate.now().minusDays(1))));
		
		walletAccounts.put(ac1.getWalletId(), ac1);
	}
	
	//Checking Get Account
	@RepeatedTest(value = 3)
	public void testGetAccountInfo() {
		WalletAccount account=service.getAccountInfo(1001125256);
		assertEquals(ac1, account);
	}
	
	
	//Checking For Invaild Amount Exception
	@Nested
	class CheckExceptions{
	@Test
	public void testInvaildAmountException() {
		assertThrows(InvaildAmountException.class, ()->{
			service.addAmount(1001125256,-50000);
		});
	}
	}
	
}