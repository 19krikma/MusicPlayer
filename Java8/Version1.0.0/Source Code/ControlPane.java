package MusicPlayer;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ControlPane extends HBox {

	public ControlPane(ButtonSong songs) {
		Button stop = new Button("Stop");
		stop.setOnAction(e -> {
			songs.stop();
		});
		
		this.getChildren().add(stop);
	}
}
