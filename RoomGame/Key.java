public class Key  extends GameObject{
    Container container;
    public Key(String name, boolean moveable, Container x) {
        super(name, moveable);
        this.container = x;
    }
    public boolean fit (Container x){
        if (this.container.getName().equals(x.getName())){
            return true;
        } else{
            return false;
        }

    }

}