package p003idZqliudmnPgIJ;

import android.content.Context;
import java.io.File;

/* JADX INFO: renamed from: idZqliudmnPgIJ.JniBridge */
/* JADX INFO: loaded from: classes.dex */
public class C0001JniBridge {
    /* JADX INFO: renamed from: a */
    public static void m0a(String str) {
        String[] strArr = {"lib5057b7fffec73664.so"};
        try {
            String strM14a = AbstractC0003a.m14a();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            String str2 = File.separator;
            sb.append(str2);
            sb.append("dpt-libs");
            sb.append(str2);
            sb.append(strM14a);
            File[] fileArrListFiles = new File(sb.toString()).listFiles();
            if (fileArrListFiles != null) {
                for (File file : fileArrListFiles) {
                    String absolutePath = file.getAbsolutePath();
                    if (absolutePath.endsWith(File.separator + strArr[0])) {
                        System.load(absolutePath);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: cbde */
    public static native void m1cbde(ClassLoader classLoader);

    /* JADX INFO: renamed from: craa */
    public static native void m2craa(Context context, String str);

    /* JADX INFO: renamed from: craoc */
    public static native void m3craoc(String str);

    /* JADX INFO: renamed from: gap */
    public static native String m4gap();

    /* JADX INFO: renamed from: gdp */
    public static native String m5gdp();

    /* JADX INFO: renamed from: ia */
    public static native void m6ia();

    /* JADX INFO: renamed from: ra */
    public static native Object m7ra(String str);

    /* JADX INFO: renamed from: rapn */
    public static native String m8rapn();

    /* JADX INFO: renamed from: rcf */
    public static native String m9rcf();

    /* JADX INFO: renamed from: rde */
    public static native void m10rde(ClassLoader classLoader, String str);
}
