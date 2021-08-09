import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.List;

public class JSONParsing {

    public static void main(String[] args) {

        JSONParser jsonParser = new JSONParser();

        try(FileReader fileReader = new FileReader("Data\\map.json")) {

            JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);

            JSONArray jsonArrayStations = (JSONArray) jsonObject.get("Lines");

            String number;
            int stations;
            List<String> connections;
            int sum = 0;
            for (Object o : jsonArrayStations) {
                JSONObject object = (JSONObject) o;
                number = (String) object.get("number");
                JSONArray jsonArray = (JSONArray) object.get("stations");
                for (Object ob : jsonArray){
                    JSONArray obj = (JSONArray) ob;
                    stations = obj.size();
                    System.out.println("Количество станций на линии № " + number + " : " + stations);
                    for (Object objectConnections : obj){
                        JSONObject objectConnect = (JSONObject) objectConnections;
                        connections = (List<String>) objectConnect.get("connections");
                        if (connections != null){
                            sum += 1;
                        }
                    }
                }
            }
            System.out.println("Количество переходов в метро: " + sum);
        } catch (Exception exception) {
            exception.getStackTrace();
        }
    }
}
