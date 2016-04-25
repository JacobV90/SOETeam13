package source;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import servlet.EmailVerified;

/**
 * The DBManager class provides methods to push, update and retrieve information from
 * the database. The "initializeConnection" method needs to be called first before calling
 * any other class methods. After database manipulation is finished, call the "closeConnection" method
 * to close the connection.
 *
 * @author jacobveal
 */
public class DBManager {

    // JDBC driver name and database URL
    /**
     * The location of the JDBC driver
     */
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    
    /**
     * The location of the database and a schema
     */
    private static final String DB_URL = "jdbc:mysql://localhost:3306/justintime";

    /**
     * The username for the database credentials
     */
    private static final String USER = "root";
    
    /**
     * The password for the database credentials
     */
    private static final String PASS = "Hondas2k";

    /**
     * The reference to the database connection object
     */
    private static Connection conn = null;
    
    /**
     * The 
     */
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
            for (int j = 0; j < rowLength; ++j) {
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
     * Counts the number of rows the specified database table possesses.
     * 
     * @param table - name of the database table
     * @return - number of row entries
     */
    public static int getRowCount(String table) {

        // SQL query script
        final String selectRows = "select * from " + table;
        int count = 0;

        try {
            //Prepare statement
            stmt = conn.prepareStatement(selectRows);
            ResultSet rs = stmt.executeQuery();

            count = 0;
            while (rs.next()) {
                ++count;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    /**
     * THe selectEntry method selects and returns an ArrayList containing the
     * specified rows values.
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

    public static String selectEntryValue(String table, String keyName, String key, String field) {

        // SQL query script
        final String selectRow = "select * from " + table + " where " + keyName + " = ?;";

        try {

            //Prepare statement
            stmt = conn.prepareStatement(selectRow);
            stmt.setString(1, key);

            // Pull entry from database
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String colValue = rs.getString(field);

                System.out.println("Record succesfully retrieved");
                return colValue; //return user 

            } else {
                return null;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class
                    .getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public static HashMap searchTable(String table, List colArr, String keyword) {

        String sql = "select * from " + table + " where ";
        StringBuilder sb = new StringBuilder(sql);
        for (int i = 0; i < colArr.size(); ++i) {
            if (i == 0) {
                sb.append(colArr.get(i) + " like '%" + keyword + "%'");
            } else {

                sb.append(" or " + colArr.get(i) + " like '%" + keyword + "%'");
            }

        }

        try {

            stmt = conn.prepareStatement(sb.toString());
            ResultSet rs = stmt.executeQuery();

            ResultSetMetaData rsd = rs.getMetaData();
            int rowLength = rsd.getColumnCount();

            System.out.println("Search Query Executed");
            System.out.println(sb.toString());
            System.out.println("row length: " + rowLength);

            HashMap<Integer, ArrayList<String>> productMap = new HashMap<>();

            int i = 0;
            while (rs.next()) {
                System.out.println("Results found");
                ArrayList<String> productArr = new ArrayList<>();

                for (int j = 1; j <= rowLength; ++j) {
                    productArr.add(rs.getString(j));
                }
                productMap.put(i, productArr);
                ++i;
            }
            System.out.println("Map size: " + productMap.size());

            return productMap;

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    /**
     * Deletes an entire row entry from the specified table based on the primary key value that is
     * passed in. 
     * 
     * @param table - database table to access
     * @param key - the name of the primary key column
     * @param col - the value of the primary key
     * @return - true or false
     */
    public static boolean deleteEntry(String table, String key, String col) {

        String sql = "DELETE FROM " + table + " WHERE " + col + " = ?";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, key);
            
            // Remove entry
            if (stmt.execute()) {
                System.out.println("Entry deleted from table " + table);
                return true;
            } else {
                System.out.println("Entry was removed from table " + table);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    /**
     * The updateEntry method changes the value in the specified column name,
     * primary key value, and table.
     *
     * @param table - table to access
     * @param keyCol - name of the primary key column
     * @param key - value of the primary key column
     * @param colName - column name to change value in
     * @param value - value to be inserted
     * @return - true if update statement is executed successfully. false if
     * not.
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
     * The initialize connection method establishes a connection between the
     * JDBC driver and the MySQL database.
     *
     * @return - true if the DriverManager.getConnection does not throw and SQL
     * exception. false if it does.
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
     * The closeConnection method closes the database's statement and connection
     * objects.
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
