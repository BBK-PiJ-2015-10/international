package dto;

public class WatchList {

    public String id;

    public User user;

    public Movie movie;

    public Integer preference;

    public void setPreference(Integer preference) {
        this.preference = preference;
    }


    public Integer getPreference() {
        return preference;
    }

    public WatchList(String id, User user, Movie movie, Integer preference) {
        this.id = id;
        this.user = user;
        this.movie = movie;
        this.preference = preference;
    }

    @Override
    public String toString() {
        return "WatchList{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", movie=" + movie +
                ", preference=" + preference +
                '}';
    }
}
