package master.command;

import java.util.ArrayList;

public class ArgumentList extends ArrayList<Argument>{
     public void getArgumentVector(Object[] commandVector) {
        int i = 1;
        for (Argument argument : this) {
            commandVector[i] = getValue(argument);
            i++;
        }
    }

    private Object getDoubleValue(DoubleArgument doubleArgument) {
       return doubleArgument.getValue();
    }

    private Object getIntegerValue(IntegerArgument integerArgument) {
        return integerArgument.getValue();
    }
    
    private Object getStringValue(StringArgument stringArgument) {
        return stringArgument.getValue();
    }

    private Object getValue(Argument argument) {
        if (argument instanceof DoubleArgument)
           return getDoubleValue((DoubleArgument) argument);
        if (argument instanceof IntegerArgument) 
           return getIntegerValue((IntegerArgument) argument);
        if (argument instanceof DoubleArgument)
           return  getStringValue((StringArgument) argument);
        return null;
    }
}
