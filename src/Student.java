import java.util.Comparator;

public class Student implements Comparable<Student>{

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
	
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return o.getID()-this.getID();
	}
	
	public int compareFNameTo(Student o) {
		// TODO Auto-generated method stub
		return o.getFname().compareToIgnoreCase(this.Fname);
	}
	public int compareLNameTo(Student o) {
		// TODO Auto-generated method stub
		return o.getLname().compareToIgnoreCase(this.Lname);
	}
	public boolean compareGPATo(Student o) {
		// TODO Auto-generated method stub
		if(o.getGPA()-this.GPA > 0){
			return true;
		}
		return false;
	}
	
	
	public static void sort(Student[] stu,Comparator<Student> c,boolean asc) {
		Student tmp;
		for (int k = 0; k < stu.length-1; k++) {
			for (int k2 = 0; k2 < stu.length; k2++) {
				if ((c.compare(stu[k], stu[k2])>0&&asc==true)||(c.compare(stu[k], stu[k2])<0&&asc==false)) {
					tmp = stu[k];
					stu[k]=stu[k2];
					stu[k2]=tmp;
				}
			}
		}
		for (int i = 0; i < stu.length; i++) {
			System.out.println(stu[i].getID()+" "+stu[i].getFname()+" "+stu[i].getLname()+" "+stu[i].getGPA());
		}
	}
}
