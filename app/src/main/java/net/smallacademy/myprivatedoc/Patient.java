package net.smallacademy.myprivatedoc;

import android.widget.EditText;

import java.util.ArrayList;

public class Patient
{
    private String Name;
    private long ID;
    private int Age;
    private String Gender;
    private String Smoke;
    private String Community;
    private String str;
    private int mWBC,mNEUT,mLYMPH,mRBC,mHCT,mUREA,mHB,mCREATININE,mIRON,mHDL,mALKALINE;//0- WBC,1-NEUR,2-LYMPH,3-RBC,4-HCT,5-UREA,6-HB,7-CREATININT,8-IRON,9HDL,10-ALKALINE
    private ArrayList<Float> Indices;
    private ArrayList<Disease> diseases;

    public Patient(EditText name, EditText ID, EditText age, String gender, String smoke, String community, ArrayList<Float> ind) {
        if (!String.valueOf(name.getText()).equals(""))
            Name = name.getText().toString();
        else
            Name="anonymous";
        try {
            this.ID = Long.parseLong(ID.getText().toString());
        } catch (NumberFormatException nfe) {
            this.ID=0;
        }
        try {
            Age = Integer.parseInt(age.getText().toString());
        } catch (NumberFormatException nfe) {
            this.Age=0;
        }
        Gender = gender;
        Smoke = smoke;
        Community = community;
        Indices=ind;
        str= "Patient:" + Name + "\n" + "ID:" + this.ID + "\n" + "Age:" + Age + "\n" + "Gender:" + Gender + "\n" + "Smoking:" + Smoke + "\n" + "Community:" + Community + "\n" + "Your Indice:" + "\n";
        setDiseases();
        diagnose();
    }

    private void WBC()
    {
        if (Age >=18)
        {
            if (Indices.get(0) < 4500) {
                diseases.get(10).setStatus(true);
            }
            else if (Indices.get(0) > 11000 && Indices.get(0)<=20000)
            {
                diseases.get(8).setStatus(true);
            }
            else if (Indices.get(0) > 20000) {
                diseases.get(13).setStatus(true);
                diseases.get(22).setStatus(true);
            }
        }
        else if (Age<=17 && Age>=4)
        {
            if (Indices.get(0) < 5500)
                diseases.get(10).setStatus(true);
            else if(Indices.get(0)>15500 && Indices.get(0)<=20000) {
                diseases.get(8).setStatus(true);
            }
            else if(Indices.get(0)>20000)
            {
                diseases.get(13).setStatus(true);
                diseases.get(22).setStatus(true);
            }
        }
        else if (Age>=0 && Age<=3)
        {
            if (Indices.get(0) < 6000)
                diseases.get(10).setStatus(true);
            else if(Indices.get(0)>17500 && Indices.get(0)<=20000) {
                diseases.get(8).setStatus(true);
            }
            else if(Indices.get(0)>20000)
            {
                diseases.get(13).setStatus(true);
                diseases.get(22).setStatus(true);
            }
        }
    }

    private void Neut()
    {
        if(Indices.get(1)<28)
        {
            diseases.get(4).setStatus(true);
            diseases.get(8).setStatus(true);
        }
        else if (Indices.get(1)>54)
        {
            diseases.get(8).setStatus(true);
        }
    }

    private void Lymph()
    {
        if (Indices.get(2)<36)
        {
            diseases.get(4).setStatus(true);
        }
        else if (Indices.get(2)>52)
        {
            diseases.get(8).setStatus(true);
            diseases.get(22).setStatus(true);
        }
    }

    private void RBC()
    {
        if(Indices.get(3)<4.5)
        {
            diseases.get(0).setStatus(true);
            diseases.get(2).setStatus(true);
        }
        else if(Indices.get(3)>6)
        {
            diseases.get(4).setStatus(true);
            diseases.get(18).setStatus(true);
            diseases.get(19).setStatus(true);
        }
    }

    private void HCT()
    {
        if(this.Gender.equals("Male"))
        {
            if(Indices.get(4)<37)
            {
                diseases.get(2).setStatus(true);
                diseases.get(0).setStatus(true);

            }
            else if(Indices.get(4)>54)
            {
                if(this.Smoke.equals("Yes"))
                    diseases.get(18).setStatus(true);
            }
        }
        else if(this.Gender.equals("Female"))
        {
            if(Indices.get(4)<33)
            {
                diseases.get(2).setStatus(true);
                diseases.get(0).setStatus(true);

            }
            else if(Indices.get(4)>47)
            {
                if(this.Smoke.equals("Yes"))
                    diseases.get(18).setStatus(true);
            }
        }
    }

