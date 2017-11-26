package com.mgl.musicstore.bd;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Miguel on 26/11/2017.
 */

public class InstrumentCreate extends SQLiteOpenHelper {
    private static final String BD_NAME = "musicstore";
    private static final String BD_TABLE = "instrument";
    private static final String BD_ID = "_id";
    private static final String BD_MODELO = "modelo";
    private static final String BD_MARCA = "marca";
    private static final String BD_COR = "cor";
    private static final String BD_CATEGORIA = "categoria";
    private static final String BD_PRECO = "preco";
    private static final int VERSAO = 1;



    public InstrumentCreate(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public InstrumentCreate(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE"+BD_TABLE+"("
                + BD_ID + "integer primary key autoincrement,"
                + BD_MODELO + "text,"
                + BD_MARCA + "text,"
                + BD_CATEGORIA + "text,"
                + BD_PRECO + "real,"
                + BD_COR + "text"
                +")";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
