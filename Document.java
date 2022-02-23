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
        editor.push(new TextEditor(content));
        editor.push(new FontNameEditor(fontName));
        editor.push(new FontSizeEditor(fontSize));
    }

    public void undo(){
        var ed = editor.pop();
        if(ed instanceof TextEditor) this.content = ((TextEditor) ed).getTextState();
        if(ed instanceof FontNameEditor) this.fontName = ((FontNameEditor) ed).getFontNameState();
        if(ed instanceof FontSizeEditor) this.fontSize = ((FontSizeEditor) ed).getFontSizeState();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        editor.push(new TextEditor(content));
    }

    public String getFontName() {
        return fontName;
    }

    public void setFontName(String fontName) {
        this.fontName = fontName;
        editor.push(new FontNameEditor(fontName));
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
        editor.push(new FontSizeEditor(fontSize));
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
