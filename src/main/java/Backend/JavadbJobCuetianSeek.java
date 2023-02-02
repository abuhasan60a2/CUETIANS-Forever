package Backend;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class JavadbJobCuetianSeek {

  private long id;
  private long jobId;
  private long cuetianId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getJobId() {
    return jobId;
  }

  public void setJobId(long jobId) {
    this.jobId = jobId;
  }


  public long getCuetianId() {
    return cuetianId;
  }

  public void setCuetianId(long cuetianId) {
    this.cuetianId = cuetianId;
  }
  public JavadbJobCuetianSeek(ResultSet rs) {
    try {
      this.id = rs.getLong("id");
      this.jobId = rs.getLong("job_id");
      this.cuetianId = rs.getLong("cuetian_id");
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
  public static ArrayList<JavadbJobCuetianSeek> getalpplicantsdata(long job_id){
    try {
      Connection source = db.makeConnections();
      PreparedStatement st = source.prepareStatement("SELECT * FROM  javadb_job_cuetian_seek WHERE job_id = ?");
      st.setLong(1,job_id);
      ResultSet rs = st.executeQuery();
      if(rs==null){
        System.out.println("no data in job table");
      }
      ArrayList<JavadbJobCuetianSeek> list = new ArrayList<JavadbJobCuetianSeek>();
      while (rs.next()) {
        list.add(new JavadbJobCuetianSeek(rs));
      }
      System.out.println("get all job applications succeeded");
      return list;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }
  public static int countapplicants(long jobid){
    try{
      Connection source = db.makeConnections();
      PreparedStatement st = source.prepareStatement("SELECT count(*) AS  count FROM  javadb_job_cuetian_seek WHERE job_id = ?");
      st.setLong(1,jobid);
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
