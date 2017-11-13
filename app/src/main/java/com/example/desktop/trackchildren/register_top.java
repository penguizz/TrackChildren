package com.example.desktop.trackchildren;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class register_top extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_top);

        String text = getString(R.string.msg_sample);
        String linkText = getString(R.string.msg_linkable);
        int start = text.indexOf(linkText);
        int end = start + linkText.length();

        SpannableString spannableString = new SpannableString(text);
        spannableString.setSpan(new CallToast(), start, end, 0);

        TextView textView = (TextView) findViewById(R.id.text_view);
        textView.setText(spannableString);
        textView.setMovementMethod(new LinkMovementMethod());
    }

    private class CallToast extends ClickableSpan {
        @Override
        public void onClick(View widget) {
            Toast.makeText(register_top.this, R.string.yeah, Toast.LENGTH_SHORT).show();
        }
    }
}