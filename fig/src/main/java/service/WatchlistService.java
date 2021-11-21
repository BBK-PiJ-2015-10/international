package service;

import dto.WatchList;
import lombok.val;
import reactor.core.publisher.Mono;
import repo.WatchlistRepo;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
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

    public Mono<WatchList> saveReactive(WatchList watchList) {
        val publisherWatchList = watchlistRepo.getWatchLisReactive();

        // This downgrade the preference ranking of all with preff >= watchList
        publisherWatchList
                .filter(item -> item.preference >= watchList.preference)
                .map(item -> incrementPreference(item))
                .map(item -> watchlistRepo.saveReactive(item)).subscribe();

        val watchListToStore = publisherWatchList
                .filter(item -> item.preference < watchList.preference)
                .collect(Collectors.toList())
                .block()
                .stream()
                .max(Comparator.comparing(item -> item.preference))
                .map(priorItem -> {
                    if (priorItem.preference+1!=watchList.preference){
                        watchList.setPreference(priorItem.preference+1);
                    }
                    return watchList;
                }).orElse(watchList);

        return watchlistRepo.saveReactive(watchListToStore);
    }

    public Mono<WatchList> saveReactiveUsingGroupFlux(WatchList watchList) {
        watchlistRepo
                .getWatchLisReactive()
                .groupBy(item -> item.preference >= watchList.preference)
                .toStream()
                .forEach(groupedFlux -> {
                    if (groupedFlux.key() == true) {
                        groupedFlux.toStream()
                                .map(item -> incrementPreference(item))
                                .map(item -> watchlistRepo.save(item));
                    } else {
                        groupedFlux.toStream()
                                .max(Comparator.comparing(item -> item.preference))
                                .map(priorItem -> {
                                    if (priorItem.preference+1!= watchList.preference) {
                                        watchList.setPreference(priorItem.preference + 1);
                                    }
                                    return watchList;
                                });
                    }
                });
        return saveReactive(watchList);
    }

    public Mono<WatchList> saveReactiveUsingSubscribers(WatchList watchList) {

        //TODO: Fix this flow
        val databaseWatchLists = watchlistRepo.getWatchLisReactive().publish();

        databaseWatchLists
                .filter(item -> item.preference >= watchList.preference)
                .map(item -> incrementPreference(item))
                .map(item -> watchlistRepo.save(item))
                .subscribe();

        Consumer<List<WatchList>> adjustWatchListPreference = items -> items
                .stream()
                .max(Comparator.comparing(item -> item.getPreference()))
                .map(priorItem -> {
                    if (priorItem.preference + 1 != watchList.preference) {
                        watchList.setPreference(priorItem.preference + 1);
                    }
                    return watchList;
                });

        databaseWatchLists
                .filter(item -> item.preference < watchList.preference)
                .collect(Collectors.toList())
                .subscribe(morePreferredItems -> adjustWatchListPreference.accept(morePreferredItems));

        return saveReactive(watchList);
    }

    private void helper(List<WatchList> watchListItem){
        watchListItem.stream();
    }





    private WatchList incrementPreference(WatchList watchList){
        watchList.setPreference(watchList.preference+1);
        return watchList;
    }

}
