
package data;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

/**
 *	This class makes it possible to copy things to the clipboard
 * @author vm
 */
public class Clipboard {
	public void copyToClipboard(String str){
		StringSelection stringSelection = new StringSelection(str);
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
 	}
	
}
