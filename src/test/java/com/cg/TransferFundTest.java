package com.cg;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.cg.entity.Account;
import com.cg.repo.AccountRepo;
import com.cg.service.AccountService;

@SpringBootTest
public class TransferFundTest {
	@MockitoBean
	private AccountRepo repo;
	@Autowired
	private AccountService accService;
	private Optional<Account> optAcc1,optAcc2,optAcc3;
	@BeforeEach
	public void beforeEach() {
		Account acc1=new Account(1001, "ram", 5000.0);
		Account acc2=new Account(1002, "tom", 7000.0);
		optAcc1=Optional.ofNullable(acc1);
		optAcc2=Optional.ofNullable(acc2);
		optAcc3=Optional.empty();
	}
	@Test
	public void testTransferFund1() {
		Mockito.when(repo.findById(1001)).thenReturn(optAcc1);
		Mockito.when(repo.findById(1002)).thenReturn(optAcc2);
		Mockito.when(repo.save(Mockito.any(Account.class))).thenReturn(new Account());
		// CORRECT - both 1001 and 1002 are mocked above
		assertTrue(accService.transferFund(1001, 1002, 2000.0));
	}
}