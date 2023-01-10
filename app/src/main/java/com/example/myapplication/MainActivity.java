package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bin.david.form.core.TableConfig;
import com.bin.david.form.data.CellInfo;
import com.bin.david.form.data.column.Column;
import com.bin.david.form.data.column.Column;
import com.bin.david.form.data.format.bg.BaseBackgroundFormat;
import com.bin.david.form.data.format.bg.BaseCellBackgroundFormat;
import com.bin.david.form.data.format.bg.ICellBackgroundFormat;
import com.bin.david.form.data.table.PageTableData;
import com.bin.david.form.data.table.TableData;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    SmartTable<UserInfo> mSmartTable;
    final Column<String> rankColumn = new Column<>("Thứ hạng", "rank");
    final Column<String> nameColumn = new Column<>("Họ tên", "name");
    final Column<String> ageColumn = new Column<>("age", "age");
    final Column<String> addressColumn = new Column<>("address", "address");
    final Column<String> phoneColumn = new Column<>("phone", "phone");
    final Column<String> emailColumn = new Column<>("email", "email");
    final Column<String> passwordColumn = new Column<>("password", "password");
    final Column<String> heightColumn = new Column<>("height", "height");
    TableData<UserInfo> tableData;
    List<UserInfo> list2 = new ArrayList<>();
    Button btnAdd;
    int rank = 1;
    private long mLastNotifyDataChangeTime = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSmartTable = findViewById(R.id.mSmartTable);
        btnAdd = findViewById(R.id.addMore);
        btnAdd.setOnClickListener(this);
        addDataToList();
        nameColumn.setFixed(true);
        rankColumn.setFixed(true);
        tableData = new PageTableData<UserInfo>("userfInfo", list2, rankColumn, nameColumn, ageColumn, addressColumn, phoneColumn, emailColumn, passwordColumn, heightColumn);
        mSmartTable.setTableData(tableData);
        mSmartTable.getConfig().setShowTableTitle(false);
        mSmartTable.getConfig().setShowXSequence(false);
        mSmartTable.getConfig().setShowYSequence(false);
        mSmartTable.getConfig().setFixedTitle(true);
        mSmartTable.getConfig().setVerticalPadding(24);
        mSmartTable.getConfig().setColumnTitleVerticalPadding(24);


    }

    private void addDataToList() {
        for (int i = 0; i < 10; i++) {
            list2.add(new UserInfo(String.valueOf(rank), "fhfghfghfgh", "22",
                    "gdfgdfgdfg", "gdfgdfg", "gdfgfdg",
                    "gfdgdfgdf", "gdfgdfgdf"));
            rank++;
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addMore:
                Timer t = new Timer();
                t.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        Log.d("testing", "them du lieu nao hihi");
                        addMore();
                    }
                }, 0, 100);
                break;

        }
    }

    private void addMore() {
        for (int i = 0; i < 10; i++) {
            list2.add(new UserInfo(String.valueOf(rank), "fhfghfghfgh", "22",
                    "gdfgdfgdfg", "gdfgdfg", "gdfgfdg",
                    "gfdgdfgdf", "gdfgdfgdf"));
            rank++;
            notifyDataChange();
        }
//        tableData.setT(list2);
//        mSmartTable.setTableData(tableData);


    }

    private void notifyDataChange() {
        if (System.currentTimeMillis() - mLastNotifyDataChangeTime < 1000) {
            return;
        }
        tableData.setT(list2);
        mSmartTable.notifyDataChanged();
        mLastNotifyDataChangeTime = System.currentTimeMillis();
    }

}