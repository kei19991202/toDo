package android.kei1999.todo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    EditText editText;
    ArrayAdapter adapter;
    int number1 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        editText = (EditText) findViewById(R.id.editText);
        adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListView listView = (ListView) parent;
                ArrayAdapter adapter = (ArrayAdapter) listView.getAdapter();

                if(number1==position){
                    String item = (String)adapter.getItem(position);
                    adapter.remove(item);

                }else {
                    String item = (String)adapter.getItem(position);
                    adapter.remove(item);
                    adapter.insert(item,position+1);
                }

            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String)adapter.getItem(position);
                adapter.remove(item);

                Toast.makeText(getApplicationContext(), "削除しました", Toast.LENGTH_SHORT).show();

                return false;
            }
        });
    }

    public void add (View v){

        if(editText.getText().toString().equals("")){
            Toast.makeText(this,"文字が入力されていません", Toast.LENGTH_SHORT).show();
        }else{
            String text = editText.getText().toString();
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();

            number1++;
            editText.setText("");

            adapter.add(text);
        }

    }
}
