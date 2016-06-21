package thereisnospon.codeview;

/**
 * Created by yzr on 16/6/20.
 */
public class Code {

    String code;
    int theme;

    public Code(String code){
        this(code,0);
    }
    public Code(String code,int theme){
        this.code=code;
        this.theme=theme;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getTheme() {
        return theme;
    }

    public void setTheme(int theme) {
        this.theme = theme;
    }
}
