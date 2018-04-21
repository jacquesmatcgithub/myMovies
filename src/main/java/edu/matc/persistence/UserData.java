package edu.matc.persistence;

import edu.matc.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
        String sql = "SELECT * FROM user WHERE login_id = '" + userId + "' and user_password = '" + password + "'" +
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
        user.setLoginId(results.getString("login_id"));
        user.setUserPassword(results.getString("password"));
        user.setLastName(results.getString("last_name"));
        user.setFirstName(results.getString("first_name"));
        user.setAdmin(results.getBoolean("admin"));
        user.setActive(results.getBoolean("active"));
        user.setDateActive(results.getDate("date_active").toLocalDate());

        return user;
    }

}