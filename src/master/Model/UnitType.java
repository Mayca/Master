package master.Model;

public class UnitType {
    
    public final static UnitType MASTER = new UnitType();
    public final static UnitType SLAVE = new UnitType();
    private static final String SLAVE_ID = "SLAVE";
    private static final String MASTER_ID = "MASTER";
    
    private UnitType() {
    }
    
    public static UnitType get(String name) {
        if (name.equals(MASTER_ID))
            return MASTER;
        if (name.equals(SLAVE_ID))
            return SLAVE;
        return null;
    }
    
    public boolean isMaster() {
        return this == MASTER;
    }
    
    public boolean isSlave() {
        return this == SLAVE;
    }
    
}
