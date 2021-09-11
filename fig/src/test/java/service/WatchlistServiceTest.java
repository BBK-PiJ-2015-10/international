package service;

import dto.Movie;
import dto.User;
import dto.WatchList;
import org.junit.Assert;
import org.junit.Test;
import repo.WatchlistRepo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WatchlistServiceTest {

    private WatchlistRepo watchlistRepo= new WatchlistRepo();

    private WatchlistService watchlistService = new WatchlistService(watchlistRepo);

    @Test
    public void test1fetchAll(){

        User user = new User("1");
        Movie movie1 = new Movie("Pretty Woman");
        WatchList first = new WatchList("wl-1",user,movie1,2);

        Movie movie2 = new Movie("Top Gun");
        WatchList second = new WatchList("wl-2",user,movie2,1);

        Movie movie3 = new Movie("Star Wars");
        WatchList third = new WatchList("wl-3",user,movie3,3);

        List<WatchList> storedMovies = Stream.of(first,second,third).collect(Collectors.toList());
        watchlistRepo.setStoredWatchList(storedMovies);

        List<WatchList> watchList = watchlistService.getWatchList();

        Assert.assertEquals(3,watchList.size());
        Assert.assertEquals("Top Gun",watchList.get(0).movie.name);
        Assert.assertEquals("Pretty Woman",watchList.get(1).movie.name);
        Assert.assertEquals("Star Wars",watchList.get(2).movie.name);

    }

    @Test
    public void test1fetchAllEmpty(){

        List<WatchList> storedMovies = new ArrayList<>();
        watchlistRepo.setStoredWatchList(storedMovies);

        List<WatchList> watchList = watchlistService.getWatchList();

        Assert.assertEquals(true,watchList.isEmpty());

    }

}
