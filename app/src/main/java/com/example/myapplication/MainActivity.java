
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Declararea componentelor interfeței grafice
    Button ButonAutentificare;
    EditText CampUtilizator, CampParola;
    TextView NumarIncercari;

    // Declararea variabilelor pentru datele de autentificare
    String utilizator, parola;

    // Numărul inițial de încercări disponibile
    Integer contor = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asocierea variabilelor cu elementele din fișierul XML
        ButonAutentificare = findViewById(R.id.butonAutentificare);
        CampUtilizator = findViewById(R.id.campUtilizator);
        CampParola = findViewById(R.id.campParola);
        NumarIncercari = findViewById(R.id.textNumarIncercari);

        // Afișarea numărului inițial de încercări
        NumarIncercari.setText(Integer.toString(contor));

        // Stabilirea acțiunii la apăsarea butonului de autentificare
        ButonAutentificare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Preluarea datelor introduse de utilizator
                utilizator = CampUtilizator.getText().toString().trim();
                parola = CampParola.getText().toString().trim();

                // Verificarea numelui de utilizator și a parolei
                if (utilizator.equals("admin") && parola.equals("admin")) {

                    // Afișarea mesajului pentru autentificare reușită
                    Toast.makeText(getBaseContext(),"Autentificare reușită!",Toast.LENGTH_SHORT).show();

                } else {

                    // Scăderea numărului de încercări disponibile
                    contor--;

                    // Verificarea dacă toate încercările au fost epuizate
                    if (contor == 0) {

                        // Dezactivarea butonului de autentificare
                        ButonAutentificare.setEnabled(false);

                        // Menținerea numărului de încercări la zero
                        contor = 0;

                        // Afișarea mesajului de epuizare a încercărilor
                        Toast.makeText(getBaseContext(),"Ați epuizat toate încercările!",Toast.LENGTH_SHORT).show();

                        // Actualizarea numărului de încercări afișat
                        NumarIncercari.setText(Integer.toString(contor));

                    } else {

                        // Actualizarea numărului de încercări rămase
                        NumarIncercari.setText(Integer.toString(contor));

                        // Afișarea mesajului pentru date incorecte
                        Toast.makeText(getBaseContext(),"Eroare! Utilizator sau parolă incorectă!",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
