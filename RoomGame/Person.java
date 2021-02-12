public class Person extends Npc{
    private int position;

    public Person(String name, int startRoom) {
        super(name);
        this.position = startRoom;
       // this.inventory = new Inventory(1);
    }

    @Override
    public void run() {

    }
}