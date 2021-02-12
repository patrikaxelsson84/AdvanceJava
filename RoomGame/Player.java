
public class Player {

    private int playerPos = 0;
    private Inventory inventory;

    public int getPlayerPosition(){

        return this.playerPos - 1;
    }
    
    public Inventory getInventory() {
        return this.inventory;
    }



    // public String name(){return "Player";}

}