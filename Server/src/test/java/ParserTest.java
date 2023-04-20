import itmo.p3108.parser.Parser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

public class ParserTest {

    @Test
    public void check_parser_write() throws JAXBException, FileNotFoundException {
        Parser.write("D:\\IntelliJ IDEA 2022.2.3\\Lab6\\Server\\src\\test\\resources\\collectionTest");
        Assertions.assertTrue(true);


    }
}
