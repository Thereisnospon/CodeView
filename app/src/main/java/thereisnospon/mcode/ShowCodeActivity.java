package thereisnospon.mcode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import thereisnospon.codeview.CodeView;
import thereisnospon.codeview.CodeViewTheme;

public class ShowCodeActivity extends AppCompatActivity {


    CodeView codeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int theme = getIntent().getIntExtra("theme", 0);
        codeView = (CodeView) findViewById(R.id.codeview);
        codeView.setTheme(CodeViewTheme.listThemes()[theme]);
        codeView.fillColor();

        codeView.showCode(Constant.CODE);
    }
}
