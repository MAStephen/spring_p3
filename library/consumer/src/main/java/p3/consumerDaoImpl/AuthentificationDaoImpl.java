package p3.consumerDaoImpl;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import p3.consumerDao.AuthentificationDao;
import p3.consumerMapper.UserMapper;
import p3.model.user.User;


@Component
public class AuthentificationDaoImpl implements AuthentificationDao {
    DataSource dataSource;
    JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
//    AuthentificationDaoImpl() {
//        super();
//    }


    public User authentification(String username) throws DataAccessException {
        String SQL = "SELECT * FROM user WHERE username =?";
        // SQL => requete SQL demandé a la BDD
        // new Object[]{username} => argument de la requete
        // new UserMapper() => le type attendu en retour

        User userToReturn;
        try {
            userToReturn = jdbcTemplateObject.queryForObject(SQL, new Object[]{username}, new UserMapper());
            return userToReturn;
        } catch (DataAccessException e) {
            System.out.println("dao2");

            return null;
        }
    }
}

