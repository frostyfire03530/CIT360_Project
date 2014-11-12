package CatBox;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name = "courses")
public class Emph {

	@Id
	@GeneratedValue
	private Integer course_id;
	private Integer course_credits;
	private String course_code;
	private String course_description;
	private String course_name;
	private String emphasis;

	public Emph(){
		
	}
		 public String toString() {
			 //"User [id=" + id + ", pword=" + pword + ", uname=" + uname + ", phoneNumbers]";
		        return "Emph [course_id=" + course_id + ",course_code=" + course_code + ", course_name=" + course_name + ", course_credits= " + course_credits + ", course_description= " +  course_description+ "]";

	}

	public Integer getCourse_id() {
		return course_id;
	}

	public void setCourse_id(Integer course_id) {
		this.course_id = course_id;
	}

	public Integer getCourse_credits() {
		return course_credits;
	}

	public void setCourse_credits(Integer course_credits) {
		this.course_credits = course_credits;
	}

	public String getCourse_code() {
		return course_code;
	}

	public void setCourse_code(String course_code) {
		this.course_code = course_code;
	}

	public String getCourse_description() {
		return course_description;
	}

	public void setCourse_description(String course_description) {
		this.course_description = course_description;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getemphasis() {
		return emphasis;
	}

	public void setemphasis(String emphasis) {
		this.emphasis = emphasis;
	}

}
