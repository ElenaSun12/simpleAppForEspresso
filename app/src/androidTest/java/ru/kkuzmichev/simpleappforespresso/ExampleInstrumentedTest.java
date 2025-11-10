package ru.kkuzmichev.simpleappforespresso;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Context;
import android.content.Intent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.allOf;
import static org.junit.Assert.*;
import static ru.kkuzmichev.simpleappforespresso.OpenGoogleTest.childAtPosition;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testSettingsIntent1() {
        Intents.init();

        try {
            onView(withContentDescription("More options")).perform(click());
            onView(withText("Settings")).perform(click());

            intended(allOf(
                    hasAction(Intent.ACTION_VIEW),
                    hasData("https://google.com")
            ));
        } catch (Exception e) {

            throw new RuntimeException("Test failed", e);
        } finally {
            Intents.release();
        }
    }

//    @Test
//    public void useAppContext() {
//        // Context of the app under test.
//        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
//        assertEquals("ru.kkuzmichev.simpleappforespresso", appContext.getPackageName());
//    }

//    @Test
//    public void testSettingsIntent() {
//        try {
//            ViewInteraction overflowMenuButton = onView(
//                    allOf(withContentDescription("More options"),
//                            childAtPosition(
//                                    childAtPosition(
//                                            withId(R.id.toolbar),
//                                            2),
//                                    0),
//                            isDisplayed()));
//            overflowMenuButton.perform(click());
//
//            ViewInteraction settingsItem = onView(
//                    allOf(withId(android.R.id.title), withText("Settings"),
//                            childAtPosition(
//                                    childAtPosition(
//                                            withId(androidx.constraintlayout.widget.R.id.content),
//                                            0),
//                                    0),
//                            isDisplayed()));
//            settingsItem.perform(click());
//
//            intended(allOf(
//                    hasAction(Intent.ACTION_VIEW),
//                    hasData("https://google.com")
//            ));
//
//        } catch (Exception e) {
//            throw new RuntimeException("Test failed", e);
//        }
//    }

//    @Test
//    public void testHomeFragmentText() {
//        ViewInteraction mainText = onView(
//                withId(R.id.textView3)
//        );
//        mainText.check(
//                matches(
//                        withText("This is home fragment")
//                )
//        );
//    }
}