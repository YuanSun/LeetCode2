package leetcode.reconstructItinerary;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class FindItinerary {
    public HashMap<String, PriorityQueue<String>> map = new HashMap<>();
    public LinkedList<String> result = new LinkedList<>();
    public final String departure = "JFK";
    
    public FindItinerary(String[][] tickets) {
        // put all tickets to the map. "From" as the key, "To"s are put in the corresponding Queue
        for (String[] ticket: tickets) {
            if(!map.containsKey(ticket[0])) {
                PriorityQueue<String> q = new PriorityQueue<>(); //new Queue for new from
                map.put(ticket[0], q);  // Put it into the map
            }// end if
            map.get(ticket[0]).offer(ticket[1]); // for the case of duplicate "From"
        } // end for loop
    }
    
    public List<String> findItineary(){
        dfs(departure);
        
        return result;
    }

    private void dfs(String departure) {
        PriorityQueue<String> q = map.get(departure); // find the "From"
        
        while(q != null && !q.isEmpty()) {
            dfs(q.poll());
        }
        
        // add the path to the linked list
        result.addFirst(departure);
    }
}
