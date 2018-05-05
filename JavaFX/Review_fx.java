import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Review_fx extends BorderPane implements PaneState  {
	
	private ApplicationUI frame;
	private ChoiceBox<String> building_box;
	private ChoiceBox<Integer> room_number_box;
	private TextArea textarea;
	private Button submit;
	
	public Review_fx(ApplicationUI _frame) {
		frame = _frame;
		
		building_box = new ChoiceBox<String>();
		room_number_box = new ChoiceBox<Integer>();
		textarea = new TextArea();
		submit = new Button("Submit");
		
		addComponents();
	}

	@Override
	public void addComponents() {
		
		VBox vbox = new VBox();
		HBox hbox = new HBox();
		hbox.getChildren().add(building_box);
		hbox.getChildren().add(new Separator());
		hbox.getChildren().add(room_number_box);
		vbox.getChildren().add(hbox);
		vbox.getChildren().add(textarea);
		vbox.getChildren().add(submit);
		this.setCenter(vbox);
	}

}
