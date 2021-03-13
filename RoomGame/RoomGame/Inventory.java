import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

public class Inventory {

    private GameObject[] list;
    private int size;

    public Inventory(int size){
        this.size = size;
        list = new GameObject[size];
    }
    public void addObject(GameObject go){
        int index = getFirstEmptyIndex();

        if (index ==-1){
            System.out.println("Inventory är fullt");
            return;
        }
        this.list[index] = go;
    }
    public void removeObject(GameObject go) {
        for (int i = 0; i <this.list.length; i++){
            if (go.equals(this.list[i])){
                list[i] = null;
            }
        }
    }
    public void moveObject(Inventory i2, GameObject go) {
        //if (!isObjectHere(go)){ //Felmeddelande}
        i2.addObject(go);
        //this.removeObject(go);
    }
    public String toString(){
        return Arrays.toString(this.list);
    }

    private int getFirstEmptyIndex(){

        for (int i = 0; i<this.list.length; i++){
            if (this.list[i] == null){
                return i;
            }
        }
        return -1;


    }

    public GameObject getRandomObject(boolean ignoreMovable) {
        for (int i = 0; i <this.list.length; i++){
            if (this.list[i] != null && (!ignoreMovable && this.list[i].moveable)){
                return list[i];
            }
        }
        return null;
    }
}