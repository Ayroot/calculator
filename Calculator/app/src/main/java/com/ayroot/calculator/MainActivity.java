package com.ayroot.calculator;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView calc;
    private DataAdapter num;
    private GridLayout operation;
    int n1, n2, flag;
    double results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calc = (TextView) findViewById(R.id.info);
        final GridView g = (GridView) findViewById(R.id.gridView);
        num = new DataAdapter(getApplicationContext(),
                android.R.layout.simple_list_item_1);
        g.setAdapter(num);
        g.setOnItemSelectedListener(this);
        g.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                calc.setText(num.getItem(position));
            }
        });
        operation = (GridLayout) findViewById(R.id.operation);
        for (int i = 0; i < operation.getChildCount(); i++){
            View view = operation.getChildAt(i);
            view.setOnClickListener(clickListener);
        }

    }
    private void ClickNumber(int numb, Object equals){
        if(calc.equals(operation)){
            n1 = n1*10 + numb;
            calc.setText(Integer.toString(n1));
        }else{
            n2 = n2*10 + numb;
            calc.setText(Integer.toString(n2));
        }
    }



    private View.OnClickListener clickListener= new View.OnClickListener() {
        @Override
        public void onClick(View v){
            calc.setText(v.getTag().toString());
            switch (v.getId()){
                case R.id.res:
            }
        }
    };

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
        calc.setText(num.getItem(position));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        calc.setText(Integer.toString(n1));
    }
}
