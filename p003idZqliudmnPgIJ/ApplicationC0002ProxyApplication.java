package p003idZqliudmnPgIJ;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import java.util.Objects;

/* JADX INFO: renamed from: idZqliudmnPgIJ.ProxyApplication */
/* JADX INFO: loaded from: classes.dex */
public class ApplicationC0002ProxyApplication extends Application {

    /* JADX INFO: renamed from: a */
    public String f1174a = "";

    /* JADX INFO: renamed from: b */
    public Application f1175b = null;

    /* JADX INFO: renamed from: a */
    public final void m11a() {
        if (!AbstractC0003a.f1178b || TextUtils.isEmpty(this.f1174a)) {
            return;
        }
        Application application = (Application) C0001JniBridge.m7ra(this.f1174a);
        this.f1175b = application;
        application.getClass();
        C0001JniBridge.m2craa(getApplicationContext(), this.f1174a);
        C0001JniBridge.m3craoc(this.f1174a);
        AbstractC0003a.f1178b = false;
    }

    @Override // android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        Objects.toString(context.getClassLoader());
        if (!AbstractC0003a.f1177a) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null) {
                throw new NullPointerException("application info is null");
            }
            AbstractC0003a.m16c(applicationInfo.sourceDir, applicationInfo.dataDir);
            C0001JniBridge.m0a(applicationInfo.dataDir);
            C0001JniBridge.m6ia();
            C0001JniBridge.m1cbde(context.getClassLoader());
            AbstractC0003a.f1177a = true;
        }
        this.f1174a = C0001JniBridge.m8rapn();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context createPackageContext(String str, int i) {
        if (TextUtils.isEmpty(this.f1174a)) {
            return super.createPackageContext(str, i);
        }
        m11a();
        return this.f1175b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final String getPackageName() {
        return !TextUtils.isEmpty(this.f1174a) ? "" : super.getPackageName();
    }

    @Override // android.app.Application
    public final void onCreate() {
        super.onCreate();
        m11a();
    }
}
