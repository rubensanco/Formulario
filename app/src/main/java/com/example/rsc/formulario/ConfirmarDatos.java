package com.example.rsc.formulario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {
    private Contacto contacto;
    private TextView tvNombre;
    private TextView tvFecha;
    private TextView tvTelefono;
    private TextView tvCorreo;
    private TextView tvDescripcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);
        contacto = new Contacto();
        extraeDatos();
        tvNombre = (TextView)findViewById(R.id.tvNombre);
        tvNombre.setText(contacto.getNombre());
        tvFecha = (TextView) findViewById(R.id.tvSpinFecNac);
        tvFecha.setText(contacto.fechaToString());
        tvTelefono = (TextView) findViewById(R.id.tvNumTel);
        tvTelefono.setText(contacto.getTelefono());
        tvCorreo = (TextView) findViewById(R.id.tvCorreo2);
        tvCorreo.setText(contacto.getCorreo());
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion2);
        tvDescripcion.setText(contacto.getDescripción());
        Button btnEditar = (Button) findViewById(R.id.btnEditar);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editarDatos();
            }
        });

    }
    public void editarDatos(){
        Intent intent = new Intent(ConfirmarDatos.this,MainActivity.class);
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

    public Contacto extraeDatos(){
        Bundle parametros = getIntent().getExtras();
        contacto.setNombre(parametros.getString("Nombre"));
        contacto.setAnio(parametros.getInt("Anio"));
        contacto.setMes(parametros.getInt("Mes"));
        contacto.setDia(parametros.getInt("Dia"));
        contacto.setTelefono(parametros.getString("Telefono"));
        contacto.setCorreo(parametros.getString("Correo"));
        contacto.setDescripción(parametros.getString("Descripcion"));
        return contacto;
    }
}
