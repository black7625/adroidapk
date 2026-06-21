package p003idZqliudmnPgIJ;

import android.content.pm.ApplicationInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: renamed from: idZqliudmnPgIJ.a */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0003a {

    /* JADX INFO: renamed from: a */
    public static volatile boolean f1177a = false;

    /* JADX INFO: renamed from: b */
    public static volatile boolean f1178b = true;

    /* JADX INFO: renamed from: a */
    public static String m14a() {
        try {
            Class<?> cls = Class.forName("dalvik.system.VMRuntime");
            return (String) cls.getDeclaredMethod("vmInstructionSet", null).invoke(cls.getDeclaredMethod("getRuntime", null).invoke(null, null), null);
        } catch (Exception e) {
            e.printStackTrace();
            return "arm64";
        }
    }

    /* JADX INFO: renamed from: b */
    public static ApplicationInfo m15b() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Field declaredField = cls.getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Field declaredField2 = cls.getDeclaredField("mBoundApplication");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            Field declaredField3 = obj2.getClass().getDeclaredField("appInfo");
            declaredField3.setAccessible(true);
            return (ApplicationInfo) declaredField3.get(obj2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00cc, code lost:
    
        r10 = new byte[4096];
        r2 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(r2));
        r0 = new java.io.BufferedInputStream(r11.getInputStream(r6));
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00e1, code lost:
    
        r11 = r0.read(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00e5, code lost:
    
        if (r11 == (-1)) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00e7, code lost:
    
        r2.write(r10, 0, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ec, code lost:
    
        r6.getName();
        r6.getCrc();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00f2, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00f6, code lost:
    
        r10 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00f7, code lost:
    
        r10.printStackTrace();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v3, types: [java.util.Enumeration] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0097 -> B:46:0x00a4). Please report as a decompilation issue!!! */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m16c(String str, String str2) {
        CheckedInputStream checkedInputStream;
        String strM14a = m14a();
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        String str3 = File.separator;
        sb.append(str3);
        sb.append("dpt-libs");
        sb.append(str3);
        sb.append(strM14a);
        String str4 = "assets/vwwwwwvwww/" + strM14a + "/lib5057b7fffec73664.so";
        String absolutePath = new File(sb.toString()).getAbsolutePath();
        System.currentTimeMillis();
        File file = new File(absolutePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(absolutePath + str3 + "lib5057b7fffec73664.so");
        long value = 0;
        if (file2.exists()) {
            CheckedInputStream checkedInputStream2 = null;
            try {
                try {
                    checkedInputStream = new CheckedInputStream(new FileInputStream(file2), new CRC32());
                } catch (Throwable unused) {
                }
                try {
                    while (checkedInputStream.read(new byte[4096]) != -1) {
                    }
                    value = checkedInputStream.getChecksum().getValue();
                    checkedInputStream.close();
                } catch (Throwable unused2) {
                    checkedInputStream2 = checkedInputStream;
                    if (checkedInputStream2 != null) {
                        checkedInputStream2.close();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            ZipFile zipFile = new ZipFile(str);
            str = zipFile.entries();
            while (true) {
                if (!str.hasMoreElements()) {
                    break;
                }
                ZipEntry zipEntry = (ZipEntry) str.nextElement();
                if (zipEntry.getName().equals(str4) && value != zipEntry.getCrc()) {
                    break;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        System.currentTimeMillis();
    }
}
