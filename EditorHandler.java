import java.util.ArrayList;
import java.util.List;

public class EditorHandler {

    List<Editor> stateList;


    public EditorHandler() {
        this.stateList = new ArrayList<>();

    }

    public void push(Editor ed){
        this.stateList.add(ed);
    }

    public Editor pop(){
        Editor temp = this.stateList.get(this.stateList.size()-1);
        this.stateList.remove(this.stateList.size()-1);
        return temp;
    }

    //public void pushNameList(){}
    //public void pushSizeList(){}

}
