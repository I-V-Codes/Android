package ege493.sunynp.hawksnest2014;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class RADatabaseConnector 
{
   // database name
   private static final String DATABASE_NAME = "ResAssts";
      
   private SQLiteDatabase database; // for interacting with the database
   private DatabaseOpenHelper databaseOpenHelper; // creates the database

   // public constructor for DatabaseConnector
   public RADatabaseConnector(Context context) 
   {
      // create a new DatabaseOpenHelper
      databaseOpenHelper = 
         new DatabaseOpenHelper(context, DATABASE_NAME, null, 1);
   }

   // open the database connection
   public void open() throws SQLException 
   {
      // create or open a database for reading/writing
      database = databaseOpenHelper.getWritableDatabase();
   }

   // close the database connection
   public void close() 
   {
      if (database != null)
         database.close(); // close the database connection
   } 

   // inserts a new contact in the database
   public long insertContact(String name, String dorm,  
      String room, String ext) 
   {
      ContentValues newContact = new ContentValues();
      newContact.put("name", name);
      newContact.put("dorm", dorm);
      newContact.put("room", room);
      newContact.put("ext", ext);

      open(); // open the database
      long rowID = database.insert("ras", null, newContact);
      close(); // close the database
      return rowID;
   } 

   // updates an existing contact in the database
   public void updateContact(long id, String name, String dorm, 
      String room, String ext) 
   {
      ContentValues editContact = new ContentValues();
      editContact.put("name", name);
      editContact.put("dorm", dorm);
      editContact.put("room", room);
      editContact.put("ext", ext);

      open(); // open the database
      database.update("ras", editContact, "_id=" + id, null);
      close(); // close the database
   } // end method updateContact

   // return a Cursor with all contact names in the database
   public Cursor getAllContacts() 
   {
      return database.query("ras", new String[] {"_id", "name"}, 
         null, null, null, null, "name");
   } 

   // return a Cursor containing specified contact's information 
   public Cursor getOneContact(long id) 
   {
      return database.query(
         "ras", null, "_id=" + id, null, null, null, null);
   } 

   // delete the contact specified by the given String name
   public void deleteContact(long id) 
   {
      open(); // open the database
      database.delete("ras", "_id=" + id, null);
      close(); // close the database
   } 
   
   private class DatabaseOpenHelper extends SQLiteOpenHelper 
   {
      // constructor
      public DatabaseOpenHelper(Context context, String name,
         CursorFactory factory, int version) 
      {
         super(context, name, factory, version);
      }

      // creates the ras table when the database is created
      @Override
      public void onCreate(SQLiteDatabase db) 
      {
         // query to create a new table named ras
         String createQuery = "CREATE TABLE ras" +
            "(_id integer primary key autoincrement," +
            "name TEXT, dorm TEXT, " +
            "room TEXT, ext TEXT);";
                  
         db.execSQL(createQuery); // execute query to create the database
      } 

      @Override
      public void onUpgrade(SQLiteDatabase db, int oldVersion, 
          int newVersion) 
      {
      }
   } // end class DatabaseOpenHelper
} // end class DatabaseConnector