    private void Urea()
    {
        if(this.Community.equals("Mizrahi"))
        {
            if (Indices.get(5)<18.7)
            {
                diseases.get(25).setStatus(true);
                diseases.get(1).setStatus(true);
                diseases.get(14).setStatus(true);
            }
            else if(Indices.get(5)>47.3)
            {
                if(this.Gender.equals("Female"))
                    str+='\n'+"עלול להיות תוצאות שונות אצל נשים בהריון"+'\n';
                diseases.get(15).setStatus(true);
                diseases.get(7).setStatus(true);
                diseases.get(1).setStatus(true);
            }
        }
        else if (Indices.get(5)<17)
        {
            diseases.get(25).setStatus(true);
            diseases.get(1).setStatus(true);
            diseases.get(14).setStatus(true);
        }
        else if(Indices.get(5)>43)
        {
            if(this.Gender.equals("Female"))
                str+='\n'+"עלול להיות תוצאות שונות אצל נשים בהריון"+'\n';
            diseases.get(15).setStatus(true);
            diseases.get(7).setStatus(true);
            diseases.get(1).setStatus(true);
        }
    }

    private void HB()
    {
        if(Age>=0 && Age<=17) {
            if (Indices.get(6) < 11.5) {
                diseases.get(0).setStatus(true);
                diseases.get(5).setStatus(true);
                diseases.get(16).setStatus(true);
                diseases.get(2).setStatus(true);
            }
        }
        else if(Indices.get(6)<12)
        {
            diseases.get(0).setStatus(true);
            diseases.get(5).setStatus(true);
            diseases.get(16).setStatus(true);
            diseases.get(2).setStatus(true);
        }
    }

    private void Cretinine()
    {
        if(Age>=0 && Age<=2)
        {
            if (Indices.get(7)<0.2)
            {
                diseases.get(17).setStatus(true);
                diseases.get(25).setStatus(true);
            }
            else if (Indices.get(7)>0.5)
            {
                diseases.get(15).setStatus(true);
                diseases.get(17).setStatus(true);
                diseases.get(23).setStatus(true);
            }
        }
        else if (Age>=3 && Age<=17)
        {
            if (Indices.get(7)<0.5)
            {
                diseases.get(17).setStatus(true);
                diseases.get(25).setStatus(true);
            }
            else if (Indices.get(7)>1)
            {
                diseases.get(15).setStatus(true);
                diseases.get(17).setStatus(true);
                diseases.get(23).setStatus(true);
            }
        }
        else if (Age>=18 && Age<=59)
        {
            if (Indices.get(7)<0.6)
            {
                diseases.get(17).setStatus(true);
                diseases.get(25).setStatus(true);
            }
            else if (Indices.get(7)>1)
            {
                diseases.get(15).setStatus(true);
                diseases.get(17).setStatus(true);
                diseases.get(23).setStatus(true);
            }
        }
        else if (Age>=60)
        {
            if (Indices.get(7)<0.6)
            {
                diseases.get(17).setStatus(true);
                diseases.get(25).setStatus(true);
            }
            else if (Indices.get(7)>1.2)
            {
                diseases.get(15).setStatus(true);
                diseases.get(17).setStatus(true);
                diseases.get(23).setStatus(true);
            }
        }

    }
    private void Iron()
    {
        if(this.Gender.equals("Female"))
        {
            if(Indices.get(8)<48) {
                diseases.get(25).setStatus(true);
                diseases.get(2).setStatus(true);
                }
            else if(Indices.get(8)>128)
                diseases.get(6).setStatus(true);
        }
        else if(Indices.get(8)<60)
        {
            diseases.get(25).setStatus(true);
            diseases.get(2).setStatus(true);
        }
        else if (Indices.get(8)>160)
        {
            diseases.get(6).setStatus(true);
        }
    }

