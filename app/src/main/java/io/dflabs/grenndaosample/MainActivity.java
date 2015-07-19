package io.dflabs.grenndaosample;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import dflabs.io.dao.Post;
import dflabs.io.dao.PostDao;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_ADD_POST = 999;
    PostDao postDao;
    private ArrayAdapter<Post> mAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list);
        postDao = DAOApp.getPostDao();
        mAdapter = new ArrayAdapter<Post>(this, android.R.layout.simple_list_item_1, postDao.loadAll());
        listView.setAdapter(mAdapter);
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
        if (id == R.id.action_add) {
            startActivityForResult(new Intent(this, AddPostActivity.class), REQUEST_CODE_ADD_POST);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE_ADD_POST){
            if(resultCode == RESULT_OK){
                mAdapter.clear();
                mAdapter.addAll(postDao.loadAll());
                mAdapter.notifyDataSetChanged();
            }
        }
    }
}
