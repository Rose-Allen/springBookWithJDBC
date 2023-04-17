package ru.dimash.spring.dao;


import org.springframework.stereotype.Component;
import ru.dimash.spring.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private List<Person> people;
    private static int PERSON_COUNT;
    private static final String URL = "jdbc:postgresql://localhost:5432/project1";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "2000";


    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public List<Person> index(){
        List<Person> people = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Person";
            ResultSet resultSet = statement.executeQuery(SQL);
            while(resultSet.next()) {
                Person person = new Person();

                person.setId(resultSet.getInt("id"));
                person.setFullname(resultSet.getString("fullname"));
                person.setBirthday(resultSet.getInt("birthday"));
                people.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  people;
    }

    public Person show(int id){
        return null;

    }

    public void save(Person person){
        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO Person VALUES(" + person.getId() + ",'" + person.getFullname() +
                    "'," + person.getBirthday() + ")";
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(int id, Person updatePerson){

//        Person personToBeUpdated = show(id);
//        personToBeUpdated.setFullname(updatePerson.getFullname());
//        personToBeUpdated.setBirthday(updatePerson.getBirthday());

    }

    public void delete(int id){

    }
}
