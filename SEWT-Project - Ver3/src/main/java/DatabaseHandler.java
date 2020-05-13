import java.awt.event.ActionListener;
import java.sql.*;
/*
* Cian Joyce
* 11/5/2020
* A class made to handle the querying and connection to a SQL database. Includes methods to find, delete, retrieve
* and insert users account information to/from the database based on inputs from the GUI
*/

public class DatabaseHandler
{
    /*
        NOTE If you're running the application for the first time, you must go to
        project structure -> libraries and give the path to the Java database connector
        folder that is included in the git repository. There is also a file containing
        SQL code that you will need to create the tables in your database.
    */
    final String driverPath = "com.mysql.cj.jdbc.Driver";
    //Change dataBaseURL to match what you named the database on your machine
    final String dataBaseURL = "jdbc:mysql://localhost:3306/userdatabase";
    //Change the User and password below to match that of your SQL database
    final String databaseUser = "root";
    final String databasePassword = "root";


    // reference to database connection
    private Connection connection;

    private PreparedStatement sqlFindUser;
    //insert statements
    private PreparedStatement sqlInsertName;
    private PreparedStatement sqlInsertPassword;
    private PreparedStatement sqlInsertAddress;
    private PreparedStatement sqlInsertNumber;
    //delete statements
    private PreparedStatement sqlDeleteName;
    private PreparedStatement sqlDeletePassword;
    private PreparedStatement sqlDeleteAddress;
    private PreparedStatement sqlDeleteNumber;
    //find statements
    private PreparedStatement sqlFindName;
    private PreparedStatement sqlFindPassword;
    private PreparedStatement sqlFindAddress;
    private PreparedStatement sqlFindNumber;
    private PreparedStatement sqlFindUserID;


    public DatabaseHandler() throws Exception
    {
        databaseConnect();

        sqlInsertName = connection.prepareStatement("INSERT INTO usernames ( firstName, lastName ) " +
                "VALUES ( ? , ? )");

        sqlInsertAddress = connection.prepareStatement("INSERT INTO useraddresses ( userID, address1, " +
                "address2, city ) " + "VALUES ( ? , ? , ? )");

        sqlInsertPassword = connection.prepareStatement("INSERT INTO userpasswords ( userID, password ) " +
                "VALUES( ? , ? )");

        sqlInsertNumber = connection.prepareStatement("INSERT INTO usernumbers ( userID, number ) " +
                "VALUES( ? , ? )");

        sqlDeleteName = connection.prepareStatement("DELETE FROM usernames WHERE userID = ?");

        sqlDeleteAddress = connection.prepareStatement("DELETE FROM useraddresses WHERE userID = ?");

        sqlDeletePassword = connection.prepareStatement("DELETE FROM userpasswords WHERE userID = ?");

        sqlDeleteNumber = connection.prepareStatement("DELETE FROM usernumbers WHERE userID = ?");

        sqlFindName = connection.prepareStatement("SELECT FROM usernames WHERE userID = ?");

        sqlFindAddress = connection.prepareStatement("SELECT FROM useraddresses WHERE userID = ?");

        sqlFindPassword = connection.prepareStatement("SELECT FROM userpasswords WHERE userID = ?");

        sqlFindNumber = connection.prepareStatement("SELECT FROM usernumbers WHERE userID = ?");

        sqlFindUser = connection.prepareStatement(
                "SELECT usernames.userID, firstName, lastName, addressID, address1, address2, city," +
                        " eircode, numberID, number, passwordID, password FROM usernames," +
                        " useraddresses, usernumbers, userpasswords WHERE firstName = ? AND lastName = ? AND password = ? " +
                        "AND usernames.userID = useraddresses.userID AND usernames.userID = userumbers.userID" +
                        "AND usernames.userID = userpassword.userID" );

        sqlFindUserID = connection.prepareStatement( "SELECT usernames.userID FROM usernames " +
                "WHERE firstName = ? AND lastName = ?" );

    }   //constructor end

    public void databaseConnect() throws Exception
    {
        // connect to database
        connection = DriverManager.getConnection( dataBaseURL, databaseUser, databasePassword );
        // Manual commit allows statement query's to be rolled back if they fail.
        connection.setAutoCommit( false );
        //load the Java database connector class from driver
        Class.forName(driverPath);
    }

