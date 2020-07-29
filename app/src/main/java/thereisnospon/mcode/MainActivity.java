package thereisnospon.mcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button testTheme = (Button) findViewById(R.id.test_theme);
        testTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IndexActivity.class);
                startActivity(intent);
            }
        });
        Button testHtml = (Button) findViewById(R.id.test_htmlcode);
        testHtml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShowHtmlCodeActivity.class);
                startActivity(intent);
            }
        });
    }
}
