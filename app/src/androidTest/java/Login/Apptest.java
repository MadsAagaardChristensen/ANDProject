package Login;


import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class Apptest {

    @Rule
    public ActivityTestRule<Register> mActivityTestRule = new ActivityTestRule<>(Register.class);

    @Test
    public void apptest() {
    }
}
