package sg.edu.rp.c346.showtracker;

import java.io.Serializable;

public class Show implements Serializable {
    private Integer id;
    private String name;
    private String date;
    private String genre;
    private String language;

    public Show(Integer id, String name, String date, String genre, String language) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.genre = genre;
        this.language = language;
    }

    public Integer getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getGenre() {
        return genre;
    }

    public String getLanguage() {
        return language;
    }


    @Override
    public String toString() {
        return "ID:" + id + ", " + "Name: " + name + ", " + "Date: " + date + ", " + "Genre: " + genre + ", " + "Language: " + language;
    }
}
