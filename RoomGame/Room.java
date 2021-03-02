public class Room {
    private String name;
    private String description;
    private Inventory inventory;
    private Person[] person;

    public Room(String roomName, String roomDescription){
        this.person = new Person[5];
        this.name = roomName;
        this.description= roomDescription;
        this.inventory = new Inventory(10);
    }
    public boolean addNpc(Person person){
        int i = FirstEmpty();
        if  (i == -1){
            return false;
        }
        this.person[i] = person;
        return true;
    }
    private int FirstEmpty(){
        for (int i = 0; i<this.person.length;i++){
            if (this.person[i] == null){
                return i;
            }
        }
        return -1;
    }

    public Person[] getPersons(){
        return this.person;
    }
    public void addObject(GameObject go){
        this.inventory.addObject(go);
    }
    public String toString(){
        return name+" : "+description +"\n" +inventory;
    }
    public void removeNpc(Npc npc){
        for (int i = 0; i<this.person.length;i++){
            if (this.person[i] == npc){
                this.person[i] = null;
            }
        }
    }
}