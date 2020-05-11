public class User {

    private String name;
    private String surname;
    private String Addr1;
    private String Addr2;
    private String eirCode;
    private String city;
    private String phone;
    private String DOB;


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
    public User(String name, String surname, String phone, String Addr1, String Addr2, String city, String DOB, String eirCode)  {

        this.name = name;
        this.surname = surname;
        this.Addr1 = Addr1;
        this.Addr2 = Addr2;
        this.city = city;
        this.phone = phone;
        this.DOB = DOB;
        this.eirCode = eirCode;
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

    public String getDOB() {
        return DOB;
    }

    public String getEirCode() {
        return eirCode;
    }

    //to string method


    @Override
    public String toString() {
        return name+ " " + surname + "\n"
                + Addr1 + "\n"
                + Addr2 + "\n"
                + city + "\n"
                + phone + "\n"
                + DOB + "\n"
                + eirCode + "\n";
    }
}