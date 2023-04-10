package itmo.p3108.command.type;

public interface OneArgument extends Command{
    String execute(Object argument);
    Object getParameter();
}
