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
    static final String BD_TABLE = "instrument";
    static final String BD_ID = "_id";
    static final String BD_MODELO = "modelo";
    static final String BD_MARCA = "marca";
    static final String BD_COR = "cor";
    static final String BD_CATEGORIA = "categoria";
    static final String BD_PRECO = "preco";
    private static final int VERSAO = 1;


    public InstrumentCreate(Context context) {
        super(context, BD_NAME, null, VERSAO);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE " + BD_TABLE + " ("
                + BD_ID + " integer primary key,"
                + BD_MODELO + " text, "
                + BD_MARCA + " text, "
                + BD_CATEGORIA + " text, "
                + BD_PRECO + " real, "
                + BD_COR + " text "
                + ")";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }
}
