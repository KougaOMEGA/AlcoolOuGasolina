package dandeveloper.com.alcoolougasolina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText edtPrecoAlcool;
    private EditText edtPrecoGasolina;
    private Button btnVerificar;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPrecoAlcool = (EditText) findViewById(R.id.edtPrecoAlcoolId);
        edtPrecoGasolina = (EditText) findViewById(R.id.edtPrecoGasolinaId);
        btnVerificar = (Button) findViewById(R.id.btnVerificarId);
        tvResultado = (TextView) findViewById(R.id.tvResultadoId);

        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String textoPrecoAlcool = edtPrecoAlcool.getText().toString();
                String textoPrecoGasolina = edtPrecoGasolina.getText().toString();

                if ( textoPrecoAlcool.isEmpty() ){
                    tvResultado.setText("Digite um valor para o álcool");
                } else {
                    if (textoPrecoGasolina.isEmpty()){
                        tvResultado.setText("Digite um valor para a gasolina");
                    } else {
                        Double valorAlcool = Double.parseDouble(textoPrecoAlcool);
                        Double valorGasolina = Double.parseDouble(textoPrecoGasolina);

                        double resultado = valorAlcool / valorGasolina;


                        if ( resultado >= 0.7){
                            tvResultado.setText("É melhor utilizar Gasolina");
                        } else {
                            tvResultado.setText("É melhor utilizar Álcool");
                        }
                    }
                }


            }
        });


    }
}
