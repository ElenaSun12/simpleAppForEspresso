package ru.kkuzmichev.simpleappforespresso;

import static androidx.test.espresso.matcher.ViewMatchers.*;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.matcher.BoundedMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class CustomViewMatcher {
    public static BoundedMatcher<View, RecyclerView> recyclerViewSizeViewMacher(int matcherSize) {
        return new BoundedMatcher<View, RecyclerView>(RecyclerView.class) {

            private String result;

            @Override
            public void describeTo(Description description) {
                description.appendText("RecyclerView with" + matcherSize);
                description.appendText("Actual list size: ");
                description.appendText(result);
            }

            @Override
            protected boolean matchesSafely(RecyclerView recyclerView) {
                int items = recyclerView.getAdapter().getItemCount();
                result = "List size: " + items;
                return matcherSize == items;
            }
        };
    }
}