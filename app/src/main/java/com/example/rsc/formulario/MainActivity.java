package com.example.rsc.formulario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre;
    private DatePicker dpFecha;
    private EditText etTelefono;
    private EditText etCorreo;
    private EditText etDescripcion;
    Contacto contacto = new Contacto();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                siguiente();
            }
        });
        etNombre = (EditText) findViewById(R.id.etNombre);
        dpFecha = (DatePicker) findViewById(R.id.dpFecha);
        Date dt = new Date();
        dpFecha.setMaxDate(dt.getTime());
        etTelefono = (EditText) findViewById(R.id.etTelefono);
        etCorreo = (EditText) findViewById(R.id.etCorreo);
        etDescripcion =(EditText) findViewById(R.id.etDescripcion);
        extraeDatos();
        etNombre.setText(contacto.getNombre());
        if (contacto.getAnio()>0){
            dpFecha.updateDate(contacto.getAnio(), contacto.getMes(), contacto.getDia());
        }
        etTelefono.setText(contacto.getTelefono());
        etCorreo.setText(contacto.getCorreo());
        etDescripcion.setText(contacto.getDescripción());

    }
    public void siguiente(){
        Date dt2 = new Date();

        Intent intent = new Intent(MainActivity.this,ConfirmarDatos.class);
        contacto.setNombre(etNombre.getText().toString());
        contacto.setAnio(dpFecha.getYear());
        contacto.setMes(dpFecha.getMonth() + 1);
        contacto.setDia(dpFecha.getDayOfMonth());
        contacto.setTelefono(etTelefono.getText().toString());
        contacto.setCorreo(etCorreo.getText().toString());
        contacto.setDescripción(etDescripcion.getText().toString());
        intent.putExtra("Nombre", contacto.getNombre());
        intent.putExtra("Anio", contacto.getAnio());
        intent.putExtra("Mes", contacto.getMes());
        intent.putExtra("Dia", contacto.getDia());
        intent.putExtra("Telefono", contacto.getTelefono());
        intent.putExtra("Correo",contacto.getCorreo());
        intent.putExtra("Descripcion",contacto.getDescripción());


        startActivity(intent);
        finish();
    }
    public Contacto extraeDatos() {
        try {
            Bundle parametros = getIntent().getExtras();
            contacto.setNombre(parametros.getString("Nombre"));
            contacto.setAnio(parametros.getInt("Anio"));
            contacto.setMes(parametros.getInt("Mes"));
            contacto.setDia(parametros.getInt("Dia"));
            contacto.setTelefono(parametros.getString("Telefono"));
            contacto.setCorreo(parametros.getString("Correo"));
            contacto.setDescripción(parametros.getString("Descripcion"));
        } catch (Exception e) {

        }
        return contacto;
    }
}
