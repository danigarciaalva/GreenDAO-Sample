package dflabs.io.dao;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;
import de.greenrobot.dao.query.Query;
import de.greenrobot.dao.query.QueryBuilder;

import dflabs.io.dao.ImagePost;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table IMAGE_POST.
*/
public class ImagePostDao extends AbstractDao<ImagePost, Long> {

    public static final String TABLENAME = "IMAGE_POST";

    /**
     * Properties of entity ImagePost.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Url = new Property(1, String.class, "url", false, "URL");
        public final static Property Post_id = new Property(2, Long.class, "post_id", false, "POST_ID");
    };

    private Query<ImagePost> post_ImagePostListQuery;

    public ImagePostDao(DaoConfig config) {
        super(config);
    }
    
    public ImagePostDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'IMAGE_POST' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'URL' TEXT," + // 1: url
                "'POST_ID' INTEGER);"); // 2: post_id
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'IMAGE_POST'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, ImagePost entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String url = entity.getUrl();
        if (url != null) {
            stmt.bindString(2, url);
        }
 
        Long post_id = entity.getPost_id();
        if (post_id != null) {
            stmt.bindLong(3, post_id);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public ImagePost readEntity(Cursor cursor, int offset) {
        ImagePost entity = new ImagePost( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // url
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2) // post_id
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, ImagePost entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setUrl(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setPost_id(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(ImagePost entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(ImagePost entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "imagePostList" to-many relationship of Post. */
    public List<ImagePost> _queryPost_ImagePostList(Long post_id) {
        synchronized (this) {
            if (post_ImagePostListQuery == null) {
                QueryBuilder<ImagePost> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.Post_id.eq(null));
                post_ImagePostListQuery = queryBuilder.build();
            }
        }
        Query<ImagePost> query = post_ImagePostListQuery.forCurrentThread();
        query.setParameter(0, post_id);
        return query.list();
    }

}
