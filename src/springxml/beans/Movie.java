package springxml.beans;

import springxml.services.ConsoleLogService;
import springxml.services.FileLogService;
import springxml.services.LogService;

import java.util.List;

public class Movie {
    private int id;
    private String mName;
    private String overview;
    private int crewId;

    private List<Genre> genreList;

    private LogService ls;

    public Movie(LogService ls) {
        this.ls = ls;
    }

    public String logChange(){
        return ls.getLogMessage("The database was changed");
    }

    public Movie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getCrewId() {
        return crewId;
    }

    public void setCrewId(int crewId) {
        this.crewId = crewId;
    }

    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }

    public void setLs(LogService ls) {
        this.ls = ls;
    }

}
