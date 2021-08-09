import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static List<Line> lineList;
    private static List<Station> stationsList;
    private static List<Station.ConnectionStation> connectionsList;

    public static void main(String[] args) {
        Document document;

        try {
            document = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines").maxBodySize(0).get();

            Map<String, List<Line>> jsonMap = new HashMap<>();

            lineList = new ArrayList<>();
            stationsList = new ArrayList<>();
            connectionsList = new ArrayList<>();

            Elements elementsLine = document.select("span[class~=js-metro-line]");
            for (Element elementLine : elementsLine){
                String nameLine = elementLine.text();
                String numberLine = elementLine.attr("data-line");

                Line currentLine = new Line(numberLine, nameLine);

                currentLine.stations.add(getLineStationWithConnection(document, numberLine));
                lineList.add(currentLine);
//                stationsList.add(currentLine.stations);
//                connectionsList.add();

            }

            System.out.println(lineList.get(0).number + " " + lineList.get(0).name + " "
                    + lineList.get(0).stations.get(0).get(0).number + " " +
                    lineList.get(0).stations.get(0).get(0).name + " " +
                    lineList.get(0).stations.get(0).get(0).connections.get(0).numberLine + " " +
                    lineList.get(0).stations.get(0).get(0).connections.get(0).nameStation);
            jsonMap.put("Lines", lineList);
//            jsonMap.put("Stations", stationsList);
//            jsonMap.put("Connections", connectionsList);

            createJsonFile(jsonMap);
        }catch (Exception ex){
            ex.getStackTrace();
        }
    }

    private static List<Station> getLineStationWithConnection(Document parent, String lineNumber){
        List<Station> stationsList = new ArrayList<>();
        try {
            Elements elementsStaions =
                    parent.select("div[class~=js-metro-stations][data-line='" + lineNumber + "']");
            for (Element elementStation : elementsStaions) {
                Elements paragrafs = elementStation.select("p");
                for (Element p : paragrafs){
                    String numData = p.select("span[class=num]").text();
                    String stationNumber = numData.substring(0, numData.length() - 1);
                    String stationName = p.select("span[class=name]").text();

                    Station station = new Station(stationNumber, stationName);

                    Elements connectionsElements = p.select("span[class~=t-icon-metroln]");
                    for (Element connectionElement : connectionsElements) {
                        String lineSpan = connectionElement.toString();
                        String lineNum = lineSpan.replaceAll("[^0-9]", "");
                        String nameStation = lineSpan.substring(lineSpan.indexOf("«") + 1, lineSpan.lastIndexOf("»"));
                        Station.ConnectionStation connectionStation = new Station.ConnectionStation(lineNum, nameStation);
                        if (!connectionStation.numberLine.equals("") && !connectionStation.nameStation.equals("")){
                            station.connections.add(connectionStation);
                        }
                    }
                    stationsList.add(station);
                }
            }
        } catch (NullPointerException nullPointerException) {
            nullPointerException.getStackTrace();
        }
        return stationsList;
    }

    private static void createJsonFile(Map<String, List<Line>> jsonMap){
        try(FileWriter fileWriter = new FileWriter("Data\\map.json")) {
            fileWriter.write(GSON.toJson(jsonMap));

        }catch (IOException ioException){
            ioException.getStackTrace();
        }
    }
}
