package com.example.todolist;

import java.util.ArrayList;

import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.FragmentManager;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MainActivity extends Activity implements NewItemFragment.OnNewItemAddedListener {
	ArrayList<String> todoItems;
	ArrayAdapter<String> aa;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        FragmentManager fm = getFragmentManager();
        ToDoListFragment todoListFragment = (ToDoListFragment)fm.findFragmentById(R.id.TodolIstFragment);
        
		todoItems= new ArrayList<String>();
		aa = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,todoItems);
		todoListFragment.setListAdapter(aa);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public void onNewItemAdded(String newItem){
		todoItems.add(newItem);
		aa.notifyDataSetChanged();
	}

}
