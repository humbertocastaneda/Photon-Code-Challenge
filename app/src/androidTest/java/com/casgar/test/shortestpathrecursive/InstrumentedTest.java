package com.casgar.test.shortestpathrecursive;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.widget.TextView;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class InstrumentedTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);
    @Test
    public void testAppUIInput() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();

        for (final InstrumentedTestEnum testEnum : InstrumentedTestEnum.values()) {
            onView(withId(R.id.etMatrix)).perform(typeText(testEnum.getMatrix()));
            onView(withId(R.id.bStart)).perform(click());
            onView(withId(R.id.tvResult)).perform(new ViewAction() {
                @Override
                public Matcher<View> getConstraints() {
                    return isAssignableFrom(TextView.class);
                }

                @Override
                public String getDescription() {
                    return "get text from text view";
                }

                @Override
                public void perform(UiController uiController, View view) {
                    String test = ((TextView) view).getText().toString();
                    assertEquals(testEnum.getResult(), test);
                }
            });

            onView(withId(R.id.etMatrix)).perform(clearText());
        }



    }


}
