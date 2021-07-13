package models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.tasksCalendar.models.User;

class TestUser {
	private User user;
	
	@BeforeEach
	void init() {
		this.user = new User();
	}
	@AfterEach
	void tearDown() {
		this.user = null;
	}
	
	@ParameterizedTest
	
	@ValueSource(strings = {"Jean", "Jean-Jacque", "azerty", "Z'he"})
	void setSurnameTest(String value) {
		user.setSurname(value);
		assertEquals(value, user.getSurname());
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"Dupond@", "Durand dupont321", "ddduuueoocnsihfskhqdgkqdbq", "(/ad_02"})
	void setNameLimit(String value) {
		assertThrows(RuntimeException.class, () -> user.setName(value));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"Jean@", "Jean-Jacque321", "ddduuueoocnsihfskhqdgkqdbq", "(/ad_02"})
	void setSurnameLimit(String value) {
		assertThrows(RuntimeException.class, () -> user.setSurname(value));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"Dupond", "Durand", "Durand dupont", "Dupont-Durand"})
	void setNameTest(String value) {
		user.setName(value);
		assertEquals(value, user.getName());
	}
	
	@Test
	void setPhoneTest() {
		String phone = "0606060606";
		user.setPhone(phone);
		assertEquals(phone, user.getPhone());
	}
	@ParameterizedTest
	@ValueSource(strings = {"06.05.05.06.01", "06020103020", "azertyuiop"})
	void setPhoneLimit(String value) {
		assertThrows(RuntimeException.class, () -> user.setPhone(value));
	}
	@Test
	void setMailTest() {
		String mail = "test@mail.fr";
		user.setMail(mail);	
		assertEquals(mail, user.getMail());
	}
	@ParameterizedTest
	@ValueSource(strings = {"test.15.com", "@.test", "test@com"})
	void setMailLimit(String value) {
		assertThrows(RuntimeException.class, () -> user.setMail(value));
	}
	
	@Test
	void setPasswordTest() {
		String password = "aZerty@1";
		user.setPassword(password);
		assertEquals(password, user.getPassword());
	}
	@ParameterizedTest
	@ValueSource(strings = {"azerty", "123456789", "azerty123", "azertyu123@", "AZERTY123@"})
	void setPasswordLimit(String value) {
		assertThrows(RuntimeException.class, () -> user.setMail(value));
	}
	
	@ParameterizedTest
	@ValueSource(strings = {"testpseudo", "Pseudo1", "TEST-PSEUDO"})
	void setPseudoTest(String value) {
		user.setPseudo(value);
		assertEquals(value, user.getPseudo());
	}
	
	

}