    private void HDL()
    {
        if (this.Community.equals("Dark Skinned"))
        {
            if (this.Gender.equals("Male")) {
                if (Indices.get(9) < 34.8) {
                    diseases.get(12).setStatus(true);
                    diseases.get(3).setStatus(true);
                    diseases.get(21).setStatus(true);
                } else if (Indices.get(9) > 74.4) {
                    str+="High HDL\n";
                    str+="לרוב אינן מזיקות. פעילות גופנית מעלה את רמות הכולסטרול הטוב\n";
                }
            } else if (this.Gender.equals("Female")) {
                if (Indices.get(9) < 40.8) {
                    diseases.get(12).setStatus(true);
                    diseases.get(3).setStatus(true);
                    diseases.get(21).setStatus(true);
                } else if (Indices.get(9) > 98.4) {
                    str+="High HDL\n";
                    str+="לרוב אינן מזיקות. פעילות גופנית מעלה את רמות הכולסטרול הטוב\n";
                }
            }
        }
        else
        {
            if (this.Gender.equals("Male"))
            {
                if (Indices.get(9) < 29)
                {
                    diseases.get(12).setStatus(true);
                    diseases.get(3).setStatus(true);
                    diseases.get(21).setStatus(true);
                } else if (Indices.get(9) > 62)
                {
                    str+="High HDL\n";
                    str+="לרוב אינן מזיקות. פעילות גופנית מעלה את רמות הכולסטרול הטוב\n";
                }
            }
            else if (this.Gender.equals("Female"))
            {
                if (Indices.get(9) < 34)
                {
                    diseases.get(12).setStatus(true);
                    diseases.get(3).setStatus(true);
                    diseases.get(21).setStatus(true);
                }
                else if (Indices.get(9) > 82)
                {
                    str+="High HDL\n";
                    str+="לרוב אינן מזיקות. פעילות גופנית מעלה את רמות הכולסטרול הטוב\n";
                }
            }
        }

    }

    private void Alkaline()
    {
        if(this.Community.equals("Mizrahi"))
        {
            if(Indices.get(10)<60)
            {
                diseases.get(25).setStatus(true);
                diseases.get(9).setStatus(true);
            }
            else if (Indices.get(10)>120)
            {
                diseases.get(14).setStatus(true);
                diseases.get(11).setStatus(true);
                diseases.get(20).setStatus(true);
                diseases.get(24).setStatus(true);
            }
        }
        else
        {
            if(Indices.get(10)<30)
            {
                diseases.get(25).setStatus(true);
                diseases.get(9).setStatus(true);
            }
            else if (Indices.get(10)>90)
            {
                diseases.get(14).setStatus(true);
                diseases.get(11).setStatus(true);
                diseases.get(20).setStatus(true);
                diseases.get(24).setStatus(true);
            }
        }
    }

    private void diagnose()
    {
        WBC();
        Neut();
        Lymph();
        RBC();
        HCT();
        Urea();
        HB();
        Cretinine();
        Iron();
        HDL();
        Alkaline();
    }

    public int getmNEUT() { return mNEUT; }

    public void setmNEUT(int mNEUT) { this.mNEUT = mNEUT; }

    public int getmLYMPH() { return mLYMPH; }

    public void setmLYMPH(int mLYMPH) { this.mLYMPH = mLYMPH; }

    public int getmRBC() { return mRBC; }

    public void setmRBC(int mRBC) { this.mRBC = mRBC; }

    public int getmHCT() { return mHCT; }

    public void setmHCT(int mHCT) { this.mHCT = mHCT; }

    public int getmUREA() { return mUREA; }

    public void setmUREA(int mUREA) { this.mUREA = mUREA; }

    public int getmHB() { return mHB; }

    public void setmHB(int mHB) { this.mHB = mHB; }

    public int getmCREATININE() { return mCREATININE; }

    public void setmCREATININE(int mCREATININE) { this.mCREATININE = mCREATININE; }

    public int getmIRON() { return mIRON; }

    public void setmIRON(int mIRON) { this.mIRON = mIRON; }

    public int getmHDL() { return mHDL; }

    public void setmHDL(int mHDL) { this.mHDL = mHDL; }

    public int getmALKALINE() { return mALKALINE; }

    public void setmALKALINE(int mALKALINE) { this.mALKALINE = mALKALINE; }

    public String getName() { return Name; }

    public void setName(String name) { Name = name; }

    public long getID() { return ID; }

    public void setID(long ID) { this.ID = ID; }

    public String isGender() { return Gender; }

    public void setGender(String gender) { Gender = gender; }

    public String isSmoke() {return Smoke;}

    public void setSmoke(String smoke) {Smoke=smoke;}

