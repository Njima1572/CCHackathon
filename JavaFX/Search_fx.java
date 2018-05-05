import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Search_fx extends BorderPane implements PaneState{
	
	private ApplicationUI frame;
	private int[] aptids;
	private ChoiceBox<String> building;
	private CheckBox lofted;
	private CheckBox goldcard;
	private CheckBox separateBathroom;
	private ChoiceBox<Integer> bathroomNumber_box;
	private ChoiceBox<Integer> numOfRes_box;
	private ChoiceBox<Integer> numOfDoubleRoom_box;
	private Button confirm;
	
	private Label bathroomnumber_label, numofres_label, numofdoubleroom_label;
	
	public Search_fx(ApplicationUI _frame) {
		ArrayList<Integer> aptids = new ArrayList<Integer>();
		
		building = new ChoiceBox<String>();
		lofted = new CheckBox("Lofted");
		goldcard = new CheckBox("GoldCard Access");
		separateBathroom = new CheckBox("Separate Bathroom and Shower");
		bathroomNumber_box = new ChoiceBox<Integer>();
		numOfRes_box = new ChoiceBox<Integer>();
		numOfDoubleRoom_box = new ChoiceBox<Integer>();
		confirm = new Button("Search");
		
		bathroomnumber_label = new Label("Number of Bathroom");
		numofres_label = new Label("Number of Residents");
		numofdoubleroom_label = new Label("Number of Double Room");
		
		frame = _frame;
//		Database.getIds(aptids);
		addComponents();
		initializeButton();
		
	}
	

	@Override
	public void addComponents() {
		VBox vbox = new VBox();
		HBox condition1 = new HBox();
		VBox condition2 = new VBox();
		HBox bathroom_box = new HBox();
		HBox resident_box = new HBox();
		HBox double_box = new HBox();
		
		vbox.getChildren().add(building);
		vbox.getChildren().add(new Separator());
		condition2.getChildren().add(new Separator());
		condition1.getChildren().add(lofted);
		condition1.getChildren().add(new Separator());

		condition1.getChildren().add(goldcard);
		condition1.getChildren().add(new Separator());

		condition1.getChildren().add(separateBathroom);

		bathroom_box.getChildren().add(bathroomNumber_box);
		bathroom_box.getChildren().add(bathroomnumber_label);
		condition2.getChildren().add(bathroom_box);
		condition2.getChildren().add(new Separator());

		resident_box.getChildren().add(numOfRes_box);
		resident_box.getChildren().add(numofres_label);
		condition2.getChildren().add(resident_box);
		condition2.getChildren().add(new Separator());

		double_box.getChildren().add(numOfDoubleRoom_box);
		double_box.getChildren().add(numofdoubleroom_label);
		condition2.getChildren().add(double_box);

		vbox.getChildren().add(condition1);
		vbox.getChildren().add(new Separator());
		vbox.getChildren().add(condition2);
		vbox.setSpacing(20);
		condition2.setSpacing(20);

		vbox.getChildren().add(confirm);

		this.setCenter(vbox);
		
	}
	
	
	public void initializeButton() {
		
		lofted.allowIndeterminateProperty();
		goldcard.allowIndeterminateProperty();
		separateBathroom.allowIndeterminateProperty();

		lofted.setIndeterminate(true);
		goldcard.setIndeterminate(true);
		separateBathroom.setIndeterminate(true);
		
		BorderPane border = this;
		
		confirm.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				boolean lofted_result = lofted.isSelected();
				boolean gold_result = goldcard.isSelected();
				boolean bathroom_result = separateBathroom.isSelected();
				int bathroom_number = bathroomNumber_box.getValue();
				int res_number = numOfRes_box.getValue();
				int doubleRoom_number = numOfDoubleRoom_box.getValue();
				Database.findApartment(lofted_result, gold_result, bathroom_result, bathroom_number, res_number, doubleRoom_number);
				border.setCenter(new Result_fx());
			}
		});
	}
	

}
