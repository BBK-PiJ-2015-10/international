package repo;

import dto.WatchList;

import java.util.ArrayList;
import java.util.List;

public class WatchlistRepo {

    public List<WatchList> storedWatchList = new ArrayList<>();

    public void setStoredWatchList(List<WatchList> newWatchList) {
        storedWatchList = newWatchList;
    }

    public WatchList save(WatchList newWatchList){
        storedWatchList.add(newWatchList);
        return newWatchList;
    }

    public List<WatchList> getWatchList(){
        return storedWatchList;
    }



}
