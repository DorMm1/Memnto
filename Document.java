public class Document {

    public String content;
    public String fontName;
    public int fontSize;

    private EditorHandler editor;

    public Document(String content, String fontName, int fontSize) {
        this.content = content;
        this.fontName = fontName;
        this.fontSize = fontSize;
        editor = new EditorHandler();
    }

    public void undo(){
        var ed = editor.pop();
        this.setState(ed);
    }
    private void setState(Editor ed){
        this.content = ed.getContentState();
        this.fontSize = ed.getFontSizeState();
        this.fontName = ed.getFontNameState();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        editor.push(new Editor(content,this.fontName,this.fontSize));
    }

    public String getFontName() {
        return fontName;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
        editor.push(new Editor(this.content,fontName,this.fontSize));
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
        editor.push(new Editor(this.content,this.fontName,fontSize));
    }

    @Override
    public String toString() {
        return "Document: {" +
                "content='" + content + '\'' +
                ", fontName='" + fontName + '\'' +
                ", fontSize=" + fontSize +
                '}';
    }
}
