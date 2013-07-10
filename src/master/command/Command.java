package master.command;

public class Command {
    private String commandName;
    private ArgumentList argumentList;

    public Command(String commandName, ArgumentList argumentList) {
        this.commandName = commandName;
        this.argumentList = argumentList;
    }

    public String getCommandName() {
        return commandName;
    }

    public ArgumentList getArgumentList() {
        return argumentList;
    }
    
    
           
}
