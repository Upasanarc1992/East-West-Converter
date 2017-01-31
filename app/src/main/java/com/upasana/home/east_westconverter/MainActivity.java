package com.upasana.home.east_westconverter;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnItemSelectedListener ,View.OnClickListener,EditText.OnEditorActionListener {

    Spinner spinner, sub_spinner;
    int change, pos,pos2;
    EditText edit;
    TextView tv, tv1;
    LinearLayout l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#0d70d2"));
        }

        setContentView(R.layout.activity_main);

        change = 0;
        pos = 0;
        pos2=0;

        l=(LinearLayout) findViewById(R.id.ll);
        tv = (TextView) findViewById(R.id.tv1);
        tv1 = (TextView) findViewById(R.id.tv2);
        edit = (EditText) findViewById(R.id.edit);
        sub_spinner = (Spinner) findViewById(R.id.spinner2);
        spinner = (Spinner) findViewById(R.id.spinner);


        spinner.setOnItemSelectedListener(this);
        sub_spinner.setOnItemSelectedListener(this);
        spinner.setOnItemSelectedListener(this);
        edit.setOnEditorActionListener(this);
        l.setOnClickListener(this);

        addItemsOnSpinner(spinner, 0);




    }


    //add items into spinner1 dynamically
    public void addItemsOnSpinner(Spinner s, int n) {

        ArrayList<String> list = new ArrayList<String>();

        String[] arr = arrayinit(n);
        for (int i = 0; i < arr.length; i++)
            list.add(arr[i]);


        ArrayAdapter<String> dataAdapter =
                new ArrayAdapter<String>
                        (this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(dataAdapter);
    }


    //items for spinner2
    public String[] arrayinit(int n) {

        switch (n) {
            case 0: {
                String[] arr2 = {"Area", "Length", "Volume / Capacity", "Weight / Mass"};
                change = 4;
                return arr2;
            }
            case 1: {
                String[] arr2 = {"sq inch", "sq foot", "sq yard", "acre", "sq mile", "sq centimetre", "sq metre", "hectare", "sq killometere"};
                change = 4;
                return arr2;
            }
            case 2: {
                String[] arr2 = {"inch", "foot", "yard", "(statute) mile", "(nautical) mile", "micrometre", "millimetre", "centimetre", "decimetre", "meter", "decametre", "hectrmetre", "kilometere"};
                change = 4;
                return arr2;
            }
            case 3: {
                String[] arr2 = {"ounce", "gill", "pint", "gallon", "peck", "bushel", "quart", "millilitre ", "centilitre", "decilitre", "litre", "deca litre", "hecto litre"};
                change = 6;
                return arr2;
            }
            case 4: {
                String[] arr2 = {"grain", "dram", "ounce", "pound", "stone", "hundredweight", "ton", "milligram", "centigram", "decigram", "gram", "decagram", "hectagram", "kilogram", "tonne"};
                change = 6;
                return arr2;
            }
            default:
                String[] arr = {};
                return null;
        }

    }

    //items for conversion
    public double[][] conv_value(int n) {

        switch (n) {
            case 0: {
                double[][] arr2 = {{0.155, 0.00107639, 0.000119599, 0.000000024711, 0.00000000003861},
                        {1550, 10.7639, 1.19599, 0.000247105, 0.0000003861},
                        {15500000, 107639, 11959.9, 2.47105, 0.00386102},
                        {1550000000, 10760000, 1196000, 247.105, 0.386102}};

                return arr2;
            }
            case 1: {
                double[][] arr2 = {{0.000039370076, 0.0000032808398, 0.0000010936133, 0.0000000006213712, 0.0000000005399568},
                        {0.039370076, 0.0032808398, 0.0010936133, 0.0000006213712, 0.00000053995683},
                        {0.39370076, 0.032808398, 0.010936133, 0.000006213712, 0.000003995677},
                        {3.9370076, 0.32808398, 0.10936133, 0.00006213712, 0.00003995677},
                        {39.370076, 3.2808398, 1.0936133, 0.00062137126, 0.00053995685},
                        {393.70076, 32.808398, 10.936133, 0.006213712, 0.0053995677},
                        {3937.0076, 328.08398, 109.36133, 0.06213712, 0.053995677},
                        {39370.08, 3280.8398, 1093.6133, 0.621371, 0.539957}};

                return arr2;
            }

            case 2: {
                double[][] arr2 = {{0.033814, 0.00704, 0.00175975, 0.00011, 0.00011351, 0.00002749615, 0.000879877},
                        {0.35, 0.0703902, 0.0175975, 0.00219969, 0.0011, 0.0002749615, 0.00879877},
                        {3.51951, 0.703902, 0.175975, 0.0219969, 0.0109985, 0.00274965, 0.0879877},
                        {35.20, 7.03902, 1.75975, 0.219969, 0.11, 0.0274965, 0.879877},
                        {351.951, 70.3902, 17.5975, 2.19969, 1.1, 0.275, 8.79877},
                        {3519.508, 703.902, 175.975, 21.9969, 10.998, 2.75, 87.9877}};


                return arr2;
            }

            case 3: {
                double[][] arr2 = {{64.7989, 1771.85, 28349.5, 453592.000004704, 6350288.0000658556819, 50800000, 1016000000},
                        {6.479891, 177.185, 2834.95, 45359.2000004704, 635028.80000658556819, 5080000, 101600000},
                        {0.6479891, 17.7185, 283.495, 4535.92000004704, 63502.880000658556819, 508000, 10160000},
                        {0.06479891, 1.77185, 28.3495, 453.592000004704, 6350.2880000658556819, 50800, 1016000},
                        {0.006479891, 0.177185, 2.83495, 45.3592000004704, 635.02880000658556819, 5080, 101600},
                        {0.0006479891, 0.0177185, 0.283495, 4.53592000004704, 63.502880000658556819, 508, 10160},
                        {0.00006479891, 0.00177185, 0.0283495, 0.453592000004704, 6.3502880000658556819, 50.8, 1016},
                        {0.00000006479891, 0.00000177185, 0.0000283495, 0.000453592000004704, 0.0063502880000658556819, 0.0508, 1.016}};

                for (int i = 0; i < 8; i++)
                    for (int j = 0; j < 7; j++)
                        arr2[i][j] = 1 / arr2[i][j];
                return arr2;
            }

            default:
                return null;
        }

    }

    //for actual conversiion
    public void conv(int n) {
        String s = "", s1 = "";
        String[] a = arrayinit(pos + 1);
        double[][] val;
        double[] d = new double[30];
        val = conv_value(pos);

        DecimalFormat dec = new DecimalFormat("#####.#####E0");

        if (n > change) {
            for (int i = 0; i <= change; i++) {

                d[i] = Double.parseDouble(edit.getText().toString()) * val[n - (change + 1)][i];
                s += dec.format(d[i]) + System.getProperty("line.separator") + System.getProperty("line.separator");
                s1 += a[i] + System.getProperty("line.separator") + System.getProperty("line.separator");
            }
        } else {

            for (int i = 0; i < a.length - change - 1; i++) {

                d[i] = Double.parseDouble(edit.getText().toString()) / val[i][n];
                s += dec.format(d[i]) + System.getProperty("line.separator") + System.getProperty("line.separator");
                s1 += a[(change + i) + 1] + System.getProperty("line.separator") + System.getProperty("line.separator");

            }
        }
        tv.setText(s);
        tv1.setText(s1);

    }

    public void onItemSelected(AdapterView<?> parent, View arg1, int position, long arg3) {
        Spinner sp = (Spinner) parent;
        hide();
        if (sp.getId() == R.id.spinner) {
            pos = spinner.getSelectedItemPosition();
            addItemsOnSpinner(sub_spinner, pos + 1);
        }
        if (sp.getId() == R.id.spinner2) {

            if (!(edit.getText().toString().trim().equals(""))) {
                pos2=position;
                conv(position);

            }

        }

    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
        hide();
    }

    @Override
    public void onClick(View v){
            hide();
    }
    @Override

    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE) {
            hide();
            if (!(edit.getText().toString().trim().equals("")))
            conv(pos2);

        }
        return false;
    }

    public void hide() {
        InputMethodManager imm = (InputMethodManager) getSystemService(
                INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

    }
}
