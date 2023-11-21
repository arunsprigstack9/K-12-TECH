package objects;

public class UserDetails {
    private String fname;
    private String lname;

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    private String middlename;
    private String userid;
    private String grade;
    private String parentemail;
    private String parentname;
    private String parentnumber;


    // Getter Methods

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getUserid() {
        return userid;
    }

    public String getGrade() {
        return grade;
    }

    public String getParentemail() {
        return parentemail;
    }

    public String getParentname() {
        return parentname;
    }

    public String getParentnumber() {
        return parentnumber;
    }

    // Setter Methods

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setParentemail(String parentemail) {
        this.parentemail = parentemail;
    }

    public void setParentname(String parentname) {
        this.parentname = parentname;
    }

    public void setParentnumber(String parentnumber) {
        this.parentnumber = parentnumber;
    }
}