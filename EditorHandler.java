import java.util.ArrayList;
import java.util.List;

public class EditorHandler {

    List<Editor> contentList;
    List<Editor> fontNameList;
    List<Editor> fontSizeList;

    public EditorHandler() {
        this.contentList = new ArrayList<>();
        this.fontNameList = new ArrayList<>();
        this.fontSizeList = new ArrayList<>();
    }

    public void push(Editor ed){
        if(ed instanceof TextEditor) contentList.add(ed);
        if(ed instanceof FontNameEditor) fontNameList.add(ed);
        if(ed instanceof FontSizeEditor) fontSizeList.add(ed);
    }

    public Editor pop(){
        Editor temp = this.contentList.get(this.contentList.size()-1);
        this.contentList.remove(this.contentList.size()-1);
        return temp;
    }

    //public void pushNameList(){}
    //public void pushSizeList(){}

}
