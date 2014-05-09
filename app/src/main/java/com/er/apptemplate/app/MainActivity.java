package com.er.apptemplate.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.newrelic.agent.android.NewRelic;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Move this to defaultActivity
        NewRelic.withApplicationToken(
                "new-relic-token" //TODO: Change Token For project
        ).start(this.getApplication());

        // Get tracker.
        Tracker t = ((TemplateApplication) this.getApplication()).getTracker(
                TemplateApplication.TrackerName.APP_TRACKER);

        // Set screen name.
        // Where path is a String representing the screen name.
        t.setScreenName("Main");

        // Send a screen view.
        t.send(new HitBuilders.AppViewBuilder().build());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
