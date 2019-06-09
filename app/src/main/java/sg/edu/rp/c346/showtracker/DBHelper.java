package sg.edu.rp.c346.showtracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    // start version with 1
    // increment by 1 whenever db schema changes

    private static final int DATABASE_VER = 1;
    // file name of database
    private static final String DATABASE_NAME = "show.db";

    private static final String TABLE_SHOW = "show";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_GENRE = "genre";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_LANGUAGE = "language";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSql = "CREATE TABLE " + TABLE_SHOW +  "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_NAME + " TEXT,"
                + COLUMN_DATE + " TEXT,"
                + COLUMN_GENRE + " TEXT,"+ COLUMN_LANGUAGE + " TEXT )";
        db.execSQL(createTableSql);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SHOW);
        onCreate(db);
    }
    public long insertShow(String name, String date, String genre, String language) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_NAME, name);
        values.put(COLUMN_DATE, date);
        values.put(COLUMN_GENRE, genre);
        values.put(COLUMN_LANGUAGE, language);

        // Insert the row into the TABLE_SHOW
        long result = db.insert(TABLE_SHOW, null, values);
        // close database connection
        if (result == -1) {
            Log.d("DBHelper", "Insert failed");
        }
        db.close();
        Log.d("SQL Insert", "" + result);

        return result;

    }
    public ArrayList<Show> getShowContent() {
        // Create an ArrayList that holds String objects
        ArrayList<Show> shows = new ArrayList<Show>();
        // Select all the shows's ...
        String selectQuery = "SELECT " + COLUMN_ID + "," + COLUMN_NAME + "," + COLUMN_DATE + ","  + COLUMN_GENRE + "," + COLUMN_LANGUAGE
                + " FROM " + TABLE_SHOW;


        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);


        if (cursor.moveToFirst()) {

            do {

                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String date = cursor.getString(2);
                String genre = cursor.getString(3);
                String language = cursor.getString(4);
                Show obj = new Show(id, name, date, genre, language);
                shows.add(obj);
            } while (cursor.moveToNext());
        }
        // Close connection
        cursor.close();
        db.close();

        return shows;
    }

}
