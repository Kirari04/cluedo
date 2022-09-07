package ch.bbw.cluedo.model;

import com.github.javafaker.Dog;
import com.github.javafaker.Faker;
import com.talanlabs.avatargenerator.Avatar;
import com.talanlabs.avatargenerator.eightbit.EightBitAvatar;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Objects;
import java.util.Random;

@Service
public class DataService {
    private ArrayList<Person> persons = new ArrayList<Person>();
    private ArrayList<Weapon> weapons = new ArrayList<Weapon>();
    private ArrayList<Room> rooms = new ArrayList<Room>();
    private ArrayList<String> history;

    public DataService() {
        this.init();
    }

    public void reset(){
        this.persons = new ArrayList<Person>();
        this.weapons = new ArrayList<Weapon>();
        this.rooms = new ArrayList<Room>();

        this.init();
    }

    public void init(){
        Faker faker = new Faker();
        for (int i = 0; i < 10; i++){
            Dog dog = faker.dog();
            String gender = dog.gender();
            Avatar avatar = switch (gender) {
                case "female" -> EightBitAvatar.newFemaleAvatarBuilder().build();
                case "male" -> EightBitAvatar.newMaleAvatarBuilder().build();
                default -> EightBitAvatar.newMaleAvatarBuilder().build();
            };

            BufferedImage image = avatar.create(new Random().nextLong());

            this.persons.add(new Person(
                    dog.name(),
                    randomNumber(99),
                    randomNumber(99),
                    gender,
                    imgToBase64String(image, "png")
            ));

            this.weapons.add(new Weapon(faker.gameOfThrones().dragon()));

            this.rooms.add(new Room(faker.friends().location()));
        }
    }

    private static int randomNumber(int upperbound){
        Random rand = new Random();
        int lowerbound = 1;
        return rand.nextInt(upperbound - lowerbound) + lowerbound;
    }

    public static String imgToBase64String(final RenderedImage img, final String formatName) {
        final ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            ImageIO.write(img, formatName, os);
            return Base64.getEncoder().encodeToString(os.toByteArray());
        } catch (final IOException ioe) {
            throw new UncheckedIOException(ioe);
        }
    }


    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(ArrayList<Weapon> weapons) {
        this.weapons = weapons;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }

    public ArrayList<String> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<String> history) {
        this.history = history;
    }
}
