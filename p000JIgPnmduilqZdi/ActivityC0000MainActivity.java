package p000JIgPnmduilqZdi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.p001ecdaf.p002ecdaf.R;

/* JADX INFO: renamed from: JIgPnmduilqZdi.MainActivity */
/* JADX INFO: loaded from: classes.dex */
public class ActivityC0000MainActivity extends Activity {
    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.attr.f6SharedValue);
        TextView textView = (TextView) findViewById(R.array.auto_home_filter_tag);
        StringBuilder sb = new StringBuilder();
        sb.append("dpt-shell seem not working.\nApplication: ");
        sb.append(getApplication().getClass().getName());
        textView.setText(sb);
    }
}
