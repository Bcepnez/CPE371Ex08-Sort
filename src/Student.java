public class Student {

	private int ID;
	private String Fname;
	private String Lname;
	private double GPA;
	public Student(int id,String fname,String lname,double gpa) {
		// TODO Auto-generated constructor stub
		this.ID = id;
		this.Fname = fname;
		this.Lname = lname;
		this.GPA = gpa;
	}
	public String getFname() {
		return Fname;
	}
	public String getLname() {
		return Lname;
	}
	public int getID() {
		return ID;
	}
	public double getGPA() {
		return GPA;
	}
	public void setID(int id) {
		this.ID = id;
	}
	public void setFname(String x) {
		this.Fname = x;
	}
	public void setLname(String x) {
		this.Lname = x;
	}
	public void setGPA(double x) {
		this.GPA = x;
	}
}
