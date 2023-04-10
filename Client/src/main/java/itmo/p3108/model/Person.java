package itmo.p3108.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serial;
import java.io.Serializable;

/**
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 498787001L;
    private Long personId;
    private String personName;
    private Coordinates coordinates;
    private java.time.ZonedDateTime personCreationDate;
    private Double personHeight;
    private java.time.LocalDate personBirthday;
    private Color personEyeColor;
    private Country personNationality;
    private Location location;


    @Override
    public int hashCode() {
        int result = personId.hashCode();
        result = 31 * result + personName.hashCode();
        result = 31 * result + coordinates.hashCode();
        result = 31 * result + personCreationDate.hashCode();
        result = 31 * result + personHeight.hashCode();
        result = 31 * result + personBirthday.hashCode();
        result = 31 * result + personEyeColor.hashCode();
        result = 31 * result + personNationality.hashCode();
        result = 31 * result + location.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Person person) {
            return this.personName.equals(person.personName) && this.coordinates.equals(person.coordinates) && this.personHeight.equals(person.personHeight) && this.personBirthday.equals(person.personBirthday) && this.personEyeColor.equals(person.personEyeColor) && this.personNationality.equals(person.personNationality) && this.location.equals(person.location);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Person{" + "\n" + "personId=" + personId + "\n" + "personName='" + personName + '\'' + "\n" + "coordinates=" + coordinates + "\n" + "personCreationDate=" + personCreationDate + "\n" + "personHeight=" + personHeight + "\n" + "personBirthday=" + personBirthday + "\n" + "personEyeColor=" + personEyeColor + "\n" + "personNationality=" + personNationality + "\n" + "location=" + location + "\n" + '}';
    }


}
