package master.command;

public class DoubleArgument extends Argument{
    private double value;
    public DoubleArgument(double value){
        super("Double");
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
