package practicaltest01var07.eim.systems.cs.pub.ro.practicaltest01var07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var07SecondaryActivity extends AppCompatActivity {

    class Calc implements Button.OnClickListener {

        @Override
        public void onClick(View v) {

            TextView n1 = (TextView)findViewById(R.id.view1);
            TextView n2 = (TextView)findViewById(R.id.view2);
            TextView n3 = (TextView)findViewById(R.id.view3);
            TextView n4 = (TextView)findViewById(R.id.view4);

            Integer i1, i2, i3, i4;
            i1 = Integer.valueOf(n1.getText().toString());
            i2 = Integer.valueOf(n2.getText().toString());
            i3 = Integer.valueOf(n3.getText().toString());
            i4 = Integer.valueOf(n4.getText().toString());

            Integer res;

            if (((Button) v).getText().toString().equals("SUM"))
                res = i1 + i2 + i3 + i4;
            else
                res = i1 * i2 * i3 * i4;

            Toast.makeText(PracticalTest01Var07SecondaryActivity.this, "Sum = " + res, Toast.LENGTH_SHORT).show();


        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_secondary);

        Intent intent = getIntent();
        TextView n1 = (TextView)findViewById(R.id.view1);
        TextView n2 = (TextView)findViewById(R.id.view2);
        TextView n3 = (TextView)findViewById(R.id.view3);
        TextView n4 = (TextView)findViewById(R.id.view4);

        n1.setText(intent.getStringExtra("n1"));
        n2.setText(intent.getStringExtra("n2"));
        n3.setText(intent.getStringExtra("n3"));
        n4.setText(intent.getStringExtra("n4"));

        Button sum = (Button)findViewById(R.id.sum);
        Button prod = (Button)findViewById(R.id.prod);
        sum.setOnClickListener(new Calc());
        prod.setOnClickListener(new Calc());


    }
}
