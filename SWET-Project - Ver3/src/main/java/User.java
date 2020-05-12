public class User {

    private String name;
    private String surname;
    private String Addr1;
    private String Addr2;
    private String eirCode;
    private String city;
    private String phone;
    private String password;
    private int userID;
    private int passwordID;
    private int addressID;
    private int numberID;


    public User(){ }

    //constructor takes 2 paramaters name and surname
    public User(String name, String surname)  {

        this.name = name;
        this.surname = surname;
    }

    //constructor 3 paramaters
    public User(String name, String surname, String phone)  {
        this.name = name;
        this.surname = surname;
        this.phone = phone;

    }
    //constructor test all USER data
    public User(String name, String surname, String phone, String Addr1, String Addr2, String city, String eirCode)  {

        this.name = name;
        this.surname = surname;
        this.Addr1 = Addr1;
        this.Addr2 = Addr2;
        this.city = city;
        this.phone = phone;
        this.eirCode = eirCode;
    }

    public User(int userID, String name, String surname, int addressID, String addr1, String addr2, String city,
                String eirCode, int numberID ,String phone, int passwordID, String password)
    {
        this.name = name;
        this.surname = surname;
        Addr1 = addr1;
        Addr2 = addr2;
        this.eirCode = eirCode;
        this.city = city;
        this.phone = phone;
        this.userID = userID;
        this.passwordID = passwordID;
        this.addressID = addressID;
        this.numberID = numberID;
        this.password = password;
    }

    //getter and setters
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddr1() {
        return Addr1;
    }

    public String getAddr2() {
        return Addr2;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }

    public String getEirCode() {
        return eirCode;
    }

    public String getPassword(){ return password; }

    public int getUserID() { return userID; }

    public int getPasswordID() { return passwordID; }

    public int getAddressID() { return addressID; }

    public int getNumberID() { return numberID; }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAddr1(String addr1) {
        Addr1 = addr1;
    }

    public void setAddr2(String addr2) {
        Addr2 = addr2;
    }

    public void setEirCode(String eirCode) {
        this.eirCode = eirCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setPasswordID(int passwordID) {
        this.passwordID = passwordID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public void setNumberID(int numberID) {
        this.numberID = numberID;
    }

    //to string method
    @Override
    public String toString() {
        return name+ " " + surname + "\n"
                + Addr1 + "\n"
                + Addr2 + "\n"
                + city + "\n"
                + phone + "\n"
                + eirCode + "\n";
    }
}