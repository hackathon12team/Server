package heat.db;

import heat.config.DatabaseConfig;
import heat.utils.ResourceExtractor;

import java.sql.*;

public class DBHelper {

    private static void cleanUp(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Failed to close connection: " + e);
            }
        }
    }

    private static void cleanUp(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                System.out.println("Failed to close prepared statement: " + e);
            }
        }
    }

    private static void cleanUp(Connection connection, PreparedStatement ps) {
        cleanUp(connection);
        cleanUp(ps);
    }

    private static void cleanUp(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("Failed to close result set: " + e);
            }
        }
    }

    private static void cleanUp(Connection connection, PreparedStatement ps, ResultSet rs) {
        cleanUp(rs);
        cleanUp(connection, ps);
    }

    public static void createUser(User user) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            final String INSERT_USER = ResourceExtractor.getSql(ResourceExtractor.SQL_INSERT_USER);
            connection = DatabaseConfig.getDataSource().getConnection();
            ps = connection.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, user.getPassword());
            ps.setInt(2, user.getGender().index());
            ps.setDate(3, new Date(user.getBirthDate()));
            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                user.setUserId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cleanUp(connection, ps, rs);
        }
    }

    public static void createUserParameters(UserParameters userParameters, int userId) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            final String INSERT_PARAMETERS = ResourceExtractor.getSql(ResourceExtractor.SQL_INSERT_PARAMETERS);
            connection = DatabaseConfig.getDataSource().getConnection();
            ps = connection.prepareStatement(INSERT_PARAMETERS);

            ps.setInt(1, userId);
            ps.setDouble(2, userParameters.getWeight());
            ps.setDouble(3, userParameters.getHeight());
            ps.setDouble(4, userParameters.getPhysicalActivity());
            ps.setDouble(5, userParameters.getTargetWeight());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cleanUp(connection, ps);
        }
    }
}
