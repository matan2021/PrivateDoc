package net.smallacademy.myprivatedoc;
import java.util.ArrayList;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class JunitAssertion
{
    MainActivity dc;
    Patient p1, p2;
    private ArrayList<Float> Indices=new ArrayList<Float>(0);
    private ArrayList<Float> Indices2=new ArrayList<Float>(0);
    //EditText nameString=findViewById(R.id.PatientFullName);

//    private void backGroundToChange(int position) {
//        String resourceName = "TextView" + position;
//        int resourceID = getResources().getIdentifier(resourceName, "id",
//                getPackageName());
//        if (resourceID != 0) {
//            TextView tv = (TextView) findViewById(resourceID);
//            if (tv != null) {
//                // Take action on TextView tv here...
//                tv.setBackgroundResource(R.drawable.option_correct);
//            }
//        }
//    }

    public void setUP()
    {
        dc=new MainActivity();
//        p1=new Patient( findViewById(R.id.PatientFullName),"205577341","26","Male","Yes","Mizrahi",Indices);

       //p2=new Patient( "Chen","316451517","24","Female","No","Ashkenazi",Indices2);
    }
}
