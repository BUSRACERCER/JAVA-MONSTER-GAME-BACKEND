package Adventure;

public abstract class NormalLocation extends Location {
    public NormalLocation(Player player, String name) {
        super(player);
        this.name = name;
    }

    public boolean getLocation() {
        //mağazaya yada diğer yere gidince oyunum bitmiyor o yüzden true yaptık
        return true;
    }
}
