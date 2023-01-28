package Backend;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JavadbJob {

  private static long id;
  private String jobTitle;
  private String jobDescription;
  private long cuetianPostId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getJobTitle() {
    return jobTitle;
  }

  public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
  }


  public String getJobDescription() {
    return jobDescription;
  }

  public void setJobDescription(String jobDescription) {
    this.jobDescription = jobDescription;
  }

  public long getCuetianPostId() {
    return cuetianPostId;
  }

  public void setCuetianPostId(long cuetianPostId) {
    this.cuetianPostId = cuetianPostId;
  }

  public JavadbJob(ResultSet rs) {
    try {
      this.jobTitle = rs.getString("job_title");
      this.jobDescription = rs.getString("job_description");
      this.cuetianPostId = rs.getLong("cuetian_post_id");
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public static void insertjobdata(String jobTitle, String jobDescription, long postid) throws SQLException {
    Connection source = db.makeConnections();
    PreparedStatement statement = source.prepareStatement("INSERT INTO `javadb_job` (`id`, `job_title`, `job_description`, `cuetian_post_id`) VALUES (NULL, ?, ?, ?)");
    System.out.println("insertjob block");
    statement.setString(1, jobTitle);
    statement.setString(2, jobDescription);
    statement.setLong(3, postid);
    statement.execute();
    statement.close();
  }

  public static ArrayList<JavadbJob> getAllJobs() {
    try {
      Connection source = db.makeConnections();
      PreparedStatement st = source.prepareStatement("SELECT * FROM  javadb_job");
      ResultSet rs = st.executeQuery();
      if(rs==null){
        System.out.println("no data in job table");
      }
      ArrayList<JavadbJob> list = new ArrayList<JavadbJob>();
      while (rs.next()) {
        list.add(new JavadbJob(rs));
      }
      System.out.println("getalljobs succeeded");
      return list;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }
  public static int countJobs(){
    try{
      Connection source = db.makeConnections();
      PreparedStatement st = source.prepareStatement("SELECT count(*) AS  count FROM  javadb_job");
      ResultSet rs = st.executeQuery();
      rs.next();
      System.out.println("countjobs function succeeded");
      return rs.getInt("count");
    }
    catch (SQLException e){
      e.printStackTrace();
    }
    return 0;
  }
  public static ArrayList<JavadbJob> getlistbyid(long studentid){
    try {
      Connection source = db.makeConnections();
      PreparedStatement st = source.prepareStatement("SELECT * FROM  javadb_job WHERE cuetian_post_id = ?");
      st.setLong(1,studentid);
      ResultSet rs = st.executeQuery();
      if(rs==null){
        System.out.println("no data in job table");
      }
      ArrayList<JavadbJob> list = new ArrayList<JavadbJob>();
      while (rs.next()) {
        list.add(new JavadbJob(rs));
      }
      System.out.println("getalljobs succeeded");
      return list;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }
  public static int countjobsbyid(long studentid) {
    try {
      Connection source = db.makeConnections();
      PreparedStatement st = source.prepareStatement("SELECT COUNT(*) AS count FROM `javadb_job` WHERE cuetian_post_id = ?");
      st.setLong(1, studentid);
      ResultSet rs = st.executeQuery();
      rs.next();
      System.out.println("countjobs function succeeded");
      return rs.getInt("count");
    }
    catch (SQLException e){
      e.printStackTrace();
    }
    return 0;
  }
}
