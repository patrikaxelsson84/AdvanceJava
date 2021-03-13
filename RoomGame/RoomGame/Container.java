public class Container extends GameObject{

    private Inventory inventory;
    private boolean locked;
    private boolean open;

    public Container(String name, boolean moveable, boolean locked){
        super(name,moveable);
        this.inventory = new Inventory(3);
        this.locked = locked;
    }

    public Inventory getInventory(){
        return this.inventory;
    }
    public boolean isLocked(){
        return this.locked;
    }
    public boolean isOpen() {
        return this.open;
    }



}
