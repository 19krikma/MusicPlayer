import java.io.*;
import javax.swing.JFileChooser;
import javafx.scene.layout.HBox;

public class ControlPane extends HBox {

	private String ChoosenDir;
	
	public ControlPane() {
		Search();
	}
	
	private void Search() {
		final JFileChooser fc = new JFileChooser();
		fc.setCurrentDirectory(new File("C:\\Users"));
		fc.setDialogTitle("Choose Folder");
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		if (fc.showOpenDialog(fc) == JFileChooser.APPROVE_OPTION) {
			
		}
		setDir(fc.getSelectedFile().getAbsolutePath());
	}
	
	private void setDir(String dir) {
		this.ChoosenDir = dir;
	}
	
	public String getDir() {
		return this.ChoosenDir;
	}
}
