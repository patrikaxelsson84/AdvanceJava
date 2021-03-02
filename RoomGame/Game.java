import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Game {
    private Gui gui;
    private Room room1, room2, room3, room4;
    private Room[] map ;

    public Game(){
        //Skapa rum!
        room1 = new Room("MainRoom","Main room whit some stuff");
        room2 = new Room("Room2", "A small green room");
        room3 = new Room("Room3", "An old office with crushed stuff inside");
        room4 = new Room("Room4", "Butchers room");

        map = new Room[4];
        map[0] = room1;
        map[1] = room2;
        map[2] = room3;
        map[3] = room4;

        //Gameobjects
        GameObject lamp = new GameObject("Ceiling lamp", false);
        GameObject Sofa = new GameObject("Red sofa",false);
        GameObject Furnance = new GameObject("Furnance",false);
        GameObject Rock = new GameObject("Rock",true);
        GameObject Shoes = new GameObject("old Shoes",true);
        GameObject Knife = new GameObject("Knife",true);

        Container box = new Container("A green box", false, true);
        room1.addObject(Sofa);
        room1.addObject(Rock);
        room1.addObject(Rock);
        room2.addObject(box);
        room3.addObject(Knife);
        room3.addObject(Shoes);
        room3.addObject(Rock);
        room3.addObject(Rock);
        room4.addObject(Furnance);
        room4.addObject(Knife);

        Person Jason = new Person("Jason",0, this);
        Person Freddy = new Person("Freddy",0, this);
        Person TureSventon = new Person("Ture Sventon",0, this);
        Player player = new Player();

        ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(3);
        pool.scheduleAtFixedRate(Jason, 5, 12, TimeUnit.SECONDS);
        pool.scheduleAtFixedRate(Freddy, 5, 12, TimeUnit.SECONDS);
        pool.scheduleAtFixedRate(TureSventon, 5, 12, TimeUnit.SECONDS);

        room2.addNpc(Jason);
        room3.addNpc(Freddy);
        room4.addNpc(TureSventon);


        Jason.getInventory().addObject(null);
        Freddy.getInventory().addObject(null);
        TureSventon.getInventory().addObject(null);

        System.out.println(Jason);
        Inventory inventory = new Inventory(5);
        System.out.println(inventory);


        inventory.addObject(lamp);
        inventory.addObject(lamp);
        System.out.println(inventory);

        /*
        System.out.println(lampa);
        System.out.println(lampa.isMoveable());
        System.out.println(kanin);
        System.out.println(kanin.isMoveable());
*/
        //[room1, room2]

        //Starta guit!
        this.gui = new Gui();

        //System.out.println(map[1]);
        //gui.setShowRoom(map[1].toString());
        int position = 0;
        gui.setShowRoom(map[position].toString());
//[r1, r2, r3]
        while (true) {

            String command = gui.getCommand();
            if (!command.equals("-1")) {

                if (command.equals("1")) {
                    position = 0;
                }
                if (command.equals("2")) {
                    position = 1;
                }
                if (command.equals("3")) {
                    position = 2;
                }
                if (command.equals("4")) {
                    position = 3;
                }
                if (command.contains("add")){
                    if (command.contains("Knife")){
                        inventory.addObject(Knife);
                    }
                }

            }

            gui.setShowRoom(map[position].toString());
            gui.setShowInventory(inventory);

            if (map[position].getPersons() != null) {
                gui.setPerson(map[position].getPersons());
            }

        }


        /*
        while (true) {
            String command = gui.getCommand();
            System.out.println(command);
        }*/
    }
    public Room getRoom(int i){
        return map[i];
    }
}