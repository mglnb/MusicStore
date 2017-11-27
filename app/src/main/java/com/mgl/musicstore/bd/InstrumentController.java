package com.mgl.musicstore.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.mgl.musicstore.Instrument;

/**
 * Created by Miguel on 26/11/2017.
 */

public class InstrumentController {
    private SQLiteDatabase db;
    private InstrumentCreate instrumentCreate;

    public InstrumentController(Context context) {
        this.instrumentCreate = new InstrumentCreate(context);
    }


    public String save(Instrument instrument) {
        ContentValues values;
        long result;

        db = instrumentCreate.getWritableDatabase();

        values = new ContentValues();
            values.put(InstrumentCreate.BD_MODELO, instrument.getModelo());
        values.put(InstrumentCreate.BD_MARCA, instrument.getMarca());
        values.put(InstrumentCreate.BD_COR, instrument.getCor());
        values.put(InstrumentCreate.BD_CATEGORIA, instrument.getCategoria());
        values.put(InstrumentCreate.BD_PRECO, instrument.getPreco());

        result = db.insert(InstrumentCreate.BD_TABLE, null, values);
        db.close();
        return result != -1 ? "Registro inserido com sucesso" : "Erro ao inserir registro";
    }

    public Cursor getAll() {
        Cursor cursor;
        String[] campos = {InstrumentCreate.BD_ID,
                InstrumentCreate.BD_MODELO,
                InstrumentCreate.BD_MARCA,
                InstrumentCreate.BD_COR,
                InstrumentCreate.BD_CATEGORIA,
                InstrumentCreate.BD_PRECO};
        db = instrumentCreate.getReadableDatabase();
        cursor = db.query(InstrumentCreate.BD_TABLE, campos, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();

        }
        db.close();
        return cursor;
    }

    public Cursor findById(int id) {
        Cursor cursor;

        String[] campos = {InstrumentCreate.BD_ID};
        db = instrumentCreate.getReadableDatabase();
        cursor = db.query(InstrumentCreate.BD_TABLE, campos,"_id = ?",new String[]{String.valueOf(id)},null,null,null);

        if(cursor !=null) {
            cursor.moveToFirst();
        }
        if(cursor.getColumnCount() < 1) {
            return null;
        }
        db.close();
        return cursor;
    }
}
