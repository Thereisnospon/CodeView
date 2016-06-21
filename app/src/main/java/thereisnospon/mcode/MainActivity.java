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
        Button testtheme=(Button)findViewById(R.id.test_theme);
        testtheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,IndexActivity.class);
                startActivity(intent);
            }
        });
        Button testhtml=(Button)findViewById(R.id.test_htmlcode);
        testhtml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ShowHtmlCodeActivity.class);
                startActivity(intent);
            }
        });
    }
}
