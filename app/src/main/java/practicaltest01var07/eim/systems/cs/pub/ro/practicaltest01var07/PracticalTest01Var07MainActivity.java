package practicaltest01var07.eim.systems.cs.pub.ro.practicaltest01var07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var07MainActivity extends AppCompatActivity {

    public class ButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            EditText t1 = (EditText)findViewById(R.id.n1);
            EditText t2 = (EditText)findViewById(R.id.n2);
            EditText t3 = (EditText)findViewById(R.id.n3);
            EditText t4 = (EditText)findViewById(R.id.n4);

            if (!t1.getText().toString().matches("\\d") ||
                    !t2.getText().toString().matches("\\d") ||
                    !t3.getText().toString().matches("\\d") ||
                    !t4.getText().toString().matches("\\d")
                    ) {
                Toast.makeText(PracticalTest01Var07MainActivity.this, "Not all numbersssss", Toast.LENGTH_SHORT).show();
            }
            else {
                Intent intent = new Intent(PracticalTest01Var07MainActivity.this, PracticalTest01Var07SecondaryActivity.class);
                intent.putExtra("n1", t1.getText().toString());
                intent.putExtra("n2", t2.getText().toString());
                intent.putExtra("n3", t3.getText().toString());
                intent.putExtra("n4", t4.getText().toString());
                startActivity(intent);
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_main);

        Button set = (Button)findViewById(R.id.set);
        set.setOnClickListener(new ButtonListener());

        Log.d("service", "createeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        ProcessingThread processingThread = null;
        processingThread = new ProcessingThread(this);
        processingThread.start();

        String aux;
        if (savedInstanceState != null) {

            EditText t1 = (EditText) findViewById(R.id.n1);
            EditText t2 = (EditText) findViewById(R.id.n2);
            EditText t3 = (EditText) findViewById(R.id.n3);
            EditText t4 = (EditText) findViewById(R.id.n4);

            aux = savedInstanceState.getString("n1");
            t1.setText(aux);

            aux = savedInstanceState.getString("n2");
            t2.setText(aux);

            aux = savedInstanceState.getString("n3");
            t3.setText(aux);

            aux = savedInstanceState.getString("n4");
            t4.setText(aux);
        }

        Intent intent = new Intent(this, PracticalTest01Service.class);
        startService(intent);


    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String aux;
        if (savedInstanceState == null)
            return;

        EditText t1 = (EditText)findViewById(R.id.n1);
        EditText t2 = (EditText)findViewById(R.id.n2);
        EditText t3 = (EditText)findViewById(R.id.n3);
        EditText t4 = (EditText)findViewById(R.id.n4);

        aux = savedInstanceState.getString("n1");
        t1.setText(aux);

        aux = savedInstanceState.getString("n2");
        t2.setText(aux);

        aux = savedInstanceState.getString("n3");
        t3.setText(aux);

        aux = savedInstanceState.getString("n4");
        t4.setText(aux);

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        EditText t1 = (EditText)findViewById(R.id.n1);
        EditText t2 = (EditText)findViewById(R.id.n2);
        EditText t3 = (EditText)findViewById(R.id.n3);
        EditText t4 = (EditText)findViewById(R.id.n4);

        savedInstanceState.putString("n1", t1.getText().toString());
        savedInstanceState.putString("n2", t2.getText().toString());
        savedInstanceState.putString("n3", t3.getText().toString());
        savedInstanceState.putString("n4", t4.getText().toString());

    }

    @Override
    protected void onDestroy() {
        Intent intent = new Intent(this, PracticalTest01Service.class);
        stopService(intent);
        super.onDestroy();
    }

}
