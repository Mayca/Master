
package master.command;
public class CommandFactory {

    public CommandFactory() {
    }
    
    public Object[] separateCommand(Command command){
        Object[] commandVector = new Object[command.getLength()];
        commandVector[0] = command.getCommandName();
        command.getArgumentList().getArgumentVector(commandVector);
        return commandVector;
    }

  
}
