import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

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


    // Denna bestämmer vad som ska hända näst (byta rum, ta upp eller lägga ned items)
    public void scheduleAction() {
        int nextAction = Util.random(0, 3);
        if (nextAction == 0) {
            // Byt rum
            // Om vi ska byta rum, lägg en schedule på "run" igen bara mellan 10 och 15 sekunder
            game.pool.schedule(() -> {
                this.CurrentRoom = this.position;
                int random = Util.random(0, 5);
                this.position = random;
                System.out.println(this.name + " byte rum till " + this.game.getRoom(this.position).getName() + "(" + this.position + ")");

                try {
                    //Adding a npc to the new room and removing the npcs from the last position
                    game.getRoom(this.CurrentRoom).removeNpc(this);
                    game.getRoom(this.position).addNpc(this);
                }catch (Exception e ){
                    e.printStackTrace();
                }

                this.scheduleAction();
            }, Util.random(10, 15), TimeUnit.SECONDS);
        } else if (nextAction == 1) {
            // Ta upp något
            // lambda



            // Om vi tar upp så gör vi en ny runnable (lambda) och kör den koden.
            game.pool.schedule(() -> {
                // Ta upp ett objekt ifrån rummet och lägg till i npc inventory -----
                Inventory roomInventory = this.game.getRoom(this.position).getInventory();
                GameObject randomObject = roomInventory.getRandomObject(false);
                if (randomObject != null) {
                    roomInventory.removeObject(randomObject);
                    this.inventory.addObject(randomObject);

                    System.out.println("NPC " + this.name + " tog upp " + randomObject.getName());
                }
                //--------------

                // Eftersom schedule bara kör en gång så måste vi starta den igen
                this.scheduleAction();
            }, Util.random(2, 5), TimeUnit.SECONDS);
        } else {
            // Lägg ned något

            // Om vi lägger ned något så gör vi en ny runnable (lambda) och kör den koden.
            game.pool.schedule(() -> {
                // Lägg ned ett objekt i rummet och ta bort ifrån npc inventory -----
                Inventory roomInventory = this.game.getRoom(this.position).getInventory();
                GameObject randomObject = this.inventory.getRandomObject(false);

                if (randomObject != null) {
                    roomInventory.addObject(randomObject);
                    this.inventory.removeObject(randomObject);

                    System.out.println("NPC " + this.name + " lade ned " + randomObject.getName());
                }
                // -----

                // Eftersom schedule bara kör en gång så måste vi starta den igen
                this.scheduleAction();
            }, Util.random(2, 5), TimeUnit.SECONDS);
        }
    }
}