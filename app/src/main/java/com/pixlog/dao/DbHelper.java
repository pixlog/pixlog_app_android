package com.pixlog.dao;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbHelper
        extends SQLiteOpenHelper {

    public static int VERSION = 1;
    public static String DB_NOME = "DB_PIXLOG",
            TABELA_USUARIO = "usuario";

    public DbHelper(Context context){
        super(context, DB_NOME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlUsuario = "CREATE TABLE IF NOT EXISTS " + TABELA_USUARIO
                + "(uuid TEXT PRIMARY KEY, "
                + "name TEXT, "
                + "email TEXT, "
                + "businessName TEXT,"
                + "password TEXT, "
                + "fv TEXT, "
                + "ud TEXT, "
                + "uc TEXT, "
                + "uv TEXT, "
                + "accountType TEXT,"
                + "credits TEXT, "
                + "accessToken TEXT,"
                + "tokenType TEXT,"
                + "expiresAt TEXT,"
                + "loginAut TEXT);";

        try{
            db.execSQL(sqlUsuario);
            Log.i("Table", TABELA_USUARIO+" successfully created");
        }catch (SQLException e){
            Log.e("Table", "Error creating "+TABELA_USUARIO+", "+e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

}
