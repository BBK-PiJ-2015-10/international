package service;

import dto.WatchList;
import repo.WatchlistRepo;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WatchlistService {

    private WatchlistRepo watchlistRepo;

    public WatchlistService(WatchlistRepo watchlistRepo) {
        this.watchlistRepo = watchlistRepo;
    }

    public List<WatchList> getWatchList(){
        return watchlistRepo.getWatchList()
                .stream()
                .sorted(Comparator.comparing(a -> a.preference))
                .collect(Collectors.toList());
    }

    public WatchList save(WatchList watchList) {
        Map<Boolean, List<WatchList>> watchLists = watchlistRepo.getWatchList()
                .stream()
                .collect(Collectors.partitioningBy(item -> !(item.preference < watchList.preference)));
        watchLists.get(true).stream().map(wl ->{
                    wl.setPreference(wl.preference+1);
                    return wl;
                }).forEach(watchlistRepo::save);
        watchLists.get(false).stream().max(Comparator.comparing(a -> a.preference))
                .ifPresent(item -> {
                    if (watchList.preference - item.preference > 2) {
                        watchList.setPreference(item.preference + 1);
                    }
                });
        return watchlistRepo.save(watchList);
        //watchLists.get(true).stream().map(this::incrementPreference).forEach(watchlistRepo::save);
    }


    private WatchList incrementPreference(WatchList watchList){
        watchList.setPreference(watchList.preference+1);
        return watchList;
    }

}