    public int findUserID(String fName, String lName)
    {
        try
        {
            //prepare the statement that queries the database for the UserID associated with the passed name
            sqlFindUserID.setString(1, fName);
            sqlFindUserID.setString(2, lName);
            ResultSet results = sqlFindUserID.executeQuery();

            if(!results.next()) //if no result
            {
                System.out.println("No result finding user with name " + fName + " " + lName);
                return -1;
            }
            else
            {
                //return the ID int held in results
                return results.getInt(1);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return -1;
        }

    }   //find userID end

    public boolean createUser(User registerUserInfo)
    {
        int result;
        try
        {
            //We insert the names first, as that's when the SQL key userID is created, which the other tables depend on
            //as a foreign key.
            sqlInsertName.setString(1,registerUserInfo.getName());
            sqlInsertName.setString(2, registerUserInfo.getSurname());
            result = sqlInsertName.executeUpdate(); //executeUpdate returns 1 if successful and 0 if not

            if(result == 0) //if insert fails
            {
                connection.rollback(); // rollback insert
                return false;          // insert unsuccessful
            }
            else    //if the insert was successful
            {
                //Now we can get the userID number as we have created an instance of this user in the usernames table
                //findUserID gets the users ID by searching name, it returns the ID if successful and -1 if not
                int newUserID = findUserID(registerUserInfo.getName(), registerUserInfo.getSurname());
                if(newUserID == -1)
                {
                    connection.rollback();  //remove the users instance from the usernames table
                    System.out.println("(DatabaseHandler): User registration failed, findUserID could not get the userID!");
                    return false;
                }
                else    //if the findUserID did successfully find the users ID
                {
                    //Load the statements that depended on the dynamically generated userID
                    sqlInsertAddress.setInt(1, newUserID);
                    sqlInsertAddress.setString(2, registerUserInfo.getAddr1());
                    sqlInsertAddress.setString(3, registerUserInfo.getAddr2());
                    sqlInsertAddress.setString(4, registerUserInfo.getCity());
                    sqlInsertAddress.setString(5, registerUserInfo.getEirCode());

                    sqlInsertNumber.setInt(1,newUserID);
                    sqlInsertNumber.setString(2, registerUserInfo.getPhone());

                    sqlInsertPassword.setInt(1, newUserID);
                    sqlInsertPassword.setString(2, registerUserInfo.getPassword());
                    //After statements are fully prepared execute all 3
                    int addressInsertResult = sqlInsertAddress.executeUpdate();
                    int numberInsertResult = sqlInsertNumber.executeUpdate();
                    int passwordInsertResult = sqlInsertPassword.executeUpdate();
                    //Check if any insert failed
                    if(addressInsertResult == 0 || numberInsertResult == 0 || passwordInsertResult == 0)
                    {
                        connection.rollback();
                        System.out.println("(DatabaseHandler): User registration failed, database insert failed!");
                        return false;
                    }
                    else    //if all 4 inserts were successful
                    {
                        connection.commit();    //commit the database updates
                        return true;            //User created successfully!
                    }
                }
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }   //create user end

    public User findUser(String firstName, String lastName, String password)
    {
        try
        {
            //Set the first name, last name and password variables in the findUser statement to the arguments above
            sqlFindUser.setString(1, firstName);
            sqlFindUser.setString(2, lastName);
            sqlFindUser.setString(3, password);

            //ResultSet holds whats returned from the database depending on what statement is used
            //FindUser returns all the information on a user by searching for the users first name, last name and password
            ResultSet results = sqlFindUser.executeQuery();
            //resultSet starts at index 0, if there's no index after 0 then the search returned null
            if(!results.next())
            {
                System.out.println("That user does not exist");
                return null;
            }
            else //if the resultSet has a result
            {
                User foundUser = new User();
                //Create and set a new user object from the data returned by the database
                foundUser.setUserID(results.getInt(1));
                foundUser.setName(results.getString(2));
                foundUser.setSurname(results.getString(3));
                foundUser.setAddressID(results.getInt(4));
                foundUser.setAddr1(results.getString(5));
                foundUser.setAddr2(results.getString(6));
                foundUser.setCity(results.getString(7));
                foundUser.setEirCode(results.getString(8));
                foundUser.setNumberID(results.getInt(9));
                foundUser.setPhone(results.getString(10));
                foundUser.setPasswordID(results.getInt(11));
                foundUser.setPassword(results.getString(12));
                //Return the found user
                return foundUser;
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }   //find user end

    public void closeDb () throws SQLException {

        connection.close();

    }
    public void preparedStatements() throws SQLException {
        sqlInsertName = connection.prepareStatement("INSERT INTO usernames ( firstName, lastName ) " +
                "VALUES ( ? , ? )");

        sqlInsertAddress = connection.prepareStatement("INSERT INTO useraddresses ( userID, address1, " +
                "address2, city ) " + "VALUES ( ? , ? , ? )");

        sqlInsertPassword = connection.prepareStatement("INSERT INTO userpasswords ( userID, password ) " +
                "VALUES( ? , ? )");

        sqlInsertNumber = connection.prepareStatement("INSERT INTO usernumbers ( userID, number ) " +
                "VALUES( ? , ? )");

        sqlDeleteName = connection.prepareStatement("DELETE FROM usernames WHERE userID = ?");

        sqlDeleteAddress = connection.prepareStatement("DELETE FROM useraddresses WHERE userID = ?");

        sqlDeletePassword = connection.prepareStatement("DELETE FROM userpasswords WHERE userID = ?");

        sqlDeleteNumber = connection.prepareStatement("DELETE FROM usernumbers WHERE userID = ?");

        sqlFindName = connection.prepareStatement("SELECT FROM usernames WHERE userID = ?");

        sqlFindAddress = connection.prepareStatement("SELECT FROM useraddresses WHERE userID = ?");

        sqlFindPassword = connection.prepareStatement("SELECT FROM userpasswords WHERE userID = ?");

        sqlFindNumber = connection.prepareStatement("SELECT FROM usernumbers WHERE userID = ?");

        sqlFindUser = connection.prepareStatement(
                "SELECT usernames.userID, firstName, lastName, addressID, address1, address2, city," +
                        " eircode, numberID, number, passwordID, password FROM usernames," +
                        " useraddresses, usernumbers, userpasswords WHERE firstName = ? AND lastName = ? AND password = ? " +
                        "AND usernames.userID = useraddresses.userID AND usernames.userID = userumbers.userID" +
                        "AND usernames.userID = userpassword.userID" );

        sqlFindUserID = connection.prepareStatement( "SELECT usernames.userID FROM usernames " +
                "WHERE firstName = ? AND lastName = ?" );
    }


    public boolean deleteUser(String firstName, String lastName, String password)
    {
        return true;
    }   //delete user end
}
