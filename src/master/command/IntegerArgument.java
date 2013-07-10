package master.command;

public class IntegerArgument extends Argument{
    private int value;
    public IntegerArgument(int value){
        super("Integer");
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
