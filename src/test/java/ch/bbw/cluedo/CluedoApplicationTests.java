package ch.bbw.cluedo;

import ch.bbw.cluedo.model.DataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CluedoApplicationTests {
	private Crime suggestion;
	private Crime secret;
	private GameLogic gamelogic;

	@BeforeEach
	private void setupBeforeEachTest(){
		suggestion = new Crime();
		secret = new Crime();
		gamelogic = new GameLogic();
	}

	@Test
	void correctGuessingCrime() {
		int numberOfSuggestion = 0;
		int maxNumberOfSuggestions= 8;

		secret.setActor(0);
		secret.setWeapon(0);
		secret.setScene(0);

		suggestion.setActor(0);
		suggestion.setWeapon(0);
		suggestion.setScene(0);
		//return true is expected
		assertTrue(gamelogic.evaluateSuggestion(suggestion, secret, numberOfSuggestion, maxNumberOfSuggestions));
	}

	@Test
	void incorrectGuessingCrime() {
		int numberOfSuggestion = 0;
		int maxNumberOfSuggestions= 8;

		secret.setActor(1);
		secret.setWeapon(0);
		secret.setScene(0);

		suggestion.setActor(0);
		suggestion.setWeapon(0);
		suggestion.setScene(0);
		//return true is expected
		assertFalse(gamelogic.evaluateSuggestion(suggestion, secret, numberOfSuggestion, maxNumberOfSuggestions));
	}

	@Test
	void exceededGuessingCrime() {
		int numberOfSuggestion = 9;
		int maxNumberOfSuggestions= 8;

		secret.setActor(0);
		secret.setWeapon(0);
		secret.setScene(0);

		suggestion.setActor(0);
		suggestion.setWeapon(0);
		suggestion.setScene(0);

		//return true is expected
		assertFalse(gamelogic.evaluateSuggestion(suggestion, secret, numberOfSuggestion, maxNumberOfSuggestions));
	}
}
