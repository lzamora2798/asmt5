package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
public class MainActivity extends AppCompatActivity {

    DatabaseReference db_reference;
    int cantidad;
    TextView value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        value= (TextView) findViewById(R.id.valor);
        db_reference = FirebaseDatabase.getInstance().getReference().child("Registros");
        leerRegistros();


    }
    private void leerRegistros() {
        db_reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                // mostrarRegistrosPorPantalla(snapshot); }
                cantidad+=1;
                mostrarRegistrosPorPantalla();
            }
            @Override
            public void onCancelled(DatabaseError error) {
                System.out.println(error.toException());
            }
        });

    }
    public void mostrarRegistrosPorPantalla(){
        LinearLayout contTemp = (LinearLayout) findViewById(R.id.ContenedorTemp);
        LinearLayout contAxis = (LinearLayout) findViewById(R.id.ContenedorAxis);
        //String tempVal = String.valueOf(snapshot.child("flag").getValue());
        TextView temp = new TextView(getApplicationContext());
        value.setText(" "+cantidad);
        contTemp.addView(temp);
        TextView axis = new TextView(getApplicationContext());
        contAxis.addView(axis);
    }
}
