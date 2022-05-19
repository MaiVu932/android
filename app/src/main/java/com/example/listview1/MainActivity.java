package com.example.listview1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private Button btn, btnUpdate;
    private EditText editText;

    private int vitri = -1;

    private ArrayList<String> listData;
//    private String[] listData;
    private ArrayAdapter<String> adapter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.context = this;

        this.listView = (ListView) findViewById(R.id.lv);
        this.btn = (Button) findViewById(R.id.btn_add);
        this.editText = (EditText) findViewById(R.id.edt_search);
        this.btnUpdate = (Button) findViewById(R.id.btn_update);

//        this.listData = this.context.getResources().getStringArray(R.array.listVideo);
//        this.listData = new String[]{
//          "Bai so 1",
//          "Bai so 2",
//          "Bai so 3"
//        };

        this.listData = new ArrayList<>();
        this.listData.add("101");
        this.listData.add("10");
        this.listData.add("101");
        this.listData.add("10");

        this.adapter = new ArrayAdapter<>(this.context, android.R.layout.simple_list_item_1, this.listData);

        this.listView.setAdapter(this.adapter);

        this.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = editText.getText().toString();

                if(TextUtils.isEmpty(item)) {
                    Toast.makeText(context, "Ban can nhap du lieu", Toast.LENGTH_SHORT).show();
                    return;
                }

                listData.add(item);

                //cap nhap lai dl lisst view
                adapter.notifyDataSetChanged();
            }
        });

        //tao su kien cho tung item trong listview
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                editText.setText(listData.get(position));
                vitri = position;
//                Toast.makeText(context, listData.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        this.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listData.set(vitri, editText.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

        this.listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                dialog.setTitle("Xac nhan");
                dialog.setMessage("Bna co dong y xoa khong");
                dialog.setPositiveButton("Dong y", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listData.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });
                dialog.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = dialog.create();
                alertDialog.show();
                return false;
            }
        });


    }
}