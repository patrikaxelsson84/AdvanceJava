public class Person extends Npc{
    private int position;
    int CurrentRoom;
    private Game game;

    public Person(String name, int startRoom, Game game) {
        super(name);
        this.position = startRoom;
        this.game = game;
       // this.inventory = new Inventory(1);
    }

    @Override
    public void run() {
        this.CurrentRoom = this.position;
        int random = (int)(Math.random()*4);
        this.position = random;
        System.out.println(this+" "+position);
        try {
            //Adding a npc to the new room and removing the npcs from the last position
            game.getRoom(this.CurrentRoom).removeNpc(this);
            game.getRoom(this.position).addNpc(this);
        }catch (Exception e ){
            e.printStackTrace();
        }

    }
}