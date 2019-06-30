package heat.db;

import heat.utils.ResourceExtractor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.*;

public class DBHelper {

    @Autowired
    private static DataSource dataSource;

    public static void createUser(User user) {
        try {
            final String INSERT_USER = ResourceExtractor.getSql(ResourceExtractor.SQL_INSERT_USER);
            Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT_USER);

            ps.setString(1, user.getPassword());
            ps.setInt(2, user.getGender().index());
            ps.setDate(3, new Date(user.getBirthDate().getTime()));
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            user.setUserId(rs.getInt("user_id"));
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createUserParameters(UserParameters userParameters, int userId) {
        try {
            final String INSERT_PARAMETERS = ResourceExtractor.getSql(ResourceExtractor.SQL_INSERT_PARAMETERS);
            Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(INSERT_PARAMETERS);

            ps.setInt(1, userId);
            ps.setDouble(2, userParameters.getWeight());
            ps.setDouble(3, userParameters.getHeight());
            ps.setInt(4, userParameters.getPhysicalActivity());
            ps.setDouble(5, userParameters.getTargetWeight());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
