package com.ayroot.calculator;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
/*import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;*/
import android.widget.GridLayout;
//import android.widget.GridView;
import android.widget.TextView;
import android.os.Bundle;

import static com.ayroot.calculator.R.id.div;
import static com.ayroot.calculator.R.id.mlp;
import static com.ayroot.calculator.R.id.num;
import static com.ayroot.calculator.R.id.operation;
import static com.ayroot.calculator.R.id.p1;
import static com.ayroot.calculator.R.id.p2;
import static com.ayroot.calculator.R.id.res;
import static com.ayroot.calculator.R.id.sub;
import static com.ayroot.calculator.R.string.C;
import static com.ayroot.calculator.R.string.result;
import static com.ayroot.calculator.R.string.sum;

public class MainActivity extends AppCompatActivity //implements AdapterView.OnItemSelectedListener
{
    private TextView p1;
    private TextView p2;
    int n1=0, n2=0;
    double results=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*final GridView g = (GridView) findViewById(R.id.gridView);
        num = new DataAdapter(getApplicationContext(),
                android.R.layout.simple_list_item_1);
        g.setAdapter(num);
        g.setOnItemSelectedListener(this);
        g.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                calc.setText(num.getItem(position));
            }
        });*/
        p1 = (TextView) findViewById(R.id.p1);
        p2 = (TextView) findViewById(R.id.p2);
        GridLayout number = (GridLayout) findViewById(R.id.num);
        GridLayout operation = (GridLayout) findViewById(R.id.operation);
        for (int i = 0; i < operation.getChildCount(); i++){
            View view1 = operation.getChildAt(i);
            View view2 = number.getChildAt(i);
            view1.setOnClickListener(clickListener);
            view2.setOnClickListener(clickListener);
        }

    }

    private View.OnClickListener clickListener= new View.OnClickListener() {
        @Override
        public void onClick(View v){
            p2.setText(v.getTag().toString());
            if (Integer.parseInt(String.valueOf(p2)) == operation){
                p1.setText(p2.getText());
                n1 = Integer.parseInt(String.valueOf(p1));
                p2.setText(n2);
                n2 = Integer.parseInt(p2.getText().toString())*10;
            }else {
                n1 = Integer.parseInt(p2.getText().toString())*10;
            }
            switch (v.getId()){
                case C:
                    p2.setText("0");
                    p1.setText(" ");
                case  res:
                    switch (v.getId()){
                        case sum:
                            results = n1 + n2;
                            break;
                        case sub:
                            results = n1 - n2;
                            break;
                        case mlp:
                            results = n1 * n2;
                            break;
                        case div:
                            results = n1 / n2;
                            break;
                    }
                    break;
            }
            p1.setText(result);
        }
    };

   /* @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        calc.setText(num.getItem(position));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        calc.setText(Integer.toString(calc));
    }*/
}
