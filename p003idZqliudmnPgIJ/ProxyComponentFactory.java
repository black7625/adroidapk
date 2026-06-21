package p003idZqliudmnPgIJ;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class ProxyComponentFactory extends AppComponentFactory {

    /* JADX INFO: renamed from: a */
    public static AppComponentFactory f1176a;

    /* JADX INFO: renamed from: a */
    public static AppComponentFactory m13a(ClassLoader classLoader) {
        if (f1176a == null) {
            String strM9rcf = C0001JniBridge.m9rcf();
            if (!TextUtils.isEmpty(strM9rcf)) {
                try {
                    AppComponentFactory appComponentFactoryM17a = AbstractC0004b.m17a(Class.forName(strM9rcf, true, classLoader).newInstance());
                    f1176a = appComponentFactoryM17a;
                    return appComponentFactoryM17a;
                } catch (Exception unused) {
                }
            }
        }
        return f1176a;
    }

    @Override // android.app.AppComponentFactory
    public final Activity instantiateActivity(ClassLoader classLoader, String str, Intent intent) {
        Objects.toString(classLoader);
        Objects.toString(intent);
        AppComponentFactory appComponentFactoryM13a = m13a(classLoader);
        if (appComponentFactoryM13a != null) {
            try {
                return (Activity) AppComponentFactory.class.getDeclaredMethod("instantiateActivity", ClassLoader.class, String.class, Intent.class).invoke(appComponentFactoryM13a, classLoader, str, intent);
            } catch (Exception unused) {
            }
        }
        return super.instantiateActivity(classLoader, str, intent);
    }

    @Override // android.app.AppComponentFactory
    public final Application instantiateApplication(ClassLoader classLoader, String str) {
        AppComponentFactory appComponentFactoryM13a;
        Objects.toString(classLoader);
        if (!AbstractC0003a.f1177a) {
            if (AbstractC0003a.m15b() == null) {
                throw new NullPointerException("application info is null");
            }
            String str2 = AbstractC0003a.m15b().dataDir;
            AbstractC0003a.m16c(AbstractC0003a.m15b().sourceDir, str2);
            C0001JniBridge.m0a(str2);
        }
        C0001JniBridge.m6ia();
        String strM8rapn = C0001JniBridge.m8rapn();
        if (AbstractC0003a.f1177a) {
            appComponentFactoryM13a = m13a(classLoader);
        } else {
            C0001JniBridge.m1cbde(classLoader);
            AbstractC0003a.f1177a = true;
            appComponentFactoryM13a = m13a(classLoader);
        }
        AbstractC0003a.f1178b = false;
        if (appComponentFactoryM13a != null) {
            try {
                Method declaredMethod = appComponentFactoryM13a.getClass().getDeclaredMethod("instantiateApplication", ClassLoader.class, String.class);
                return !TextUtils.isEmpty(strM8rapn) ? (Application) declaredMethod.invoke(appComponentFactoryM13a, classLoader, strM8rapn) : (Application) declaredMethod.invoke(appComponentFactoryM13a, classLoader, str);
            } catch (Exception unused) {
            }
        }
        if (TextUtils.isEmpty(strM8rapn)) {
            return super.instantiateApplication(classLoader, str);
        }
        try {
            Class.forName(strM8rapn, false, classLoader);
        } catch (ClassNotFoundException unused2) {
            if (AbstractC0003a.m15b() != null) {
                strM8rapn = AbstractC0003a.m15b().packageName + "." + strM8rapn;
            }
        }
        return super.instantiateApplication(classLoader, strM8rapn);
    }

    @Override // android.app.AppComponentFactory
    public final ClassLoader instantiateClassLoader(ClassLoader classLoader, ApplicationInfo applicationInfo) {
        Objects.toString(classLoader);
        Objects.toString(applicationInfo);
        AbstractC0003a.m16c(applicationInfo.sourceDir, applicationInfo.dataDir);
        C0001JniBridge.m0a(applicationInfo.dataDir);
        C0001JniBridge.m6ia();
        AppComponentFactory appComponentFactoryM13a = m13a(classLoader);
        C0001JniBridge.m1cbde(classLoader);
        AbstractC0003a.f1177a = true;
        if (appComponentFactoryM13a != null) {
            try {
                return (ClassLoader) AppComponentFactory.class.getDeclaredMethod("instantiateClassLoader", ClassLoader.class, ApplicationInfo.class).invoke(appComponentFactoryM13a, classLoader, applicationInfo);
            } catch (Exception unused) {
            }
        }
        return super.instantiateClassLoader(classLoader, applicationInfo);
    }

    @Override // android.app.AppComponentFactory
    public final ContentProvider instantiateProvider(ClassLoader classLoader, String str) {
        Objects.toString(classLoader);
        AppComponentFactory appComponentFactoryM13a = m13a(classLoader);
        if (appComponentFactoryM13a != null) {
            try {
                return (ContentProvider) AppComponentFactory.class.getDeclaredMethod("instantiateProvider", ClassLoader.class, String.class).invoke(appComponentFactoryM13a, classLoader, str);
            } catch (Exception unused) {
            }
        }
        return super.instantiateProvider(classLoader, str);
    }

    @Override // android.app.AppComponentFactory
    public final BroadcastReceiver instantiateReceiver(ClassLoader classLoader, String str, Intent intent) {
        Objects.toString(classLoader);
        Objects.toString(intent);
        AppComponentFactory appComponentFactoryM13a = m13a(classLoader);
        if (appComponentFactoryM13a != null) {
            try {
                return (BroadcastReceiver) AppComponentFactory.class.getDeclaredMethod("instantiateReceiver", ClassLoader.class, String.class, Intent.class).invoke(appComponentFactoryM13a, classLoader, str, intent);
            } catch (Exception unused) {
            }
        }
        return super.instantiateReceiver(classLoader, str, intent);
    }

    @Override // android.app.AppComponentFactory
    public final Service instantiateService(ClassLoader classLoader, String str, Intent intent) {
        Objects.toString(classLoader);
        Objects.toString(intent);
        AppComponentFactory appComponentFactoryM13a = m13a(classLoader);
        if (appComponentFactoryM13a != null) {
            try {
                return (Service) AppComponentFactory.class.getDeclaredMethod("instantiateService", ClassLoader.class, String.class, Intent.class).invoke(appComponentFactoryM13a, classLoader, str, intent);
            } catch (Exception unused) {
            }
        }
        return super.instantiateService(classLoader, str, intent);
    }
}
