package com.pixlog.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class UserDAO
        implements IUserDAO {

    private SQLiteDatabase write, read;

    public UserDAO(Context context) {
        DbHelper db = new DbHelper(context);
        write = db.getWritableDatabase();
        read = db.getReadableDatabase();
    }

    @Override
    public boolean add(User user) {

        //Trying to insert user in the table
        String sql = "INSERT INTO "+DbHelper.TABELA_USUARIO
                +" (uuid, name, email, businessName, password, fv, ud, uc, uv, accountType, credits, accessToken, tokenType, expiresAt, loginAut)"+
                " VALUES ('"+user.getUuid()+"', " +
                "'"+user.getName()+"', " +
                "'"+user.getEmail()+"', " +
                "'"+user.getBusinessName()+"', " +
                "'"+user.getPassword()+"', " +
                "'"+user.getFv()+"', " +
                "'"+user.getUd()+"', " +
                "'"+user.getUc()+"', " +
                "'"+user.getUc()+"', " +
                "'"+user.getAccountType()+"', " +
                "'"+user.getCredits()+"', " +
                "'"+user.getAccessToken()+"', " +
                "'"+user.getTokenType()+"', " +
                "'"+user.getExpiresAt()+"', " +
                "'"+user.getLoginAut()+"');";

        write.execSQL(sql);
        Log.i("DB_USER", "User added");

        return true;
    }

    @Override
    public boolean update(User user) {

        /*
        Name, user name, business name, passqord, fv, ud, uc, uv, credits, token, token type,
        expiration date, loginAut
         */
        String[][] args = new String[14][2];
        args[0][0] = "name";
        args[1][0] = "email";
        args[2][0] = "businessName";
        args[3][0] = "password";
        args[4][0] = "fv";
        args[5][0] = "ud";
        args[6][0] = "uc";
        args[7][0] = "uv";
        args[8][0] = "accountType";
        args[9][0] = "credits";
        args[10][0] = "accessToken";
        args[11][0] = "tokenType";
        args[12][0] = "expiresAt";
        args[13][0] = "loginAut";

        //Verifica se há nome
        try{
            args[0][1] = user.getName();
        } catch (Exception e) {
            Log.e("Table update", "No name to be updated, "+e.getMessage());
        }

        //Verifica se há nome de usuário
        try{
            args[1][1] = user.getEmail();
        } catch (Exception e) {
            Log.e("Table update","No user name to be updated, "+e.getMessage());
        }

        //Verifica se há nome da empresa
        try{
            args[2][1] = user.getBusinessName();
        } catch (Exception e) {
            Log.e("Table update","No business name to be updated, "+e.getMessage());
        }

        //Verifica se há senha
        try{
            args[3][1] = user.getPassword();
        } catch (Exception e) {
            Log.e("Table update","No password to be updated, "+e.getMessage());
        }

        //Verifica se há fórmula de volume
        try{
            args[4][1] = user.getFv();
        } catch (Exception e) {
            Log.e("Table update","No volume formula to be updated, "+e.getMessage());
        }

        //Verifica se há unidade de diâmetro
        try{
            args[5][1] = user.getUd();
        } catch (Exception e) {
            Log.e("Table update","No diameter unit to be updated, "+e.getMessage());
        }

        //Verifica se há unidade de comprimento
        try{
            args[6][1] = user.getUc();
        } catch (Exception e) {
            Log.e("Table update","No length unit to be updated, "+e.getMessage());
        }

        //Verifica se há unidade de volume
        try{
            args[7][1] = user.getUv();
        } catch (Exception e) {
            Log.e("Table update","No volume unit to be updated, "+e.getMessage());
        }

        //Verifica o tipo de conta
        try{
            args[8][1] = user.getAccountType();
        } catch (Exception e) {
            Log.e("Table update","No account type to update, "+e.getMessage());
        }

        //Verifica se há créditos
        try{
            args[9][1] = user.getCredits();
        } catch (Exception e) {
            Log.e("Table update","No credits to be updated, "+e.getMessage());
        }

        //Verifica se há token
        try{
            args[10][1] = user.getAccessToken();
        } catch (Exception e) {
            Log.e("Table update","No token to be updated, "+e.getMessage());
        }

        //Verifica se há o tipo do token
        try{
            args[11][1] = user.getTokenType();
        } catch (Exception e) {
            Log.e("Table update","No token type to be updated, "+e.getMessage());
        }

        //Verifica se há data de validade do token
        try{
            args[12][1] = user.getExpiresAt();
        } catch (Exception e) {
            Log.e("Table update","No token expiration date to be updated, "+e.getMessage());
        }

        //Verifica se há login automático definido
        try{
            args[13][1] = user.getLoginAut();
        } catch (Exception e) {
            Log.e("Table update","No login aut to be updated, "+e.getMessage());
        }

        //Atualiza os campos informados
        for (int i = 0; i < 14; i++){
            if (null != args[i][1]){
                String sql = "UPDATE "+DbHelper.TABELA_USUARIO+
                        " SET "+args[i][0]+" = '"+args[i][1]+
                        "' WHERE uuid = '"+user.getUuid()+"';";
                write.execSQL(sql);
            } else Log.e("User update","Column "+args[i][0]+" is empty");
        }

        return true;
    }

    @Override
    public List<User> get() {

        List<User> userList = new ArrayList<>();

        String sql = "SELECT * FROM " + DbHelper.TABELA_USUARIO + " ;";
        Cursor c = read.rawQuery(sql, null);

        String uuid = "",
                name = "",
                email = "",
                businessName = "",
                password = "",
                fv = "",
                ud = "",
                uc = "",
                uv = "",
                accountType = "",
                credits = "",
                accessToken = "",
                tokenType = "",
                expiresAt = "",
                loginAut = "";

        if (c.moveToFirst()){
            do {
                uuid = c.getString(c.getColumnIndex("uuid"));
                name = c.getString(c.getColumnIndex("name"));
                email = c.getString(c.getColumnIndex("email"));
                businessName = c.getString(c.getColumnIndex("businessName"));
                password = c.getString(c.getColumnIndex("password"));
                fv = c.getString(c.getColumnIndex("fv"));
                ud = c.getString(c.getColumnIndex("ud"));
                uc = c.getString(c.getColumnIndex("uc"));
                uv = c.getString(c.getColumnIndex("uv"));
                accountType = c.getString(c.getColumnIndex("accountType"));
                credits = c.getString(c.getColumnIndex("credits"));
                accessToken = c.getString(c.getColumnIndex("accessToken"));
                tokenType = c.getString(c.getColumnIndex("tokenType"));
                expiresAt = c.getString(c.getColumnIndex("expiresAt"));
                loginAut = c.getString(c.getColumnIndex("loginAut"));
            }while (c.moveToNext());
        }

        c.close();

        User userItems = new User();
        userItems.setUuid(uuid);
        userItems.setName(name);
        userItems.setEmail(email);
        userItems.setBusinessName(businessName);
        userItems.setPassword(password);
        userItems.setFv(fv);
        userItems.setUd(ud);
        userItems.setUc(uc);
        userItems.setUv(uv);
        userItems.setAccountType(accountType);
        userItems.setCredits(credits);
        userItems.setAccessToken(accessToken);
        userItems.setTokenType(tokenType);
        userItems.setExpiresAt(expiresAt);
        userItems.setLoginAut(loginAut);

        userList.add(userItems);

        return userList;
    }

}
