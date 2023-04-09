package itmo.p3108.util;

import itmo.p3108.command.type.Command;
import lombok.Data;

@Data
public class WrapperArgument {
    private Command command;
    private String[] argument;
}
