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
				sorting(ascen);
			}
			else if(radio2.isSelected()){
				sortingFname(ascen);
			}
			else if(radio3.isSelected()){
				sortingLname(ascen);
			}
			else if(radio4.isSelected()){
				sortingGPA(ascen);
			}
			else{
				sorting(ascen);
			}
			primaryStage.setScene(Setting());
			primaryStage.show();
		});
		des.setOnAction(e->{
			ascen=false;
			if(radio1.isSelected()){
				sorting(ascen);
			}
			else if(radio2.isSelected()){
				sortingFname(ascen);
			}
			else if(radio3.isSelected()){
				sortingLname(ascen);
			}
			else if(radio4.isSelected()){
				sortingGPA(ascen);
			}
			else{
				sorting(ascen);
			}
			primaryStage.setScene(Setting());
			primaryStage.show();
		});

		radio1.setOnAction(e -> {
			sorting(ascen);
			primaryStage.setScene(Setting());
			primaryStage.show();
		});
		radio2.setOnAction(e -> {
			sortingFname(ascen);
			primaryStage.setScene(Setting());
			primaryStage.show();
		});
		radio3.setOnAction(e -> {
			sortingLname(ascen);
			primaryStage.setScene(Setting());
			primaryStage.show();
		});
		radio4.setOnAction(e -> {
			sortingGPA(ascen);
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
	private void sorting(boolean asc) {
		for (int i = 0; i < person.length-1; i++) {
			for (int j = 0; j < person.length-1; j++) {
				if(asc){
					if(person[i].compareTo(person[j])>0){
						swap(i, j);
					}
				}else{
					if(person[i].compareTo(person[j])<0){
						swap(i, j);
					}
				}
			}
		}
		
	}
	private void sortingFname(boolean asc) {
		for (int i = 0; i < person.length-1; i++) {
			for (int j = 0; j < person.length-1; j++) {
				if(asc){
					if(person[i].compareFNameTo(person[j])>0){
						swap(i, j);
					}
				}else{
					if(person[i].compareFNameTo(person[j])<0){
						swap(i, j);
					}
				}
			}
		}
	}
	private void sortingLname(boolean asc) {
		for (int i = 0; i < person.length-1; i++) {
			for (int j = 0; j < person.length-1; j++) {
				if(asc){
					if(person[i].compareLNameTo(person[j])>0){
						swap(i, j);
					}
				}else{
					if(person[i].compareLNameTo(person[j])<0){
						swap(i, j);
					}
				}
			}
		}
	}
	private void sortingGPA(boolean asc) {
		for (int i = 0; i < person.length-1; i++) {
			for (int j = 0; j < person.length-1; j++) {
				if(asc){
					if(person[i].compareGPATo(person[j])){
						swap(i, j);
					}
				}else{
					if(!person[i].compareGPATo(person[j])){
						swap(i, j);
					}
				}
			}
		}
	}
	private static void swap(int i, int j){
		Student temp = person[i];
		person[i] = person[j];
		person[j] = temp;
	}
	
	public static void main(String args[]) {
		launch(args);
	}
	

}
