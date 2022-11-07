package ch.bbw.cluedo;

import ch.bbw.cluedo.model.DataService;

import java.util.random.RandomGenerator;

/**
 * GameLogic
 *
 * @author Peter Rutschmann
 * @version 18.09.2022
 */
public class GameLogic {

    /**
     * Setup randomly the secret of the game.
     * @param service Contains the list for actors, weapons and scenes.
     * @param secret  Randomly generate the secret for actor, weapon and scene.
     */
    public static void setupNewGame(DataService service, Crime secret){
        //To be done
        secret.setScene((int) (Math.random() * service.getRooms().size()));
        secret.setActor((int) (Math.random() * service.getPersons().size()));
        secret.setWeapon((int) (Math.random() * service.getWeapons().size()));
    }

    /**
     * Evaluates the suggestion to find the solution of the game.
     * @param suggestion The suggestion from the player
     * @param secret The game secret.
     * @param numberOfSuggestion Current number of suggestion
     * @param maxNumberOfSuggestions Max number of possible suggestions
     * @return true if games ends, false if another suggestion is allowed
     */
    public static boolean evaluateSuggestion(Crime suggestion, Crime secret, int numberOfSuggestion, int maxNumberOfSuggestions){
        if(suggestion.getActor() != secret.getActor()){
            suggestion.addHistory("0");
            return false;
        }
        if(suggestion.getScene() != secret.getScene()){
            suggestion.addHistory("1");
            return false;
        }
        if(suggestion.getWeapon() != secret.getWeapon()){
            suggestion.addHistory("2");
            return false;
        }

        if(numberOfSuggestion > maxNumberOfSuggestions){
            suggestion.addHistory("3");
            return false;
        }

        suggestion.addHistory("gewonnen");
        return true;
    }
}