package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Access users in the user table.
 *
 * @author pwaite
 */
public class UserData {
    private final Logger logger = LogManager.getLogger(this.getClass());

    public User getUser(String userId, String password) {
        User user = new User();
        Database database = Database.getInstance();
        Connection connection = null;
        String sql = "SELECT * FROM user WHERE user_id = '" + userId + "' and password = '" + password + "'" +
                " and active = TRUE";

        try {
            database.connect();
            connection = database.getConnection();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);
            while (results.next()) {
                user = createUserFromResults(results);
            }
            database.disconnect();
        } catch (SQLException e) {
            logger.error("SearchUser.getAllUsers()...SQL Exception: ", e);
        } catch (Exception e) {
            logger.error("SearchUser.getAllUsers()...Exception: ", e);
        }
        return user;
    }

    private User createUserFromResults(ResultSet results) throws SQLException {
        User user = new User();
        user.setUserId(results.getString("user_id"));
        user.setPassword(results.getString("password"));
        user.setLastName(results.getString("last_name"));
        user.setFirstName(results.getString("first_name"));
        user.setLevel(results.getInt("level"));
        user.setActive(results.getBoolean("active"));

        return user;
    }

}