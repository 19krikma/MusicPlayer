
/*
 * Mark Krikunov
 * Music Player v1.0.1
 * Changes: 
 * -Removed Stop Button
 * -Search for the folder you want to run
 * -Spacing between buttons
 * -Removed .mp3 from the buttons name
 * -Stores name of playing song and stops it immidiatly if needed to
 * 3.31.20
 */

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MusicPlayer extends Application {
	private static final int APPWIDTH = 820;
	private static final int APPHEIGHT = 480;

	public void start(Stage primaryStage) throws IOException {
		AppGUI app = new AppGUI();
		Scene main = new Scene(app, APPWIDTH, APPHEIGHT);
		primaryStage.setScene(main);
		primaryStage.setTitle("Music Player");
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}

class AppGUI extends BorderPane {

	public AppGUI() throws IOException {
		ControlPane control = new ControlPane();
		ButtonSong buttons = new ButtonSong(control);

		this.setTop(control);
		this.setCenter(buttons);
	}
}
