package itmo.p3108.command;

import itmo.p3108.PersonReadingBuilder;
import itmo.p3108.command.type.Command;
import itmo.p3108.model.*;
import itmo.p3108.util.CheckData;
import itmo.p3108.util.Checking;
import itmo.p3108.util.Invoker;
import itmo.p3108.util.SerializeObject;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Optional;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AnalyzeExecuteScript {


    /**
     * Class AnalyzerExecuteScript analyze lines from execute script
     * it needs to detect add command
     */
    private static final String ADD_EXECUTE_SCRIPT_EXCEPTION1 = "Error add:next line empty ,but it  must have arguments";
    private static final String[] ADD_PROPER_ARGUMENTS_ORDER = {"personName", "coordinatesX", "coordinatesY", "personHeight", "personBirthday", "PersonEyeColorNumber", "PersonNationalityNumber", "locationX", "locationY", "locationZ", "locationName"};
    private static final int ARGUMENT_AMOUNT = 11;

    public static void analyze(String[] commands) {

        Invoker invoker = Invoker.getInstance();
        var commadcounter = 0;
        while (commadcounter < commands.length) {

            String commandLine = commands[commadcounter].trim();
            String[] commandArguments = commandLine.split("\\s+");
            String commandName = commandArguments[0].toLowerCase();
            if (!commandName.equals("add")) {
                log.info(String.format("Analyze Command from script-%s", commandName));

                Optional<Command> optional = invoker.invoke(commandLine);
                optional.ifPresent(SerializeObject::serialize);
                commadcounter++;
                continue;
            }
            if (commadcounter == commands.length - 1) {

                log.error(ADD_EXECUTE_SCRIPT_EXCEPTION1);
                log.error(Arrays.toString(ADD_PROPER_ARGUMENTS_ORDER));
                System.err.println(ADD_EXECUTE_SCRIPT_EXCEPTION1);
                System.err.println(Arrays.toString(ADD_PROPER_ARGUMENTS_ORDER));

                commadcounter++;
                continue;
            }
            String addArguments = commands[commadcounter + 1];
            if (addArguments.trim().split(",").length != ARGUMENT_AMOUNT) {
                log.error(Arrays.toString(ADD_PROPER_ARGUMENTS_ORDER));
                System.err.println(Arrays.toString(ADD_PROPER_ARGUMENTS_ORDER));
                commadcounter += 2;
                continue;
            }

            String[] arguments = addArguments.trim().split(",");
            CheckData checkData = new CheckData();
            if (checkData.wrapperCheckArguments
                    (arguments, Checking.class,
                            ADD_PROPER_ARGUMENTS_ORDER)) {
                Person person = Person.builder().personId(PersonReadingBuilder.getInstance().createId()).personName(arguments[0].trim()).coordinates(Coordinates.builder().coordinatesX(Integer.valueOf(arguments[1])).coordinatesY(Float.valueOf(arguments[2].trim())).build()).personHeight(Double.parseDouble(arguments[3].trim())).personBirthday(LocalDate.parse(arguments[4].trim(), DateTimeFormatter.ofPattern("MM-dd-yyyy"))).personEyeColor(Color.newValue(arguments[5].trim()).get()).personNationality(Country.newValue(arguments[6].trim()).get()).location(Location.builder().locationX(Double.parseDouble(arguments[7].trim())).locationY(Float.valueOf(arguments[8].trim())).locationZ(Float.parseFloat(arguments[9].trim())).locationName(arguments[10].trim()).build()).build();
                person.setPersonCreationDate(ZonedDateTime.now());
                Optional<Command> optionalAdd = FlyWeightCommandFactory.getInstance().getCommand("add");
                optionalAdd.ifPresent(x -> {
                    ((Add) x).setPerson(person);
                    SerializeObject.serialize(x);
                });
            }
            commadcounter += 2;
        }


    }
}

