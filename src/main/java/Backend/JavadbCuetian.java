package Backend;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JavadbCuetian {

  private long studentId;
  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private long phoneNumber;
  private String department;
  private String studentStatus;
  private long batch;
  private String dob;
  private long age;
  private String presentAddress;
  private String permanentAddress;
  private String joiningYear;
  private String passingYear;
  private String profession;
  private String company;
  private String facebookProfile;
  private String linkedInProfile;


  public long getStudentId() {
    return studentId;
  }

  public void setStudentId(long studentId) {
    this.studentId = studentId;
  }


  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }


  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public long getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(long phoneNumber) {
    this.phoneNumber = phoneNumber;
  }


  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }


  public String getStudentStatus() {
    return studentStatus;
  }

  public void setStudentStatus(String studentStatus) {
    this.studentStatus = studentStatus;
  }


  public long getBatch() {
    return batch;
  }

  public void setBatch(long batch) {
    this.batch = batch;
  }


  public String getDob() {
    return dob;
  }

  public void setDob(String dob) {
    this.dob = dob;
  }


  public long getAge() {
    return age;
  }

  public void setAge(long age) {
    this.age = age;
  }


  public String getPresentAddress() {
    return presentAddress;
  }

  public void setPresentAddress(String presentAddress) {
    this.presentAddress = presentAddress;
  }


  public String getPermanentAddress() {
    return permanentAddress;
  }

  public void setPermanentAddress(String permanentAddress) {
    this.permanentAddress = permanentAddress;
  }


  public String getJoiningYear() {
    return joiningYear;
  }

  public void setJoiningYear(String joiningYear) {
    this.joiningYear = joiningYear;
  }


  public String getPassingYear() {
    return passingYear;
  }

  public void setPassingYear(String passingYear) {
    this.passingYear = passingYear;
  }


  public String getProfession() {
    return profession;
  }

  public void setProfession(String profession) {
    this.profession = profession;
  }


  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }


  public String getFacebookProfile() {
    return facebookProfile;
  }

  public void setFacebookProfile(String facebookProfile) {
    this.facebookProfile = facebookProfile;
  }


  public String getLinkedInProfile() {
    return linkedInProfile;
  }

  public void setLinkedInProfile(String linkedInProfile) {
    this.linkedInProfile = linkedInProfile;
  }
  public JavadbCuetian(ResultSet rs) {
    try {
      this.setStudentId(rs.getLong("student_id"));
      this.setFirstName(rs.getString("first_name"));
      this.setLastName(rs.getString("last_name"));
      this.setEmail(rs.getString("email"));
      this.setPassword(rs.getString("password"));
      this.setPhoneNumber(rs.getLong("phone_number"));
      this.setDepartment(rs.getString("department"));
      this.setStudentStatus(rs.getString("student_status"));
      this.setBatch(rs.getLong("batch"));
      this.setDob(rs.getString("dob"));
      this.setAge(rs.getLong("age"));
      this.setPresentAddress(rs.getString("present_address"));
      this.setPermanentAddress(rs.getString("permanent_address"));
      this.setJoiningYear(rs.getString("joining_year"));
      this.setPassingYear(rs.getString("passing_year"));
      this.setProfession(rs.getString("profession"));
      this.setCompany(rs.getString("Company"));
      this.setFacebookProfile(rs.getString("facebook_profile"));
      this.setLinkedInProfile(rs.getString("linkedIn_profile"));
    }
    catch(SQLException e){
      throw new RuntimeException(e);
    }
  }
  public static JavadbCuetian login( long ID, String password) {
    try {
      Connection source = db.makeConnections();
      PreparedStatement statement = source.prepareStatement("SELECT * FROM javadb_cuetian WHERE student_id = ? AND password = ?");
      statement.setString(2, password);
      statement.setLong(1, ID);
      ResultSet rs = statement.executeQuery();
      while (rs.next()) {
        return new JavadbCuetian(rs);
      }
    }
    catch(SQLException e){
        throw new RuntimeException(e);
      }
      return null;
    }
  public static JavadbCuetian signup(long ID,String firstName, String lastName, String email, String password, long phoneNumber, String department, String studentStatus, long batch, String dob, long age, String presentAddress, String permanentAddress, String joiningYear, String passing_year, String profession, String company, String facebookProfile, String linkedInProfile) throws SQLException {

      java.sql.Connection source = db.makeConnections();
      PreparedStatement st = source.prepareStatement("INSERT INTO `javadb_cuetian` (`student_id`, `first_name`, `last_name`, `email`, `password`, `phone_number`, `department`, `student_status`, `batch`, `dob`, `age`, `present_address`, `permanent_address`, `joining_year`, `passing_year`, `profession`, `Company`, `facebook_profile`, `linkedIn_profile`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)");
      st.setLong(1, ID);
      st.setString(2, firstName);
      st.setString(3, lastName);
      st.setString(4,email);
      st.setString(5, password);
      st.setLong(6,phoneNumber);
      st.setString(7, department);
      st.setString(8, studentStatus);
      st.setLong(9, batch);
      st.setString(10, dob);
      st.setLong(11, age);
      st.setString(12,presentAddress);
      st.setString(13, permanentAddress);
      st.setString(14, joiningYear);
      st.setString(15, passing_year);
      st.setString(16, profession);
      st.setString(17, company);
      st.setString(18, facebookProfile);
      st.setString(19, linkedInProfile);
      st.execute();
      st.close();
      return login(ID, password);

  }

}
