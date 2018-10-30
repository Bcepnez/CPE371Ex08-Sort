import java.util.Comparator;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	static Student[] person = new Student[5];
	boolean ascen = true;
	RadioButton des, asc;
	RadioButton radio1, radio2, radio3, radio4;
	Label labelresponse= new Label();
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		primaryStage.setTitle("58070501043");
		
		person[0] = new Student(1239, "D", "AAA", 3.5);
		person[1] = new Student(1234, "B", "BBB", 3.7);
		person[2] = new Student(1236, "C", "CCC", 2.5);
		person[3] = new Student(1237, "A", "DDD", 1.5);
		
				
		radio1= new RadioButton("ID");
		radio2= new RadioButton("Firstname");
		radio3= new RadioButton("Lastname");
		radio4= new RadioButton("GPA");

		ToggleGroup question1= new ToggleGroup();

		radio1.setToggleGroup(question1);
		radio2.setToggleGroup(question1);
		radio3.setToggleGroup(question1);
		radio4.setToggleGroup(question1);

		
		ToggleGroup type= new ToggleGroup();

		des= new RadioButton("Descending");
		asc= new RadioButton("Ascending");
		des.setToggleGroup(type);
		asc.setToggleGroup(type);
		
		asc.setOnAction(e->{
			ascen=true;
			if(radio1.isSelected()){
				sort(StdID, ascen);
			}
			else if(radio2.isSelected()){
				sort(StdName, ascen);
			}
			else if(radio3.isSelected()){
				sort(StdLName, ascen);
			}
			else if(radio4.isSelected()){
				sort(StdGPA, ascen);
			}
			else{
				sort(StdID, ascen);
			}
			primaryStage.setScene(Setting());
			primaryStage.show();
		});
		des.setOnAction(e->{
			ascen=false;
			if(radio1.isSelected()){
				sort(StdID, ascen);
			}
			else if(radio2.isSelected()){
				sort(StdName, ascen);
			}
			else if(radio3.isSelected()){
				sort(StdLName, ascen);
			}
			else if(radio4.isSelected()){
				sort(StdGPA, ascen);
			}
			else{
				sort(StdID, ascen);
			}
			primaryStage.setScene(Setting());
			primaryStage.show();
		});

		radio1.setOnAction(e -> {
			sort(StdID, ascen);
			primaryStage.setScene(Setting());
			primaryStage.show();
		});
		radio2.setOnAction(e -> {
			sort(StdName, ascen);
			primaryStage.setScene(Setting());
			primaryStage.show();
		});
		radio3.setOnAction(e -> {
			sort(StdLName, ascen);
			primaryStage.setScene(Setting());
			primaryStage.show();
		});
		radio4.setOnAction(e -> {
			sort(StdGPA, ascen);
			primaryStage.setScene(Setting());
			primaryStage.show();
		});
		primaryStage.setScene(Setting());       
		primaryStage.show();
	}
	
	private Scene Setting() {
		Label labelfirst= new Label("Student DB Query");
		GridPane gridPane = new GridPane();
		gridPane.setMinSize(400, 300);
		gridPane.setPadding(new Insets(10, 10, 10, 10));
		gridPane.setVgap(5); 
	    gridPane.setHgap(5);    
		
		ListView<String> list = new ListView<String>();
		ObservableList<String> items=FXCollections.observableArrayList(
				person[0].getID()+" "+person[0].getFname()+" "+person[0].getLname()+" "+person[0].getGPA(),
				person[1].getID()+" "+person[1].getFname()+" "+person[1].getLname()+" "+person[1].getGPA(),
				person[2].getID()+" "+person[2].getFname()+" "+person[2].getLname()+" "+person[2].getGPA(),
				person[3].getID()+" "+person[3].getFname()+" "+person[3].getLname()+" "+person[3].getGPA()
				);
		
		list.setItems(items);
		list.setPrefWidth(300);
		list.setPrefHeight(150);
		list.setLayoutX(20);
		list.setLayoutY(20);
		
		
		VBox layout= new VBox(5);

		layout.getChildren().addAll(labelfirst, radio1, radio2, radio3, radio4, labelresponse,asc,des);
		gridPane.add(layout, 0, 1);
		gridPane.add(list, 1, 1);     
		
		Scene scene1= new Scene(gridPane, 450, 250);
		return scene1;
	}
	
	public static void sort(Comparator<Student> c,boolean asc) {
		Student tmp;
		for (int k = 0; k < person.length-1; k++) {
			for (int k2 = 0; k2 < person.length-1; k2++) {
				if ((c.compare(person[k], person[k2])>0&&asc==false)||(c.compare(person[k], person[k2])<0&&asc==true)) {
					tmp = person[k];
					person[k]=person[k2];
					person[k2]=tmp;
				}
			}
		}
	}
	public static Comparator<Student> StdID = new Comparator<Student>() {
		public int compare(Student o1, Student o2) {
			int id1 = o1.getID();
			int id2 = o2.getID();
			return id1-id2;
		};
	};
	public static Comparator<Student> StdName = new Comparator<Student>() {
		public int compare(Student o1, Student o2) {
			String id1 = o1.getFname();
			String id2 = o2.getFname();
			return id1.compareTo(id2);
		};
	};
	public static Comparator<Student> StdLName = new Comparator<Student>() {
		public int compare(Student o1, Student o2) {
			String id1 = o1.getLname();
			String id2 = o2.getLname();
			return id1.compareTo(id2);
		};
	};
	public static Comparator<Student> StdGPA = new Comparator<Student>() {
		public int compare(Student o1, Student o2) {
			double id1 = o1.getGPA();
			double id2 = o2.getGPA();
			if (id1-id2<0) {
				return -1;
			}
			else if(id1-id2>0) {
				return 1;
			}
			return 0;
		};
	};
	public static void main(String args[]) {
		launch(args);
	}
	

}
