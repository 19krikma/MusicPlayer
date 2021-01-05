import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

public class ButtonSong extends FlowPane {
	private String path;
	Player player;
	private ControlPane control;

	public ButtonSong(ControlPane control) throws IOException {
		this.control = control;
		SetPath();
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
			String name = ButtonName(file.getName());
			Button button = new Button(name);
			button.setOnAction(e -> {
				Playing(listSongs);
				this.player = new Player(file.toURI().toString());
				player.mediaPlayer.play();
			});
			this.getChildren().add(button);
		}
	}
	
	public void Playing(File[] songs) {
		for (File file : songs) {
			this.player = new Player(file.toURI().toString());
			player.mediaPlayer.stop();
		}
	}
	
	private void SetPath() {
		this.path = control.getDir();
	}
	
	private String ButtonName(String file) {
		final String regex = "(.*)([.].*)";
		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		final Matcher matcher = pattern.matcher(file);
		if (matcher.find()) {
			return matcher.group(1);
		}
		return null;
	}
}
