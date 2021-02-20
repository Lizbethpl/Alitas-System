
package Model;

public class Users {
    private int Id;
    private String name;
    private String lastName;
    private String lastNameM;
    private int phone;
    private String gender;
    private String date;
    private String password;

    public Users() {
    }

    public Users(int Id, String name, String lastName, String lastNameM, int phone, String gender, String date, String password) {
        this.Id = Id;
        this.name = name;
        this.lastName = lastName;
        this.lastNameM = lastNameM;
        this.phone = phone;
        this.gender = gender;
        this.date = date;
        this.password = password;
    }

    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the lastNameM
     */
    public String getLastNameM() {
        return lastNameM;
    }

    /**
     * @param lastNameM the lastNameM to set
     */
    public void setLastNameM(String lastNameM) {
        this.lastNameM = lastNameM;
    }

    /**
     * @return the phone
     */
    public int getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(int phone) {
        this.phone = phone;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
