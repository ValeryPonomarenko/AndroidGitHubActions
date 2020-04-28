package github.actions.android

import androidx.annotation.StringRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.doubleClick
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    val rule = ActivityTestRule(MainActivity::class.java)

    private val textReverser = TextReverser()

    @Test
    fun helloWorldIsDisplayed() {
        onView(withId(R.id.text_main)).check(matches(withText(R.string.hello_world)))
    }

    @Test
    fun onClickMeButtonClicked() {
        onView(withId(R.id.text_main)).check(matches(withText(R.string.hello_world)))

        onView(withId(R.id.button_click_me)).perform(click())

        val reversedText = textReverser.reverse(getResourceString(R.string.hello_world))
        onView(withId(R.id.text_main)).check(matches(withText(reversedText)))
    }

    @Test
    fun onClickMeButtonDoubleClicked() {
        onView(withId(R.id.text_main)).check(matches(withText(R.string.hello_world)))

        onView(withId(R.id.button_click_me)).perform(doubleClick())

        onView(withId(R.id.text_main)).check(matches(withText(R.string.hello_world)))
    }

    private fun getResourceString(@StringRes id: Int): String {
        val targetContext = InstrumentationRegistry.getInstrumentation().targetContext
        return targetContext.resources.getString(id)
    }

}