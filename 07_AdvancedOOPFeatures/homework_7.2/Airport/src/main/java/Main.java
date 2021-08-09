import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        System.out.println(findPlanesLeavingInTheNextTwoHours(Airport.getInstance()));
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
        LocalDateTime nowData = LocalDateTime.now();
        LocalDateTime twoHoursLater = nowData.plusHours(2);

        return airport.getTerminals().stream()
                .map(Terminal::getFlights)
                .flatMap(Collection::stream)
                .filter(flight -> {
                    LocalDateTime dataDeparture = toLocalDateTime(flight.getDate());
                    return flight.getType().equals(Flight.Type.DEPARTURE) && dataDeparture.isAfter(nowData)
                            && dataDeparture.isBefore(twoHoursLater);
                }).collect(Collectors.toList());
    }
    private static LocalDateTime toLocalDateTime(Date dateToConvert){
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}