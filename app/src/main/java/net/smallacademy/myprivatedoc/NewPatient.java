package net.smallacademy.myprivatedoc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class NewPatient extends AppCompatActivity  implements View.OnClickListener {
    Patient p;
    String fileName = "";
    String filePath = "";
    String getFileContent = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_patient);
        Button diagnosisBtn = findViewById(R.id.DiagnosisBtn);
        diagnosisBtn.setOnClickListener((View.OnClickListener) this);

    }

    // writeTextData() method save the data into the file in byte format
    // It also toast a message "Done/filepath_where_the_file_is_saved"
    private void writeTextData(File file, String data) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(data.getBytes());
            Toast.makeText(this, "Done" + file.getAbsolutePath(), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onClick(View v) {
        DialogLogin d = new DialogLogin();
        RadioGroup radioGroup1 = findViewById(R.id.GenderRadioGroup);
        RadioButton radioButton1;
        int radioId1 = radioGroup1.getCheckedRadioButtonId();
        radioButton1 = findViewById(radioId1);

        RadioGroup radioGroup2 = findViewById(R.id.SmokeRadioGroup);
        RadioButton radioButton2;
        int radioId2 = radioGroup2.getCheckedRadioButtonId();
        radioButton2 = findViewById(radioId2);

        RadioGroup radioGroup3 = findViewById(R.id.CommunityRadioGroup);
        RadioButton radioButton3;
        int radioId3 = radioGroup3.getCheckedRadioButtonId();
        radioButton3 = findViewById(radioId3);

        EditText WBC, NEUT, LYMPH, RBC, HCT, UREA, HB, CREATININE, IRON, HDL, ALKALINE;
        String mWBC, mNEUT, mLYMPH, mRBC, mHCT, mUREA, mHB, mCREATININE, mIRON, mHDL, mALKALINE;
        WBC = findViewById(R.id.WBC);
        NEUT = findViewById(R.id.Neut);
        LYMPH = findViewById(R.id.Lymph);
        RBC = findViewById(R.id.RBC);
        HCT = findViewById(R.id.HCT);
        UREA = findViewById(R.id.urea);
        HB = findViewById(R.id.HB);
        CREATININE = findViewById(R.id.Creatinine);
        IRON = findViewById(R.id.Iron);
        HDL = findViewById(R.id.HDL);
        ALKALINE = findViewById(R.id.Alkaline);
        ArrayList<Float> ind = new ArrayList<>();// WBC-0,NEUT-1,LYMPH-2,RBC-3,HCT-4,UREA-5,HB-6,CREATININE-7,IRON-8,HDL-9,ALKALINE-10;
        mWBC = String.valueOf(WBC.getText());
        mNEUT = String.valueOf(NEUT.getText());
        mLYMPH = String.valueOf(LYMPH.getText());
        mRBC = String.valueOf(RBC.getText());
        mHCT = String.valueOf(HCT.getText());
        mUREA = String.valueOf(UREA.getText());
        mHB = String.valueOf(HB.getText());
        mCREATININE = String.valueOf(CREATININE.getText());
        mIRON = String.valueOf(IRON.getText());
        mHDL = String.valueOf(HDL.getText());
        mALKALINE = String.valueOf(ALKALINE.getText());

        if (mWBC.equals("") || mNEUT.equals("") || mLYMPH.equals("")||mRBC.equals("") ||
                mHCT.equals("") || mUREA.equals("")||mHB.equals("") || mCREATININE.equals("") ||
                mIRON.equals("")||mHDL.equals("") || mALKALINE.equals("")) {
            d.setTitle("\nError\n");
            d.setMsg("there is a field missing\n please check you entered all indices\n");
            d.show(getSupportFragmentManager(), "");
        } else {
            ind.add(Float.parseFloat(mWBC));
            ind.add(Float.parseFloat(mNEUT));
            ind.add(Float.parseFloat(mLYMPH));
            ind.add(Float.parseFloat(mRBC));
            ind.add(Float.parseFloat(mHCT));
            ind.add(Float.parseFloat(mUREA));
            ind.add(Float.parseFloat(mHB));
            ind.add(Float.parseFloat(mCREATININE));
            ind.add(Float.parseFloat(mIRON));
            ind.add(Float.parseFloat(mHDL));
            ind.add(Float.parseFloat(mALKALINE));
            p = new Patient(findViewById(R.id.PatientFullName), findViewById(R.id.PatientID), findViewById(R.id.PatientAge), radioButton1.getText().toString(), radioButton2.getText().toString(), radioButton3.getText().toString(), ind);
            d.setMsg(p.toString());
            d.setTitle("RESULT");
            d.show(getSupportFragmentManager(), "");
            setVisible(true);
            fileName = "MyFile.txt";
            filePath = "MyFileDir";

            // Creating folder with name Patients
            File folder = getExternalFilesDir("Patients");

            // Creating file with id name
            File file = new File(folder, p.getID() + ".txt");
            String editTextData = p.getStr();

            // Storing the data in file
            writeTextData(file, editTextData);
        }
    }
}

