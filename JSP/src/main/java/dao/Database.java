package dao;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by azburatura on 7/28/2016.
 */
public class Database {

    // JDBC driver name and database URL
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost/users";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "1234";

    public static void addUser(String nume, String parola, int varsta) {
        Connection conn = null;
        PreparedStatement pt = null;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to the database");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to the database :)");

            String sql = "INSERT INTO User VALUES (null, ?, ?, ?)";
            pt = conn.prepareStatement(sql);
            pt.setString(1, nume);
            pt.setString(2, parola);
            pt.setInt(3, varsta);
            pt.executeUpdate();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pt != null) {
                try {
                    pt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static List<User> getUsers() {
        List<User> users = new ArrayList<User>();
        Connection conn = null;
        Statement st = null;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to the database");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to the database :)");
            st = conn.createStatement();

            String sql = "SELECT * FROM user";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nume = rs.getString("nume");
                String parola = rs.getString("parola");
                int varsta = rs.getInt("varsta");
                User user = new User(id, nume, parola, varsta);
                users.add(user);
                System.out.println("id = " + id + ", nume = " + nume + ", parola = " + parola + ", varsta = " + varsta);
            }
            rs.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return users;
    }

    public static User getUser(int id) {
        User user = new User();
        Connection conn = null;
        PreparedStatement pt = null;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to the database");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to the database :)");

            String sql = "SELECT * FROM user WHERE id = ?";
            pt = conn.prepareStatement(sql);
            pt.setInt(1, id);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setNume(rs.getString("nume"));
                user.setParola(rs.getString("parola"));
                user.setVarsta(rs.getInt("varsta"));
            }
            rs.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pt != null) {
                try {
                    pt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return user;
    }

    public static boolean updateUser(int id, String nume, String parola, int varsta) {
        Connection conn = null;
        PreparedStatement pt = null;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to the database");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to the database :)");

            String sql = "UPDATE User set nume = ?, parola = ?, varsta = ? WHERE id = ?";
            pt = conn.prepareStatement(sql);
            pt.setString(1, nume);
            pt.setString(2, parola);
            pt.setInt(3, varsta);
            pt.setInt(4, id);
            pt.executeUpdate();
            return true;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pt != null) {
                try {
                    pt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean deleteUser(int id) {
        Connection conn = null;
        PreparedStatement pt = null;
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to the database");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to the database :)");

            String sql = "DELETE FROM User WHERE id = ?";
            pt = conn.prepareStatement(sql);
            pt.setInt(1, id);
            pt.executeUpdate();
            return true;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pt != null) {
                try {
                    pt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
