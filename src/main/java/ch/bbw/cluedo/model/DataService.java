package ch.bbw.cluedo.model;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DataService {
    private ArrayList<Person> persons = new ArrayList<Person>();
    private ArrayList<Weapon> weapons = new ArrayList<Weapon>();
    private ArrayList<Room> rooms = new ArrayList<Room>();
    private ArrayList<String> history;

    public DataService() {
        this.persons.add(new Person("John"));
        this.persons.add(new Person("Bingus"));

        this.weapons.add(new Weapon("Ak47"));
        this.weapons.add(new Weapon("Attack Helicopter"));

        this.rooms.add(new Room("Secret Room 1"));
        this.rooms.add(new Room("Secret Room 2"));
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
