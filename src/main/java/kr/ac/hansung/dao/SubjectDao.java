package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Subject;

//@Component("subjectDao")
@Repository
public class SubjectDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public int getRowCount() {

    	String sqlStatement = "select count(*) from subjects";
    	return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
    	
    }
    
    //query and return a single object
    public Subject getSubject(String name) {
    	String sqlStatement = "select * from subjects where name=?";
    	
    	return jdbcTemplate.queryForObject(sqlStatement, new Object[] {name}, 
    			new RowMapper<Subject>() {

			@Override
			public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {

				Subject subjects = new Subject();
				
				subjects.setYear(rs.getInt("year"));
				subjects.setSemester(rs.getInt("semester"));
				subjects.setSubject(rs.getString("subject"));
				subjects.setClassification(rs.getString("classification"));
				subjects.setProfessor(rs.getNString("professor"));
				subjects.setCredit(rs.getInt("credit"));
				
				return subjects;
			}
    		
    	});
    	
    }
    
  //query and return a multiple object
  //cRud method
    public List<Subject> getSubjects() {
    	
    	String sqlStatement = "select * from subjects";
    	return jdbcTemplate.query(sqlStatement,	new RowMapper<Subject>() {

			@Override
			public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {

				Subject subjects = new Subject();
				
				subjects.setYear(rs.getInt("year"));
				subjects.setSemester(rs.getInt("semester"));
				subjects.setSubject(rs.getString("subject"));
				subjects.setClassification(rs.getString("classification"));
				subjects.setProfessor(rs.getNString("professor"));
				subjects.setCredit(rs.getInt("credit"));
				
				return subjects;
			}
    		
    	});
    	
    }
    
    //Crud method
    public boolean insert(Subject subjects) {
    	int year = subjects.getYear();
    	int semester = subjects.getSemester();
    	String subject = subjects.getSubject();
    	String classification = subjects.getClassification();
    	String professor = subjects.getProfessor();
    	int credit = subjects.getCredit();
    	
    	String sqlStatement = "insert into subjects (year, semester, subject, classification, professor, credit) value(?, ? ,?, ?, ? ,?)";
    	
    	return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester, subject, classification, professor, credit}) == 1);
 
    }
    
    //crUd method
    public boolean update(Subject subjects) {
    	
    	int year = subjects.getYear();
    	int semester = subjects.getSemester();
    	String subject = subjects.getSubject();
    	String classification = subjects.getClassification();
    	String professor = subjects.getProfessor();
    	int credit = subjects.getCredit();
    	
    	String sqlStatement = "update subjects set year=?, semester=?, subject=?, classification=?, professor=?, credit=? where subject=?";
    	
    	return (jdbcTemplate.update(sqlStatement, new Object[] {year, semester, classification, professor, credit, subject}) == 1);
 
    }
    
    //cruD method
    public boolean delete(Subject subject) {
    	   	
    	String sqlStatement = "delete from subjects where subject=?";
    	
    	return (jdbcTemplate.update(sqlStatement, new Object[] {subject}) == 1);
 
    }
  
    
    public List<Subject> getSubjectsList() {
    	
    	String sqlStatement = "select year, semester, sum(credit) from subjects group by year, semester";
    	return jdbcTemplate.query(sqlStatement,	new RowMapper<Subject>() {

			@Override
			public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {

				Subject subjects = new Subject();
				
				subjects.setYear(rs.getInt("year"));
				subjects.setSemester(rs.getInt("semester"));
				subjects.setCredit(rs.getInt("sum(credit)"));
				
				return subjects;
			}
    		
    	});
    	
    }
    
    public List<Subject> getNewSubjectsList() {
    	
    	String sqlStatement = "select * from subjects where year=2021";
    	return jdbcTemplate.query(sqlStatement,	new RowMapper<Subject>() {

			@Override
			public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {

				Subject subjects = new Subject();
				
				subjects.setYear(rs.getInt("year"));
				subjects.setSemester(rs.getInt("semester"));
				subjects.setSubject(rs.getString("subject"));
				subjects.setClassification(rs.getString("classification"));
				subjects.setProfessor(rs.getNString("professor"));
				subjects.setCredit(rs.getInt("credit"));
				return subjects;
			}
    		
    	});
    	
    }
    
    public List<Subject> getSubjectsListWithSemester(int year, int semester) {
    	String sqlStatement = "select * from subjects where year=? and semester=?";
    	return jdbcTemplate.query(sqlStatement, new Object[] {year, semester}, new RowMapper<Subject>() {

			@Override
			public Subject mapRow(ResultSet rs, int rowNum) throws SQLException {

				Subject subjects = new Subject();
				
				subjects.setYear(rs.getInt("year"));
				subjects.setSemester(rs.getInt("semester"));
				subjects.setSubject(rs.getString("subject"));
				subjects.setClassification(rs.getString("classification"));
				subjects.setProfessor(rs.getNString("professor"));
				subjects.setCredit(rs.getInt("credit"));
				return subjects;
			}
    		
    	});
    	
    }
    
}
