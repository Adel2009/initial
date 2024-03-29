package hello;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component
public class JobCompletionNotificationListener extends JobExecutionListenerSupport {

    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!!! JOB FINISHED! Time to verify the results");

            List<CourseSchedule> results = jdbcTemplate.query("SELECT CRN, Subj,CurseNumber, Term, Title, Days , Student_Capa , Instructor_Name FROM schedule", new RowMapper<CourseSchedule>() {
                @Override
                public CourseSchedule mapRow(ResultSet rs, int row) throws SQLException {
                    return new CourseSchedule(rs.getInt(1), rs.getString(2), rs.getInt(3),rs.getString(4), rs.getString(5), rs.getString(6) , rs.getInt(7), rs.getString(8));
                }
            });

            for (CourseSchedule course : results) {
                log.info("Found <" + course + "> in the database.\n");

            }
           
        }
    }
}