package thereisnospon.codeview;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.webkit.WebView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
/**
 * @author thereisnospon
 */
public class CodeView extends WebView {

    private CodeViewTheme theme;
    private String encode;
    private Document document;
    private String baseUrl = null;
    private String historyUrl = null;

    public CodeView(Context context) {
        this(context, null);
    }

    public CodeView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CodeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.theme = CodeViewTheme.DEFAULT;
        this.encode = "utf-8";
        getSettings().setJavaScriptEnabled(true);
    }

    public CodeView setTheme(CodeViewTheme theme) {
        this.theme = theme;
        return this;
    }

    public CodeView setEncode(String encode) {
        this.encode = encode;
        return this;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setHistoryUrl(String historyUrl) {
        this.historyUrl = historyUrl;
    }

    public void showCode(Code code) {
        this.document = Jsoup.parse(BASE_HTML);
        document.head().after(createStyle());
        addCode(code);
        loadDataWithBaseURL(baseUrl, document.html(), "text/html", encode, historyUrl);
    }

    public CodeView fillColor() {
        setBackgroundColor(Color.parseColor(theme.getBackgroundColor()));
        return this;
    }

    public void showCodeHtmlByCssSelect(String localHtml, String cssSelect) {
        documentInit(localHtml);
        Elements elements = document.select(cssSelect);
        showCodeHtml(elements);
        loadDataWithBaseURL(baseUrl, document.html(), "text/html", encode, historyUrl);
    }

    public void showCodeHtmlByClass(String localHtml, String codeClass) {
        documentInit(localHtml);
        Elements elements = document.getElementsByClass(codeClass);
        showCodeHtml(elements);
        loadDataWithBaseURL(baseUrl, document.html(), "text/html", encode, historyUrl);
    }

    private void documentInit(String localHtml) {
        this.document = Jsoup.parse(localHtml);
        document.head().append("\n<script src=\"file:///android_asset/highlight/highlight.pack.js\"></script>\n");
        document.head().append("\n<script>hljs.initHighlightingOnLoad();</script>\n");
        document.head().append(createStyle());
    }

    private void showCodeHtml(Elements codes) {
        if (codes != null) {
            for (int i = 0; i < codes.size(); i++) {
                String raw = codes.get(i).text();
                codes.get(i).html("<pre><code>" + raw + "</code></pre>");
            }
        }
    }

    public void showCode(String code) {
        Code codeModel = new Code(code);
        showCode(codeModel);
    }

    public void showCode(String code, Code.Language language) {
        Code codeModel = new Code(code, language);
        showCode(codeModel);
    }

    public int getCodeBackgroundColor() {
        return Color.parseColor(theme.getBackgroundColor());
    }

    private String createStyle() {
        return "<link rel=\"stylesheet\" href=\"file:///android_asset/highlight/styles/" + theme.getName() + ".css\"/>";
    }

    private void addCode(Code code) {
        document.body().appendElement("pre").appendElement("code").text(code.getCode());
    }

    private static final String BASE_HTML =
            "<!DOCTYPE html>\n" +
                    "<html>\n" +
                    "<head>\n" +
                    "\t<script src=\"file:///android_asset/highlight/highlight.pack.js\"></script>\n" +
                    "\t<script>hljs.initHighlightingOnLoad();</script>\n" +
                    "\t<title></title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "</body>\n" +
                    "</html>";
}
