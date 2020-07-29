package thereisnospon.mcode;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import thereisnospon.codeview.CodeViewTheme;

public class IndexActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        listView = (ListView) findViewById(R.id.listview);
        List<String> themeList = new ArrayList<>();
        for (CodeViewTheme theme : CodeViewTheme.listThemes()) {
            themeList.add(theme.getName());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, themeList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(IndexActivity.this, ShowCodeActivity.class);
                intent.putExtra("theme", position);
                startActivity(intent);
            }
        });
    }
}
