package com.example.app004;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText editTextname;
    private EditText editTextcode;
    private EditText editTextlastname;
    private EditText editTextTelefono;
    private EditText editTextEmail;

    private Button buttonInsert;
    private Button buttonBrowser;
    private Button buttonDelete;
    private Button buttonUpdate;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextcode = findViewById(R.id.editTextCodigo);
        editTextname = findViewById(R.id.editTextname);
        editTextlastname = findViewById(R.id.editTextlastname);
        editTextTelefono = findViewById(R.id.editTextPhone);
        editTextEmail = findViewById(R.id.editTextTextEmailAddress);
    }


    public void onClicButtonInsert(View view){
       DataBaseAdmin dataBaseAdmin = new DataBaseAdmin(this, "Sexto", null, 1);
       SQLiteDatabase sql = dataBaseAdmin.getWritableDatabase();

        String name = editTextname.getText().toString();
        String lastname = editTextlastname.getText().toString();
        String telefono = editTextTelefono.getPrivateImeOptions();
        String email = editTextEmail.getText().toString();

        //sql.execSQL("INSERT INTO Clients (Name, Lastname, Phone, Email)");


        ContentValues values = new ContentValues();

        values.put("Name", name);
        values.put("Lastname", lastname);
        values.put("Phone", telefono);
        values.put("Email", email);


        long count = sql.insert("Clients", null, values);
        sql.close();



        editTextname.setText("");
        editTextlastname.setText("");
        editTextTelefono.setText("");
        editTextEmail.setText("");
    }

    public void onClicButtonBrowser(View v){
        DataBaseAdmin dataAdmin= new DataBaseAdmin(this, "Sexto", null, 1);
        SQLiteDatabase sql = dataAdmin.getReadableDatabase();

        String code = editTextcode.getText().toString();

        String static SELECT = "SELECT *"+
                                "FROM Clients";

        final String SELECT = "SELECT Name, lastnama, Phone, Email "+
                "FROM Clients";
        
        Cursor cursor = sql.rawQuery();


    }

    public void onClicButtonDelete(View v){

    }

    public void onClicButtonUpdate(View v){

    }
}