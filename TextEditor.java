import java.util.ArrayList;
import java.util.List;

public class TextEditor extends Editor {

    String textState;

    public TextEditor(String textState) {
        this.textState = textState;
    }

    public String getTextState(){
        return this.textState;
    }

}
