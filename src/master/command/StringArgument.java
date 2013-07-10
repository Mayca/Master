package master.command;

public class StringArgument extends Argument{
    private String value;
    public StringArgument(String value){
        super("String");
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
