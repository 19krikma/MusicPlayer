package MusicPlayer;

import java.io.*;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

public class ButtonSong extends FlowPane {
	private String path = "C:\\Users\\Public\\Music";
	Player player;

	public ButtonSong() throws IOException {
		this.setHgap(5);
		this.setVgap(5);
		this.setAlignment(Pos.TOP_CENTER);
		
		File folder = new File(path);
		FilenameFilter filter = new FilenameFilter() {
			@Override
			public boolean accept(File pathname, String name) {
				String lowerCase = name.toLowerCase();
				if (lowerCase.endsWith(".mp3")) {
					return true;
				} else {
					return false;
				}
			}
		};
		File[] listSongs = folder.listFiles(filter);
		for (File file : listSongs) {
			Button button = new Button(file.getName());
			button.setOnAction(e -> {
				this.player = new Player(file.toURI().toString());
				player.mediaPlayer.play();
			});
			this.getChildren().add(button);
		}
	}

	public void stop() {
		player.mediaPlayer.stop();
	}
}
