package MusicPlayer;
/*
 * Mark Kirkunov
 * MusicPlayer v1.0.0
 * 3.31.20
 */

import java.io.IOException;
import javafx.application.Application;
import javafx.geometry.Pos;
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
		primaryStage.setTitle("MusicPlayer");
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}

class AppGUI extends BorderPane {

	public AppGUI() throws IOException {
		ButtonSong buttons = new ButtonSong();
		ControlPane control = new ControlPane(buttons);
		
		control.setAlignment(Pos.CENTER);

		this.setTop(control);
		this.setCenter(buttons);
	}
}
