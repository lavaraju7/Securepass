package com.lava.securepass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;
    public class DataBase extends SQLiteOpenHelper {

        private static final  String COL_1 = "_id";
        private static final String COL_2 = "website";
        private static final String COL_3 = "username";
        private static final String COL_4 = "password";
        private static final String DATABASE_NAME = "saved.db";
        private static final String TABLE_NAME = "saveuser";
        private static final int DATABASE_VERSION = 1;
        private Context context;

        DataBase(@Nullable Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.context=context;
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL("CREATE TABLE saveuser (_id INTEGER primary key autoincrement,website TEXT not null,username TEXT not null ,password TEXT not null)");

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate((sqLiteDatabase));
        }

        void addPassword(String website, String username, String password) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentvalues = new ContentValues();
            contentvalues.put(COL_2, website);
            contentvalues.put(COL_3, username);
            contentvalues.put(COL_4, password);
            long result = db.insert(TABLE_NAME, null, contentvalues);
            if(result == -1){
                Toast.makeText(context,"Failed",Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(context,"Success",Toast.LENGTH_LONG).show();
            }
        }
        Cursor readAllData(){
            String query = "SELECT * FROM " + TABLE_NAME;
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = null;
            if(db != null){
                cursor = db.rawQuery(query,null);
            }
            return cursor;
        }
        void delete(String row_id){
            SQLiteDatabase db = this.getWritableDatabase();
            long result = db.delete(TABLE_NAME,"_id=?",new String[]{row_id});

        }

    }

