/**
 *
 */
package br.com.mews.junit;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.mews.ATM;
import br.com.mews.BankAccount;


/**
 * @author wmews
 *
 */
@RunWith(WeldJUnit4Runner.class)
public class ATMTest {

	@Inject
	private ATM atm;
	@Inject
	private BankAccount bankAccount;

	@Test
	public void testInjections() {
		assertNotNull(atm);
		assertNotNull(bankAccount);
	}

	@Test
	public void testDeposit() {
		bankAccount.setBalance(0);
		atm.deposit(10);
		Assert.assertEquals(bankAccount.getBalance(), 10);
	}

	@Test
	public void testTake() {
		bankAccount.setBalance(10);
		atm.take(10);
		Assert.assertEquals(bankAccount.getBalance(), 0);
	}
}
