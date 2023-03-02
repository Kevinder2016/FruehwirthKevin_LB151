package ch.bbbaden.la_151_9920_jdbc;

public class AdminPhrase {

    private int id;
    private String name;
    private String phrase;

    public AdminPhrase(int id, String name, String phrase) {
        this.id = id;
        this.name = name;
        this.phrase = phrase;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

}
