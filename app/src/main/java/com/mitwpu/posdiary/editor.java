package com.mitwpu.posdiary;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class editor extends AppCompatActivity
{

    TextView txtview;
    String selecteddateforDB;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        txtview=findViewById(R.id.selectdate);

        setdate();
        txtview.setOnClickListener(v-> selectdate());

    }


    private void setdate()
    {
        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat dateformt=new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
        String todaydate=dateformt.format(calendar.getTime());

        txtview.setText(todaydate);
        selecteddateforDB=todaydate;
    }




    private void selectdate()
    {
        final Calendar c=Calendar.getInstance();
        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH);
        int day=c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(editor.this,
                (view, selectedYear, selectedMonth, selectedDayOfMonth) -> {
                    // Set the selected date to the TextView in "day month year" format
                    Calendar selectedDate = Calendar.getInstance();
                    selectedDate.set(selectedYear, selectedMonth, selectedDayOfMonth);

                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
                    String dateString = dateFormat.format(selectedDate.getTime());
                    txtview.setText(dateString);

                    selecteddateforDB=dateString;
                }, year, month, day);

        datePickerDialog.show();
    }
}