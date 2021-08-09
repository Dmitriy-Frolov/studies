import java.util.ArrayList;
import java.util.List;

public class Station {

    String number;
    String name;
    List<ConnectionStation> connections;

    public Station(String number, String name) {
        this.name = name;
        this.number = number;
        this.connections = new ArrayList<>();
    }

    public void add(ConnectionStation connectionStation) {
        this.connections.add(connectionStation);
    }

    public static class ConnectionStation{
        String numberLine;
        String nameStation;

        public ConnectionStation(String numberLine, String nameStation) {
            this.numberLine = numberLine;
            this.nameStation = nameStation;
        }
    }
}
