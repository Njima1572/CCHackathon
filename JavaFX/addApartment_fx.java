import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class addApartment_fx extends BorderPane implements PaneState{

	private ApplicationUI frame;
	
	private TextField building_name;
	private TextField roomnumber;
	private CheckBox lofted;
	private CheckBox goldcard;
	private CheckBox separateBathroom;
	private Label bathroom_label;
	private ChoiceBox<Integer> bathroomNumber_box;
	private Label residents_label;
	private ChoiceBox<Integer> numOfRes_box;
	private Label doubleroom_label;
	private ChoiceBox<Integer> numOfDoubleRoom_box;
	private Button confirm;
	
	private ArrayList<Integer> res_arraylist;
	private ArrayList<Integer> double_arraylist;
	private ArrayList<Integer> bathroom_arraylist;
	
	private ObservableList<Integer> ob_res;
	private ObservableList<Integer> ob_double;
	private ObservableList<Integer> ob_bathroom;

	public addApartment_fx(ApplicationUI _frame) {
		building_name = new TextField();
		roomnumber = new TextField();
		res_arraylist = new ArrayList<Integer>();
		double_arraylist = new ArrayList<Integer>();
		bathroom_arraylist = new ArrayList<Integer>();
		
		initiateArrayList();

		
		frame = _frame;
		lofted = new CheckBox("Lofted");
		goldcard = new CheckBox("GoldCard Access");
		separateBathroom = new CheckBox("Separate Bathroom and Shower");
		
		bathroomNumber_box = new ChoiceBox<Integer>(ob_bathroom);
		bathroom_label = new Label("Number of Bathroom: ");
		
		numOfRes_box = new ChoiceBox<Integer>(ob_res);
		residents_label = new Label("Number of residents");
		
		numOfDoubleRoom_box = new ChoiceBox<Integer>(ob_double);
		doubleroom_label = new Label("Number of Double rooms");
		confirm = new Button("Submit");
		
		addComponents();
		initializeButtons();
		
	}
	
	public void addComponents() {
		VBox vbox = new VBox();
		HBox room_box = new HBox();
		HBox checkbox_box = new HBox();
		HBox bathroom_box = new HBox();
		HBox residents_box = new HBox();
		HBox double_box = new HBox();
		
		room_box.getChildren().add(building_name);
		room_box.getChildren().add(new Separator());
		room_box.getChildren().add(roomnumber);
		checkbox_box.getChildren().add(lofted);
		checkbox_box.getChildren().add(goldcard);
		checkbox_box.getChildren().add(separateBathroom);
		bathroom_box.getChildren().add(bathroomNumber_box);
		bathroom_box.getChildren().add(bathroom_label);
		residents_box.getChildren().add(numOfRes_box);
		residents_box.getChildren().add(residents_label);
		double_box.getChildren().add(numOfDoubleRoom_box);
		double_box.getChildren().add(doubleroom_label);
		
		vbox.getChildren().add(room_box);
		vbox.getChildren().add(checkbox_box);
		vbox.getChildren().add(new Separator());
		vbox.getChildren().add(bathroom_box);
		vbox.getChildren().add(new Separator());
		vbox.getChildren().add(residents_box);
		vbox.getChildren().add(new Separator());
		vbox.getChildren().add(double_box);
		vbox.getChildren().add(confirm);
		

		vbox.setSpacing(20);
		
		this.setCenter(vbox);
	}
	
	public void initializeButtons() {
		
		BorderPane border = this;
		
		confirm.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				String building = building_name.getText();
				int building_id = Database.convertBuildingToInt(building);
				String aptid_string = building_id + roomnumber.getText();
				int aptid = Integer.parseInt(aptid_string);
				Database.createAndUseDatabase();
				Database.addApartment(aptid, lofted.isSelected(), goldcard.isSelected(), separateBathroom.isSelected(), bathroomNumber_box.getValue(), numOfRes_box.getValue(), numOfDoubleRoom_box.getValue());
				border.setCenter(new addApartment_fx(frame));
			}
		});
	}
	
	public void initiateArrayList() {
		res_arraylist.add(1);
		res_arraylist.add(2);
		res_arraylist.add(4);
		res_arraylist.add(5);
		res_arraylist.add(6);
		res_arraylist.add(8);
		
		double_arraylist.add(0);
		double_arraylist.add(1);
		double_arraylist.add(2);
		
		bathroom_arraylist.add(1);
		bathroom_arraylist.add(2);
		
		ob_res = FXCollections.observableList(res_arraylist);
		ob_double = FXCollections.observableList(double_arraylist);
		ob_bathroom = FXCollections.observableList(bathroom_arraylist);
	}
	
	
}
