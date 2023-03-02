/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.bbbaden.la_151_9920_jdbc;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author A
 */
@Named(value = "adminBean")
@RequestScoped
public class AdminBean {

    /**
     * Creates a new instance of CustomerBean
     */
    public AdminBean() {
    }

    private Connection getConnection() {

        Connection connect = null;
        String url = "jdbc:mysql://localhost:3306/wordgame";
        String username = "Kevin";
        String password = "Kevinmatias";
        try {
          //Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection(url, username, password);
         } catch (SQLException ex) {
          Logger.getLogger(AdminBean.class.getName()).log(Level.SEVERE, null, ex);
         }
        return connect;
    }


    //connect to DB and get customer list
    //connect to DB and get highscore list
public List<Phrase> getHighscoreList() throws SQLException {

    //get database connection
    Connection con = this.getConnection();

    if (con == null) {
        throw new SQLException("Can't get database connection");
    }

    PreparedStatement ps = con.prepareStatement("SELECT id, spielername, betrag, spielrunden, datum FROM highscore ORDER BY betrag DESC");

    //get highscore data from database
    ResultSet result = ps.executeQuery();

    List<Phrase> list = new ArrayList<>();

    while (result.next()) {
        Phrase highscore = new Phrase();

        highscore.setId(result.getLong("id"));
        highscore.setSpielername(result.getString("spielername"));
        highscore.setBetrag(result.getBigDecimal("betrag"));
        highscore.setSpielrunden(result.getInt("spielrunden"));
        highscore.setDatum(result.getDate("datum"));

        //store all data into a List
        list.add(highscore);
    }

    return list;
}

    
    // delete a highscore entry by id
    public void deleteHighscoreEntry(long id) throws SQLException {
        Connection con = this.getConnection();
        if (con == null) {
            throw new SQLException("Can't get database connection");
        }
        PreparedStatement ps = con.prepareStatement("DELETE FROM highscore WHERE id = ?");
        ps.setLong(1, id);
        ps.executeUpdate();
    }
  
}
