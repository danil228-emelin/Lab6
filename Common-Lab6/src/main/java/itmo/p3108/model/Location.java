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

@Data
@Builder
@XmlRootElement(name = "location")
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@AllArgsConstructor
public class Location implements Serializable {
    @Serial
    private static final long serialVersionUID = 498788001L;
    @XmlElement(name = "x")
    private Double locationX;
    @XmlElement(name = "y")
    private Float locationY;
    @XmlElement(name = "z")
    private Float locationZ;
    @XmlElement(name = "name")
    private String locationName;

    @Override
    public String toString() {
        return String.format("Location{x=%f, y=%f, z=%f ,name=%s}", locationX, locationY, locationZ, locationName);
    }

}
