package com.example.mp3android.artists;

import com.example.mp3android.Item;
import com.example.mp3android.R;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemList {
    private String url = "jdbc:mysql://127.0.0.1:3306/mp3android";
    private String user = "ben";
    private String password = "example-password";

    List<Item> it = new ArrayList<>();

public List<Item> itemList() {

    try{
        Connection connection = DriverManager.getConnection(url,user,password);
        Statement statement = connection.createStatement();

        String query = "Select * from artistList";

        statement.executeQuery(query);

        ResultSet resultSet = statement.getResultSet();

        while(resultSet.next()){
            it.add(new Item(R.drawable.blacksmith,resultSet.getString("artistName")));
        }

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }

//        it.add(new Item(R.drawable.blacksmith,"Shomw"));
//        it.add(new Item(R.drawable.blacksmith,"Carmine"));
        return it;
    }
}
