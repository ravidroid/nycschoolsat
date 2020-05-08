package com.schools.nyc;

import android.content.Context;
import android.content.Intent;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.schools.nyc.ui.NYCSchoolsActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static androidx.test.espresso.action.ViewActions.click;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class NYCSchoolsUIInstrumentedTest {

    @Rule
    public ActivityTestRule<NYCSchoolsActivity> mActivityRule = new ActivityTestRule<>(
            NYCSchoolsActivity.class);
    @Test
    public void launchActivity() throws InterruptedException {
        // Context of the app under test.
        Intent intent = new Intent();
       NYCSchoolsActivity nycSchoolsActivity = mActivityRule.launchActivity(intent);

       Thread.sleep(3000);
        assertEquals("com.nyc.schools", nycSchoolsActivity.getPackageName());

    }

    @Test
    public void testRecyclerView(){
        if (getRVcount() > 0){

            onView(withId(R.id.places_list_recycler_view)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        }
    }

    private int getRVcount(){
        RecyclerView recyclerView = (RecyclerView) mActivityRule.getActivity().findViewById(R.id.places_list_recycler_view);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return recyclerView.getAdapter().getItemCount();
    }
}
