    package com.example.c0771910_w2020_mad3125_fp.ui;

    import androidx.appcompat.app.ActionBar;
    import androidx.appcompat.app.AppCompatActivity;

    import android.app.DatePickerDialog;
    import android.content.Intent;
    import android.graphics.Color;
    import android.graphics.Typeface;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.AdapterView;
    import android.widget.ArrayAdapter;
    import android.widget.DatePicker;
    import android.widget.Spinner;
    import android.widget.TextView;

    import com.example.c0771910_w2020_mad3125_fp.R;
    import com.example.c0771910_w2020_mad3125_fp.model.Customer;
    import com.example.c0771910_w2020_mad3125_fp.model.Hydro;
    import com.example.c0771910_w2020_mad3125_fp.model.Internet;
    import com.example.c0771910_w2020_mad3125_fp.model.Mobile;
    import com.example.c0771910_w2020_mad3125_fp.util.DataManager;
    import com.example.c0771910_w2020_mad3125_fp.util.StringExtension;
    import com.google.android.material.floatingactionbutton.FloatingActionButton;

    import java.text.SimpleDateFormat;
    import java.util.ArrayList;
    import java.util.Calendar;
    import java.util.HashMap;
    import java.util.Locale;


    public class addBillActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


        private TextView billID;
        private TextView billDate;
        private TextView unitsUsed;
        private TextView agencyName;
        private TextView minutesUsed;
        private TextView manufacturerName;
        private TextView planName;
        private Spinner spbillType;
        private TextView mobilenumber;
        private TextView dataused;
        private TextView billAmount;
        private FloatingActionButton fab;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_add_bill);
            ActionBar mActionBar = getSupportActionBar();
            mActionBar.setTitle("Add Bill");

            fab = findViewById(R.id.fab);
            billID = findViewById(R.id.BillIDTextInputEditText);
            billDate = findViewById(R.id.BillDateTextInputEditText);
            unitsUsed = findViewById(R.id.enterunitsusedInputEditText);
             agencyName = findViewById(R.id.enteragencynameInputEditText);
             minutesUsed = findViewById(R.id.enterminutesusedInputEditText);
             manufacturerName = findViewById(R.id.entermanufacturernameInputEditText);
             planName = findViewById(R.id.enteryourplannameInputEditText);
            mobilenumber = findViewById(R.id.mobilenumberInputEditText);
            dataused = findViewById(R.id.datausedInputEditText);
            spbillType = findViewById(R.id.spinnertype);
            billAmount = findViewById(R.id.billAmountInputEditText);



            ArrayList<String> billType = new ArrayList<>();
            billType.add("MOBILE");
            billType.add("HYDRO");
            billType.add("INTERNET");

            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, billType);

            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spbillType.setAdapter(dataAdapter);

            spbillType.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);


            final Calendar myCalendar = Calendar.getInstance();
            String myFormat = "MM/dd/yy"; //In which you need put here
            SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
            final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear,
                                      int dayOfMonth) {
                    // TODO Auto-generated method stub
                    myCalendar.set(Calendar.YEAR, year);
                    myCalendar.set(Calendar.MONTH, monthOfYear);
                    myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    String myFormat = "MM/dd/yy"; //In which you need put here
                    SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                    billDate.setText(sdf.format(myCalendar.getTime()));
                    billDate.setTextColor(Color.BLACK);

                }

            };

            billDate.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    new DatePickerDialog(addBillActivity.this, date, myCalendar
                            .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                            myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                }

            });




        }


        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
            ((TextView) parent.getChildAt(0)).setTextSize(18);
            ((TextView) parent.getChildAt(0)).setTypeface(null, Typeface.BOLD);

            if(position == 0)
            {
                initFields();
                clearfields();
                unitsUsed.setVisibility(View.INVISIBLE);
                agencyName.setVisibility(View.INVISIBLE);
                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent mIntent = getIntent();
                        Customer customerObj = mIntent.getParcelableExtra("CustomerOBJ");

                        if(billID.getText().toString().matches(""))
                        {
                            billID.setError("please enter bill Id");
                        }else if(billDate.getText().toString().matches(""))
                        {
                            billDate.setError("please enter bill date");

                        } else if(billAmount.getText().toString().matches(""))
                        {
                            billAmount.setError("please enter bill amount");

                        }
                        else if(manufacturerName.getText().toString().matches(""))
                        {
                            manufacturerName.setError("please enter manufacturer name");

                        }
                        else if(mobilenumber.getText().toString().matches(""))
                        {
                            mobilenumber.setError("please enter mobile number");

                        }else if(dataused.getText().toString().matches(""))
                        {
                            dataused.setError("please enter data used");

                        }else if(minutesUsed.getText().toString().matches(""))
                        {
                            minutesUsed.setError("please enter minutes used");

                        }
                        else if(StringExtension.mobileValidation(mobilenumber.getText().toString()) == true) {

                            Mobile tempmobile = new Mobile(billID.getText().toString(), billDate.getText().toString(), spbillType.getSelectedItem().toString(), Double.parseDouble(billAmount.getText().toString()), manufacturerName.getText().toString(), mobilenumber.getText().toString(), planName.getText().toString(), Integer.parseInt(dataused.getText().toString()), Integer.parseInt(minutesUsed.getText().toString()));

                            customerObj.addBill(tempmobile.getBillId(), tempmobile);

                            Intent intent3 = new Intent(addBillActivity.this, detailsDisplayActivity.class);

                            intent3.putExtra("CustomerOBJ", customerObj);

                            startActivity(intent3);
                        }else {
                            mobilenumber.setError("Invalid mobile number!");
                        }




                    }
                });
            }

            if(position == 1)
            {
                hidefields();
                clearfields();
                unitsUsed.setVisibility(View.VISIBLE);
                agencyName.setVisibility(View.VISIBLE);
                agencyName.setHint("ENTER AGENCY NAME");
                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        if(billID.getText().toString().matches(""))
                        {
                            billID.setError("please enter bill Id");
                        }else if(billDate.getText().toString().matches(""))
                        {
                            billDate.setError("please enter bill date");

                        } else if(billAmount.getText().toString().matches(""))
                        {
                            billAmount.setError("please enter bill amount");

                        }else if(agencyName.getText().toString().matches(""))
                        {
                            agencyName.setError("please enter agency name:");

                        }else if(unitsUsed.getText().toString().matches(""))
                        {
                            unitsUsed.setError("please enter agency name:");

                        }else {
                            Intent hIntent = getIntent();
                            Customer customerObj = hIntent.getParcelableExtra("CustomerOBJ");

                            Hydro tempHydro = new Hydro(billID.getText().toString(), billDate.getText().toString(), "HYDRO", Double.parseDouble(billAmount.getText().toString()), agencyName.getText().toString(), Integer.parseInt(unitsUsed.getText().toString()));
                            customerObj.addBill(tempHydro.getBillId(), tempHydro);
                            Intent intent3 = new Intent(addBillActivity.this, detailsDisplayActivity.class);
                            intent3.putExtra("CustomerOBJ", customerObj);
                            startActivity(intent3);
                        }










                    }
                });
            }

            if(position == 2)
            {
               hidefields();
                clearfields();
                dataused.setVisibility(View.VISIBLE);
                unitsUsed.setVisibility(View.INVISIBLE);
                agencyName.setVisibility(View.VISIBLE);
                agencyName.setHint("ENTER PROVIDER NAME");
                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        if(billID.getText().toString().matches(""))
                        {
                            billID.setError("please enter bill Id");
                        }else if(billDate.getText().toString().matches(""))
                        {
                            billDate.setError("please enter bill date");

                        } else if(billAmount.getText().toString().matches(""))
                        {
                            billAmount.setError("please enter bill amount");

                        }else if(agencyName.getText().toString().matches(""))
                        {
                            agencyName.setError("please enter provider name");

                        }else if(dataused.getText().toString().matches(""))
                        {
                            dataused.setError("please enter provider name");

                        } else {

                            Intent hIntent = getIntent();
                            Customer customerObj = hIntent.getParcelableExtra("CustomerOBJ");

                            Internet tempInternet = new Internet(billID.getText().toString(), billDate.getText().toString(), spbillType.getSelectedItem().toString(), Double.parseDouble(billAmount.getText().toString()), agencyName.getText().toString(), Double.parseDouble(dataused.getText().toString()));
                            customerObj.addBill(tempInternet.getBillId(), tempInternet);
                            Intent intent3 = new Intent(addBillActivity.this, detailsDisplayActivity.class);

                            intent3.putExtra("CustomerOBJ", customerObj);

                            startActivity(intent3);

                        }




                    }
                });
            }
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }

        public void initFields()
        {
            minutesUsed.setVisibility(View.VISIBLE);
            mobilenumber.setVisibility(View.VISIBLE);
            dataused.setVisibility(View.VISIBLE);
          minutesUsed.setVisibility(View.VISIBLE);
            planName.setVisibility(View.VISIBLE);
            manufacturerName.setVisibility(View.VISIBLE);
        }
        public void hidefields()
        {
            minutesUsed.setVisibility(View.INVISIBLE);
            mobilenumber.setVisibility(View.INVISIBLE);
            dataused.setVisibility(View.INVISIBLE);
           minutesUsed.setVisibility(View.INVISIBLE);
            planName.setVisibility(View.INVISIBLE);
            manufacturerName.setVisibility(View.INVISIBLE);
        }

        public void clearfields()
        {
            mobilenumber.setText("");
            dataused.setText("");
            minutesUsed.setText("");
            planName.setText("");
            manufacturerName.setText("");
            billDate.setText("");
            billID.setText("");
            agencyName.setText("");
            dataused.setText("");
            unitsUsed.setText("");
        }
    }
