public abstract class Npc {
    protected String name;
    protected Inventory inventory;

    public Npc(String name){
        this.name = name;
        this.inventory = new Inventory(1);
    }
    public Inventory getInventory() {
        return this.inventory;
    }
    public String toString (){
        return this.name + " is carrying:" + this.inventory;
    }



}