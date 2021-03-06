package com.com.sky.downloader.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import com.quanying.app.bean.Shop;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "SHOP".
*/
public class ShopDao extends AbstractDao<Shop, Long> {

    public static final String TABLENAME = "SHOP";

    /**
     * Properties of entity Shop.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Face = new Property(2, String.class, "face", false, "price");
        public final static Property SendTime = new Property(3, String.class, "sendTime", false, "SEND_TIME");
        public final static Property GetTime = new Property(4, String.class, "getTime", false, "GET_TIME");
        public final static Property HxId = new Property(5, String.class, "hxId", false, "HX_ID");
        public final static Property Yuliu1 = new Property(6, String.class, "yuliu1", false, "YULIU1");
        public final static Property Yuliu2 = new Property(7, String.class, "yuliu2", false, "YULIU2");
        public final static Property Image_url = new Property(8, String.class, "image_url", false, "IMAGE_URL");
        public final static Property Type = new Property(9, int.class, "type", false, "TYPE");
        public final static Property Sell_num = new Property(10, int.class, "sell_num", false, "SELL_NUM");
    }


    public ShopDao(DaoConfig config) {
        super(config);
    }
    
    public ShopDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"SHOP\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"NAME\" TEXT UNIQUE ," + // 1: name
                "\"price\" TEXT," + // 2: face
                "\"SEND_TIME\" TEXT," + // 3: sendTime
                "\"GET_TIME\" TEXT," + // 4: getTime
                "\"HX_ID\" TEXT," + // 5: hxId
                "\"YULIU1\" TEXT," + // 6: yuliu1
                "\"YULIU2\" TEXT," + // 7: yuliu2
                "\"IMAGE_URL\" TEXT," + // 8: image_url
                "\"TYPE\" INTEGER NOT NULL ," + // 9: type
                "\"SELL_NUM\" INTEGER NOT NULL );"); // 10: sell_num
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"SHOP\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Shop entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String face = entity.getFace();
        if (face != null) {
            stmt.bindString(3, face);
        }
 
        String sendTime = entity.getSendTime();
        if (sendTime != null) {
            stmt.bindString(4, sendTime);
        }
 
        String getTime = entity.getGetTime();
        if (getTime != null) {
            stmt.bindString(5, getTime);
        }
 
        String hxId = entity.getHxId();
        if (hxId != null) {
            stmt.bindString(6, hxId);
        }
 
        String yuliu1 = entity.getYuliu1();
        if (yuliu1 != null) {
            stmt.bindString(7, yuliu1);
        }
 
        String yuliu2 = entity.getYuliu2();
        if (yuliu2 != null) {
            stmt.bindString(8, yuliu2);
        }
 
        String image_url = entity.getImage_url();
        if (image_url != null) {
            stmt.bindString(9, image_url);
        }
        stmt.bindLong(10, entity.getType());
        stmt.bindLong(11, entity.getSell_num());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Shop entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String face = entity.getFace();
        if (face != null) {
            stmt.bindString(3, face);
        }
 
        String sendTime = entity.getSendTime();
        if (sendTime != null) {
            stmt.bindString(4, sendTime);
        }
 
        String getTime = entity.getGetTime();
        if (getTime != null) {
            stmt.bindString(5, getTime);
        }
 
        String hxId = entity.getHxId();
        if (hxId != null) {
            stmt.bindString(6, hxId);
        }
 
        String yuliu1 = entity.getYuliu1();
        if (yuliu1 != null) {
            stmt.bindString(7, yuliu1);
        }
 
        String yuliu2 = entity.getYuliu2();
        if (yuliu2 != null) {
            stmt.bindString(8, yuliu2);
        }
 
        String image_url = entity.getImage_url();
        if (image_url != null) {
            stmt.bindString(9, image_url);
        }
        stmt.bindLong(10, entity.getType());
        stmt.bindLong(11, entity.getSell_num());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public Shop readEntity(Cursor cursor, int offset) {
        Shop entity = new Shop( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // face
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // sendTime
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // getTime
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // hxId
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // yuliu1
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7), // yuliu2
            cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8), // image_url
            cursor.getInt(offset + 9), // type
            cursor.getInt(offset + 10) // sell_num
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Shop entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setFace(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setSendTime(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setGetTime(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setHxId(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setYuliu1(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setYuliu2(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
        entity.setImage_url(cursor.isNull(offset + 8) ? null : cursor.getString(offset + 8));
        entity.setType(cursor.getInt(offset + 9));
        entity.setSell_num(cursor.getInt(offset + 10));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Shop entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Shop entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Shop entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
