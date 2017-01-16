package leetcode.reconstructItinerary;

import java.util.LinkedList;
import java.util.List;

public class FindItineraryMain {
    public static void main(String[] args) {
        String[][] tickets = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, 
                                {"LHR", "SFO"}};
        
        FindItinerary findItinerary = new FindItinerary(tickets);
        List<String> itinerary = findItinerary.findItineary();
        System.out.println("Itinerary is " + itinerary);
        
        
        String[][] newTickets = {{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, 
                    {"ATL", "JFK"}, {"ATL", "SFO"}};
        FindItinerary findAnotherItinerary = new FindItinerary(newTickets);
        List<String> newItinerary = findAnotherItinerary.findItineary();
        System.out.println("New itinerary is " + newItinerary);
    }
    
}
