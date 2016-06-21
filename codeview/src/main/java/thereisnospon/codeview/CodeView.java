package thereisnospon.codeview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.webkit.WebView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Created by yzr on 16/6/20.
 */
public class CodeView extends WebView {

    Code code;

    public CodeView(Context context) {
        this(context,null);
    }

    public CodeView(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public CodeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getSettings().setJavaScriptEnabled(true);
    }

    public void showCode(Code code){
        Document document= Jsoup.parse(BASE_HTML);
        document.head().after(createStyle(code.getTheme()));
        document.getElementById("code").text(code.getCode());
        setBackgroundColor(Color.parseColor(BACKGROUNDS[code.getTheme()]));
        loadDataWithBaseURL(null,document.html(),"text/html","utf-8",null);
    }

    public void showCode(String code){
        Code ccode=new Code(code,0);
        showCode(ccode);
    }

    public static int parseColor(int theme){
        return Color.parseColor(BACKGROUNDS[theme]);
    }

    private String createStyle(int theme){
        return  "<link rel=\"stylesheet\" href=\"file:///android_asset/highlight/styles/"+ parseTheme(theme)+".css\"/>";
    }

    public static String parseTheme(int theme){
        return THEMES[theme];
    }

    public static final String BASE_HTML="<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "\t<script src=\"file:///android_asset/highlight/highlight.pack.js\"></script>\n" +
            "\t<script>hljs.initHighlightingOnLoad();</script>\n" +
            "\t<title></title>\n" +
            "</head>\n" +
            "<body>\n" +
            "<pre><code class=\"c\" id='code'>\n" +
            "</code></pre>\n" +
            "</body>\n" +
            "</html>";

    public static final String THEMES[]={
            "agate",
            "androidstudio",
            "arduino-light",
            "arta",
            "atelier-cave-dark",
            "atelier-cave-light",
            "atelier-dune-dark",
            "atelier-dune-light",
            "atelier-estuary-dark",
            "atelier-estuary-light",
            "atelier-forest-dark",
            "atelier-forest-light",
            "atelier-heath-dark",
            "atelier-heath-light",
            "atelier-lakeside-dark",
            "atelier-lakeside-light",
            "atelier-plateau-dark",
            "atelier-plateau-light",
            "atelier-savanna-dark",
            "atelier-savanna-light",
            "atelier-seaside-dark",
            "atelier-seaside-light",
            "atelier-sulphurpool-dark",
            "atelier-sulphurpool-light",
            "codepen-embed",
            "color-brewer",
            "dark",
            "darkula",
            "default",
            "docco",
            "dracula",
            "far",
            "foundation",
            "github",
            "grayscale",
            "gruvbox-dark",
            "gruvbox-light",
            "hopscotch",
            "hybrid",
            "idea",
            "ir-black",
            "mono-blue",
            "monokai-sublime",
            "monokai",
            "obsidian",
            "paraiso-dark",
            "paraiso-light",
            "pojoaque",
            "purebasic",
            "qtcreator_dark",
            "qtcreator_light",
            "railscasts",
            "rainbow",
            "solarized-dark",
            "solarized-light",
            "sunburst",
            "tomorrow-night-blue",
            "tomorrow-night-eighties",
            "tomorrow-night",
            "xcode",
            "xt256",
            "zenburn",
    };

    public static final String[] BACKGROUNDS={
            "#030303",
            "#282b2e",
            "#FFFFFF",
            "#020202",
            "#19171c",
            "#efecf4",
            "#20201d",
            "#fefbec",
            "#22221b",
            "#f4f3ec",
            "#1b1918",
            "#f1efee",
            "#1b181b",
            "#f7f3f7",
            "#161b1d",
            "#ebf8ff",
            "#1b1818",
            "#f4ecec",
            "#171c19",
            "#ecf4ee",
            "#131513",
            "#f4fbf4",
            "#202746",
            "#f5f7ff",
            "#020202",
            "#0f0f0f",
            "#040404",
            "#2b2b2b",
            "#F0F0F0",
            "#f8f8ff",
            "#282a36",
            "#000080",
            "#0e0e0e",
            "#f8f8f8",
            "#0f0f0f",
            "#282828",
            "#fbf1c7",
            "#322931",
            "#1d1f21",
            "#0f0f0f",
            "#000000",
            "#eaeef3",
            "#23241f",
            "#272822",
            "#282b2e",
            "#2f1e2e",
            "#e7e9db",
            "#073642",
            "#FFFFDF",
            "#000000",
            "#ffffff",
            "#232323",
            "#474949",
            "#002b36",
            "#fdf6e3",
            "#000000",
            "#002451",
            "#2d2d2d",
            "#1d1f21",
            "#0f0f0f",
            "#000000",
            "#3f3f3f",
    };

}