    public String getDrawSkin() {return Community; }

    public void setDrakSkin(String darkSkin) { Community = darkSkin;}

    public int getmWBC() { return mWBC; }

    public void setmWBC(int mWBC) { this.mWBC = mWBC; }

    public ArrayList<Float> getIndices() {return Indices; }

    public String getStr() { return str; }

    public void setStr(String str) { this.str = str; }

    public void setIndices(ArrayList<Float> indices) {Indices.addAll(indices);}

    public ArrayList<Disease> getDiseases() {return diseases;}

    public void setDiseases() {
        diseases = new ArrayList<>();
        diseases.add(new Disease(0, "אנמיה", "שני כדורי 10 מג של B12 ביום למשך חודש"));
        diseases.add(new Disease(1, "דיאטה", "לתאם פגישה עם תזונאי"));
        diseases.add(new Disease(2, "דימום", "להתפנות בדחיפות לבית החולים"));
        diseases.add(new Disease(3, "היפרליפידמיה - שומנים בדם", "לתאם פגישה עם תזונאי, כדור 5 מג של סימוביל ביום למשך שבוע"));
        diseases.add(new Disease(4, "הפרעה ביצירת הדם/תאי הדם", "כדור 10 מג של B12 ביום למשך חודש + כדור 5 מג של חומצה פולית ביום למשך חודש "));
        diseases.add(new Disease(5, "הפרעה המטולוגית", "זריקה של הורמון לעידוד ייצור תאי הדם האדומים"));
        diseases.add(new Disease(6, "הרעלת ברזל", "להתפנות לבית החולים"));
        diseases.add(new Disease(7, "התייבשות", "מנוחה מוחלטת בשכיבה, החזרת נוזלים בשתייה"));
        diseases.add(new Disease(8, "זיהום", "אנטיביוטיקה ייעודית"));
        diseases.add(new Disease(9, "חוסר בוויטמינים", "הפנייה לבדיקת דם לזיהוי הוויטמינים החסרים"));
        diseases.add(new Disease(10, "מחלה ויראלית", "לנוח בבית"));
        diseases.add(new Disease(11, "מחלות בדרכי המרה", "הפנייה לטיפול כירורגי"));
        diseases.add(new Disease(12, "מחלות לב", "לתאם פגישה עם תזונאי"));
        diseases.add(new Disease(13, "מחלת דם", "שילוב של ציקלופוספאמיד וקורטיקוסרואידים"));
        diseases.add(new Disease(14, "מחלת כבד", "הפנייה לאבחנה ספציפית לצורך קביעת טיפול"));
        diseases.add(new Disease(15, "מחלת כליה", "איזון את רמות הסוכר בדם"));
        diseases.add(new Disease(16, "מחסור בברזל", "שני כדורי 10 מג של B12 ביום למשך חודש"));
        diseases.add(new Disease(17, "מחלות שריר", "שני כדורי 5 מג של כורכום c3 של אלטמן ביום למשך חודש"));
        diseases.add(new Disease(18, "מעשנים", "להפסיק לעשן"));
        diseases.add(new Disease(19, "מחלת ריאות", "להפסיק לעשן / הפנייה לצילום רנטגן של הריאות"));
        diseases.add(new Disease(20, "פעילות יתר של בלוטת התריס", "Propylthiouracil להקטנת פעילות בלוטת התריס"));
        diseases.add(new Disease(21, "סוכרת מבוגרים", "התאמת אינסולין למטופל"));
        diseases.add(new Disease(22, "סרטן", "אנטרקטיניב - Entrectinib"));
        diseases.add(new Disease(23, "צריכה מוגברת של בשר", "לתאם פגישה עם תזונאי"));
        diseases.add(new Disease(24, "שימוש בתרופות שונות", "הפנייה לרופא המשפחה לצורך בדיקת התאמה בין התרופות"));
        diseases.add(new Disease(25, "תת תזונה", "לתאם פגישה עם תזונאי"));
    }

    @Override
    public String toString() {
        boolean healthy = true;
        for (int i=0;i< diseases.size();i++)
        {
            if (diseases.get(i).getStatus())
            {
                healthy = false;
                str += diseases.get(i).getDiagnosis();
                str += "\n";
                str += diseases.get(i).getTreatment();
                str += "\n\n";
            }
        }
        if (healthy)
            str+= '\n'+"You Are Healthy!";
        return str;
    }
}
