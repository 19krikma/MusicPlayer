import javafx.scene.media.*;

public class Player {

	Media media;
	AudioClip mediaPlayer;
	MediaView view;

	public Player(String name) {
		media = new Media(name);
		mediaPlayer = new AudioClip(media.getSource());
	}
}
