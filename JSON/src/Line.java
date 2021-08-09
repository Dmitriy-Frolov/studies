import java.util.ArrayList;
import java.util.List;

public class Line{

    String name;
    String number;
    List<List<Station>> stations;

    public Line(String number, String name) {
        this.name = name;
        this.number = number;
    }

//    public Line(String lineNumber, List<String> stations) {
//        this.lineNumber = lineNumber;
//        this.stations = stations;
//    }

}
