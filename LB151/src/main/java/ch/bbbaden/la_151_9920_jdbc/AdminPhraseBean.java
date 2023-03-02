/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ch.bbbaden.la_151_9920_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author kevin
 */
@Named(value = "adminPhraseBean")
@Dependent
public class AdminPhraseBean {

    /**
     * Creates a new instance of AdminPhraseBean
     */
    public AdminPhraseBean() {
    }
    
    private int selectedCategoryId;
    private String newPhrase;
    String url = "jdbc:mysql://localhost:3306/wordgame";
    String username = "Kevin";
    String password = "Kevinmatias";
    
    private int kategorieId = 4;
    private String phrase = "";
    
    public int getSelectedCategoryId() {
        return selectedCategoryId;
    }

    public void setSelectedCategoryId(int selectedCategoryId) {
        this.selectedCategoryId = selectedCategoryId;
    }

    // Getter and setter for newPhrase
    public String getNewPhrase() {
        return newPhrase;
    }

    public void setNewPhrase(String newPhrase) {
        this.newPhrase = newPhrase;
    }
    
    public int getKategorieId() {
    return kategorieId;
}

public void setKategorieId(int kategorieId) {
    this.kategorieId = kategorieId;
}

public String getPhrase() {
    return phrase;
}

public void setPhrase(String phrase) {
    this.phrase = phrase;
}

    // Getter for categoryList
    public List<Kategorie> getCategoryList() throws SQLException {
        Connection con = this.getConnection();

        if (con == null) {
            throw new SQLException("Can't get database connection");
        }

        PreparedStatement ps = con.prepareStatement("SELECT id, name FROM kategorie");
        ResultSet result = ps.executeQuery();

        List<Kategorie> list = new ArrayList<>();

        while (result.next()) {
            Kategorie kategorie = new Kategorie(
                    result.getInt("id"),
                    result.getString("name")
            );

            list.add(kategorie);
        }

        return list;
    }

    private Connection getConnection() {

    Connection connect = null;
    try {
        //Class.forName("com.mysql.jdbc.Driver");
        connect = DriverManager.getConnection(url, username, password);
    } catch (SQLException ex) {
        Logger.getLogger(AdminPhraseBean.class.getName()).log(Level.SEVERE, null, ex);
    }
    return connect;
}


    //connect to DB and get phrase list
    public List<AdminPhrase> getPhraseList() throws SQLException {
        Connection con = this.getConnection();

        if (con == null) {
            throw new SQLException("Can't get database connection");
        }

        PreparedStatement ps = con.prepareStatement("SELECT phrase.id, kategorie.name, phrase.phrase FROM phrase JOIN kategorie ON phrase.kategorie_id = kategorie.id");
        ResultSet result = ps.executeQuery();

        List<AdminPhrase> list = new ArrayList<>();

        while (result.next()) {
            AdminPhrase adminPhrase = new AdminPhrase(
                    result.getInt("id"),
                    result.getString("name"),
                    result.getString("phrase")
            );

            list.add(adminPhrase);
        }

        return list;
    }

   public void addPhrase() throws SQLException {
    Connection conn = DriverManager.getConnection(url, username, password);
    PreparedStatement stmt = conn.prepareStatement("INSERT INTO phrase (kategorie_id, phrase) VALUES (?, ?)");
    stmt.setInt(1, kategorieId);
    stmt.setString(2, phrase);
    stmt.executeUpdate();
    stmt.close();
    conn.close();
}



    public void deletePhraseEntry(long id) throws SQLException {
        Connection con = this.getConnection();
        if (con == null) {
            throw new SQLException("Can't get database connection");
        }
        PreparedStatement ps = con.prepareStatement("DELETE FROM phrase WHERE id = ?");
        ps.setLong(1, id);
        ps.executeUpdate();
    }
    
    

}
