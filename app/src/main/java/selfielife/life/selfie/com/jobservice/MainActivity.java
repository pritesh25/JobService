package selfielife.life.selfie.com.jobservice;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG =MainActivity.class.getSimpleName() ;

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"activity main launch");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            JobScheduler jobScheduler = (JobScheduler) getApplicationContext().getSystemService(Context.JOB_SCHEDULER_SERVICE);
            JobInfo jobInfo = new JobInfo.Builder(1, new ComponentName(getApplicationContext(), TestJobService.class.getName()))
                    //only add if network access is required
                    .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                    //.setRequiresDeviceIdle(true)
                    .build();
            jobScheduler.schedule(jobInfo);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"cant available this feature on your device",Toast.LENGTH_LONG).show();
        }
    }
}