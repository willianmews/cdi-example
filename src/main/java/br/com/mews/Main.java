package br.com.mews;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.jboss.weld.environment.se.events.ContainerInitialized;

/**
 * @author wmews
 */
public class Main {

	@Inject
	private ATM atm;

	public void deposit(@Observes ContainerInitialized con) {
		this.atm.deposit(10);
	}

	public void take(@Observes ContainerInitialized con) {
		this.atm.take(110);
	}

	public static void main(String[] args) {
		WeldContainer weld = new Weld().initialize();
		ATM atm = weld.instance().select(ATM.class).get();
		atm.deposit(10);
		atm.take(110);
	}
}
