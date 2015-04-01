package com.moi.showstateapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private ListView mListView;
    private List<Item> itemList = new ArrayList<Item>();
    private boolean allow = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExitApplication.getInstance().addActivity(this);

        //启动时就开启服务，并且让其显示未选中
        Intent startIntent = new Intent(MainActivity.this, MyService.class);
        Postion.getInstance().setPostion(-1);
        startService(startIntent);

        initItem();
        mListView = (ListView) findViewById(R.id.list_view);
        final MyAdapter adapter = new MyAdapter(MainActivity.this, R.layout.list_item, itemList);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                if (position == Postion.getInstance().getPostion()) {
                    //再点击一次取消选择
                    Postion.getInstance().setPostion(-1);
                } else {
                    if (allow) {
                        Item item = itemList.get(position);
                        ItemConentActivity.actionStart(MainActivity.this, item.getText());
                    }
                    Postion.getInstance().setPostion(position);
                }
                adapter.notifyDataSetChanged();
                Intent startIntent = new Intent(MainActivity.this, MyService.class);
                startService(startIntent);
            }
        });
    }

    private void initItem() {
        for (int i = 0; i < 100; i++) {
            Item one = new Item("item_" + (i * 4 + 1), R.mipmap.one);
            Item two = new Item("item_" + (i * 4 + 2), R.mipmap.two);
            Item three = new Item("item_" + (i * 4 + 3), R.mipmap.three);
            Item four = new Item("item_" + (i * 4 + 4), R.mipmap.four);

            itemList.add(one);
            itemList.add(two);
            itemList.add(three);
            itemList.add(four);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Settings")//设置标题
                    .setMessage("Allow to go to a particular activity on list item click?")//设置提示消息
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            allow = true;
                        }//设置确定的按键

                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {//设置取消按键
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            allow = false;
                        }
                    })
                    .setCancelable(true)//设置按返回键是否响应返回，这是响应
                    .show();//显示
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent stopIntent = new Intent(MainActivity.this, MyService.class);
        stopService(stopIntent);
        ExitApplication.getInstance().exit();
    }
}
