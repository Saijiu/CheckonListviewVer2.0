package com.moi.showstateapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

public class MyReceiver extends BroadcastReceiver {
    private List<Item> itemList = new ArrayList<Item>();
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
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
        Postion.setPostion(intent.getIntExtra("position",0));
        Item item = itemList.get(Postion.getPostion());
        ItemConentActivity.actionStart(context, item.getText());
        Intent startIntent = new Intent(context, MyService.class);
        context.startService(startIntent);
    }
}
