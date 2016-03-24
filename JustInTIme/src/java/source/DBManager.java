package source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import servlet.EmailVerified;

/**
 * The DBManager class provides methods to push and retrieve information from the database.
 * initializeConnection needs to be called first before calling any other classes. After database 
 * accessing call the closeConnection method to close the connection.
 * 
 * @author jacobveal
 */
public class DBManager {

    // JDBC driver name and database URL
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/justintime";

    //  Database credentials
    private static final String USER = "root";
    private static final String PASS = "Hondas2k";

    // Connection variables
    private static Connection conn = null;
    private static PreparedStatement stmt = null;
    
    /**
     * The insertEntry method inserts a new row into the specified table
     * 
     * @param table - table to access
     * @param entryData - arrayList containing the entry's values
     * @return - true if entry statement is successfully executed. false if not.
     */
    public static boolean insertEntry(String table, ArrayList<String> entryData) {

        //SQL query to determine size of row
        final String selectRow = "select * from " + table + " limit 1;";

        // SQL query to insert a row
        StringBuilder insertRow = new StringBuilder("insert into " + table + " values (");

        try {
            //Prepare statement
            stmt = conn.prepareStatement(selectRow);

            //Determine size of row
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData rsd = rs.getMetaData();
            int rowLength = rsd.getColumnCount();

            //Build insert row SQL query
            for (int i = 0; i < rowLength; ++i) {

                if (i != 0) {
                    insertRow.append(",?");
                } else {
                    insertRow.append("?");
                }
            }
            insertRow.append(");");

            //prepare insert statement execution
            stmt = conn.prepareStatement(insertRow.toString());

            //add data to sql parameters
            for (int j = 0; j < 11; ++j) {
                stmt.setString(j + 1, entryData.get(j));
            }

            //push entry to database
            stmt.executeUpdate();

            System.out.println("Entry pushed to data base");

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    /**
     * THe selectEntry method selects and returns an ArrayList containing the specified rows values.
     * 
     * @param table - table to access
     * @param fieldName - primary key column name
     * @param value - value to match primary key value
     * @return - ArrayList containing the row values
     */
    public static ArrayList<String> selectEntry(String table, String fieldName, String value) {

        // SQL query script
        final String selectRow = "select * from " + table + " where " + fieldName + " = ?;";

        try {

            //Prepare statement
            stmt = conn.prepareStatement(selectRow);
            stmt.setString(1, value);

            // Pull entry from database
            ResultSet rs = stmt.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            int length = rsd.getColumnCount();

            if (rs.next()) {
                ArrayList<String> userArr = new ArrayList<>();

                for (int j = 1; j <= length; ++j) {
                    userArr.add(rs.getString(j));
                }

                System.out.println("Record succesfully retrieved");
                return userArr; //return user 

            } else {
                return null;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class
                    .getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    /**
     * The updateEntry method changes the value in the specified column name, primary key value, and 
     * table.
     * 
     * @param table - table to access
     * @param keyCol - name of the primary key column
     * @param key - value of the primary key column
     * @param colName - column name to change value in 
     * @param value - value to be inserted
     * @return - true if update statement is executed successfully. false if not.
     */
    public static boolean updateEntry(String table, String keyCol, String key, String colName, String value) {

        final String updateRecord = "update " + table + " set " + colName + " = ? where " + keyCol + " = ?";

        try {

            //Prepare statement
            stmt = conn.prepareStatement(updateRecord);
            int i = 1;
            stmt.setString(i, value);
            stmt.setString(++i, key);

            // Update database entry
            stmt.executeUpdate();

            System.out.println("Update statement executed");

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class
                    .getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    /**
     * The initialize connection method establishes a connection between the JDBC driver
     * and the MySQL database.
     * 
     * @return - true if the DriverManager.getConnection does not throw and SQL exception.
     *              false if it does.
     */
    public static boolean initializeConnection() {

        boolean connection = false;

        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            connection = true;
            System.out.println("DB Connection Established");

        } catch (SQLException | ClassNotFoundException se) {

            System.out.println("Connection to database failed");
            try {

                conn.close();

            } catch (SQLException ex) {
                Logger.getLogger(EmailVerified.class
                        .getName()).log(Level.SEVERE, null, ex);
            }

        }

        return connection;
    }

    /**
     * 
     * The closeConnection method closes the database's statement and connection objects.
     * 
     */
    public static void closeConnection() {

        try {

            // close connections
            stmt.close();
            conn.close();

            System.out.println("Database connection closed");
        } catch (SQLException ex) {

        }
    }

}
