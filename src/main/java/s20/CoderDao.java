package s20;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CoderDao implements AutoCloseable {
    private static final Logger LOG = LoggerFactory.getLogger(CoderDao.class);
    private static final String GET_ALL = "SELECT coder_id, first_name, last_name, hire_date, salary FROM coders";
    private static final String GET_ALL_BY_COLOR = "select name, coder_id, first_name, last_name, hire_date, salary from teams t inner join team_coder using (team_id)\r\n" + 
    		"                    inner join coders using(coder_id)";
    private Connection conn;

    public CoderDao(DataSource ds) {
        LOG.trace("called");

        try {
            this.conn = ds.getConnection();
        } catch (SQLException se) {
            throw new IllegalStateException("Database issue " + se.getMessage());
        }
    }
    
    public List<Coder> getAll() {
    	LOG.trace("called");
        List<Coder> results = new ArrayList<>();

        try (Statement stmt = conn.createStatement(); //
                ResultSet rs = stmt.executeQuery(GET_ALL)) {
            while (rs.next()) {
                LocalDate hired = rs.getDate("hire_date").toLocalDate();
                Coder cur = new Coder(rs.getLong(1), rs.getString(2), rs.getString(3), hired, rs.getDouble(5));
                results.add(cur);
            }
        } catch (SQLException se) {
            LOG.error("Can't get coders: " + se.getMessage());
            throw new IllegalStateException("Database issue " + se.getMessage());
        }

        return results;
    }
    
    public List<Coder> getAllByColor(String color) {
        LOG.trace("called");
        List<Coder> results = new ArrayList<>();

        try (Statement stmt = conn.createStatement(); //
                ResultSet rs = stmt.executeQuery(GET_ALL_BY_COLOR)) {
            while (rs.next()) {
                LocalDate hired = rs.getDate("hire_date").toLocalDate();
                Coder cur = new Coder(rs.getString(1), rs.getLong(2), rs.getString(3), rs.getString(4), hired, rs.getDouble(6));
                if(color.contentEquals(cur.getColor())) {
                	 results.add(cur);
                }
            }
        } catch (SQLException se) {
            LOG.error("Can't get coders: " + se.getMessage());
            throw new IllegalStateException("Database issue " + se.getMessage());
        }
        return results;
    }
    
    public List<Coder> getAllByColorLambda(String color) {
        LOG.trace("called");
        List<Coder> results = new ArrayList<>();

        try (Statement stmt = conn.createStatement(); //
                ResultSet rs = stmt.executeQuery(GET_ALL_BY_COLOR)) {
            while (rs.next()) {
                LocalDate hired = rs.getDate("hire_date").toLocalDate();
                Coder cur = new Coder(rs.getString(1), rs.getLong(2), rs.getString(3), rs.getString(4), hired, rs.getDouble(6));
                results.add(cur);
            }
        } catch (SQLException se) {
            LOG.error("Can't get coders: " + se.getMessage());
            throw new IllegalStateException("Database issue " + se.getMessage());
        }
        results = filterByColor(results, c -> color.contentEquals(c.getColor()));
        return results;
    }
    
    private List<Coder> filterByColor(List<Coder> coders, Predicate<Coder> p){
    	List<Coder> result = new ArrayList<Coder>();
    	for(Coder c: coders)
    		if(p.test(c))
    			result.add(c);	
    	return result;
    }
    
    @Override
    public void close() throws IOException {
        try {
            conn.close();
        } catch (SQLException se) {
            throw new IllegalStateException("Database issue " + se.getMessage());
        }
    }
}
