package io.dflabs.grenndaosample;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import dflabs.io.dao.DaoMaster;
import dflabs.io.dao.DaoSession;
import dflabs.io.dao.Post;
import dflabs.io.dao.PostDao;

/**
 * Created by danielgarcia on 7/12/15.
 */
public class AddPostActivity extends AppCompatActivity{

    private EditText mTitleEditText;
    private EditText mBodyEditText;
    private EditText mImageEditText;
    private PostDao postDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);
        mTitleEditText = (EditText)findViewById(R.id.act_add_post_title);
        mBodyEditText = (EditText)findViewById(R.id.act_add_post_body);
        mImageEditText = (EditText)findViewById(R.id.act_add_post_image);
        findViewById(R.id.act_add_post_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPost();
            }
        });
        postDao = DAOApp.getPostDao();
    }

    private void addPost() {
        Post post = new Post();
        post.setTitle(mTitleEditText.getText().toString());
        post.setBody(mBodyEditText.getText().toString());
        post.setImage(mImageEditText.getText().toString());
        postDao.insert(post);
        setResult(RESULT_OK);
        finish();
    }
}
