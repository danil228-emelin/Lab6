package itmo.p3108.command;

import itmo.p3108.model.Person;
import itmo.p3108.model.PersonReadingBuilder;

import java.time.ZonedDateTime;

public class CreatePerson {
    private static final PersonReadingBuilder personReadingBuilder = PersonReadingBuilder.getInstance();

    private CreatePerson() {
    }

    public static Person createPerson() {
        Person
                person = Person
                .builder()
                .personName(personReadingBuilder.createName())
                .personId(personReadingBuilder.createId())
                .personHeight(personReadingBuilder.createHight())
                .personEyeColor(personReadingBuilder.createColor())
                .personNationality(personReadingBuilder.createNationality())
                .personBirthday(personReadingBuilder.createBirthDay())
                .coordinates(personReadingBuilder.createCoordinates())
                .location(personReadingBuilder.createLocation())
                .build();
        person.setPersonCreationDate(ZonedDateTime.now());
        return person;
    }
}
