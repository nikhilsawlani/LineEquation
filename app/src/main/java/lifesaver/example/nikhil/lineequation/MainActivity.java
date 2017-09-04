package lifesaver.example.nikhil.lineequation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.Viewport;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.PointsGraphSeries;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {




    private Button SetPoint,clearpoint;
    public EditText slope;
    private EditText constant;

    GraphView graphView;
   double slopeVar, constantVar, deg;
    private TextView vertical,horizontal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SetPoint = (Button) findViewById(R.id.button);
        vertical= (TextView)findViewById(R.id.textView3);
        horizontal=(TextView)findViewById(R.id.textView4);


        init();

    }

    public  void init(){
        SetPoint.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                slope = (EditText) findViewById(R.id.slope);
                constant = (EditText) findViewById(R.id.constant);
                try {
                    slopeVar=Double.parseDouble(slope.getText().toString());
                    constantVar=Integer.parseInt(constant.getText().toString());
                    deg =Math.toDegrees(slopeVar);

                }catch (NumberFormatException e){
                   toast("enter values ");

                }

                graph();
            }

        });

    }
    public void toast(String message){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    public void graph(){

        graphView = (GraphView) findViewById(R.id.graphView);
        LineGraphSeries<DataPoint>  series = new LineGraphSeries<DataPoint>(new DataPoint[]{
        new DataPoint(0,0),
        new DataPoint((constantVar*Math.cos(deg)),(constantVar*Math.sin(deg)))
        });
        graphView.addSeries(series);

    }




    }






