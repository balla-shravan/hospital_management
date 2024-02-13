package com.example.myproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
       String qry="create table users(username text,email text,password text)";
       sqLiteDatabase.execSQL(qry);
       String qry1="create table cart(username text,product text,price float,otype text)";
       sqLiteDatabase.execSQL(qry1);
        String qry2="create table orderplace(username text)";
        sqLiteDatabase.execSQL(qry2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void register(String username,String email,String password)
    {
        ContentValues cv=new ContentValues();
        cv.put("username",username);
        cv.put("email",email);
        cv.put("password",password);
        SQLiteDatabase db=getWritableDatabase();
        db.insert("users",null,cv);
        db.close();
    }
    public int login(String username,String password)
    {
        int res=0;
        String str[]=new String[2];
        str[0]=username;
        str[1]=password;
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from users where username=? and password=?",str);
        if(cursor.moveToFirst())
        {
            res=1;
        }
        return res;
    }
    public void addcart(String username,String product,float price,String otype)
    {
        ContentValues cv=new ContentValues();
        cv.put("username",username);
        cv.put("product",product);
        cv.put("price",price);
        cv.put("otype",otype);
        SQLiteDatabase db=getWritableDatabase();
        db.insert("cart",null,cv);
        db.close();
    }
    public int checkCart(String username,String product)
    {
        int res=0;
        String str[]=new String[2];
        str[0]=username;
        str[1]=product;
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor=db.rawQuery("select * from cart where username=? and product=?",str);
        if(cursor.moveToFirst())
        {
            res=1;
        }
        db.close();
        return res;
    }
    public void removecart(String username,String otype)
    {
        String str[]=new String[2];
        str[0]=username;
        str[1]=otype;
        SQLiteDatabase db=getReadableDatabase();
        db.delete("cart","username=? and otype=?",str);
        db.close();
    }
    public void addorder(String username,String fullname,String address,String contact,int pincode)
    {
        ContentValues c=new ContentValues();
        c.put("username",username);
        c.put("fullname",fullname);
        c.put("address",address);
        c.put("contact",contact);
        c.put("pincode",pincode);
        SQLiteDatabase db=getWritableDatabase();
        db.insert("orderplaced",null,c);
        db.close();
    }
    public ArrayList getOrderData(String username) {
        ArrayList<String> arr = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String str[] = new String[1];
        str[0] = username;
        Cursor c = db.rawQuery("select * from orderplaced where username=? ", str);
        if (c.moveToFirst()) {
            do{
                arr.add(c.getString(1)+"$"+c.getString(2)+"$"+c.getString(3)+"$"+c.getString(4)+"$"+c.getString(5)+"$"+c.getString(6)+"$"+c.getString(7));
            }while(c.moveToNext());
        }
        db.close();
        return arr;
    }
}
