package repo;

import dto.WatchList;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

    public Mono<WatchList> saveReactive(WatchList newWatchList){
        return Mono.just(this.save(newWatchList));
    }

    public List<WatchList> getWatchList(){
        return storedWatchList;
    }

    public Flux<WatchList> getWatchLisReactive(){
        return Flux.fromIterable(this.getWatchList());
    }





}
