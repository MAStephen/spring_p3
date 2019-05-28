package p3.consumerMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import p3.model.user.User;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UserMapper implements RowMapper<User> {

    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();

        user.setAddress(rs.getString("address"));
        user.setEmail(rs.getString("email"));
        user.setFirstName(rs.getString("firstName"));
        user.setLastName(rs.getString("lastName"));
        user.setPassword(rs.getString("password"));
        user.setUsername(rs.getString("username"));
        user.setId(rs.getInt("id"));

        return user;
    }
}
